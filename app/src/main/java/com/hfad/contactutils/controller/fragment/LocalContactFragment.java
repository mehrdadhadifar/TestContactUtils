package com.hfad.contactutils.controller.fragment;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.telephony.RadioAccessSpecifier;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hfad.contactutils.R;
import com.hfad.contactutils.controller.adapter.ContactAdapter;
import com.hfad.contactutils.controller.data.model.LocalContactObj;
import com.hfad.contactutils.controller.data.room.RoomDataBase;
import com.hfad.contactutils.controller.data.room.dao.LocalContactDao;

import java.util.ArrayList;
import java.util.List;


public class LocalContactFragment extends Fragment {
    private static final String TAG = "Local Contact Fragment";
    private RecyclerView mRecyclerView;
    private ContactAdapter mContactAdapter;
    public LocalContactDao localContactDAO;
    MutableLiveData<List<LocalContactObj>> mListLiveData;


    public LocalContactFragment() {
        // Required empty public constructor
    }

    public static LocalContactFragment newInstance() {
        LocalContactFragment fragment = new LocalContactFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RoomDataBase roomDataBase = RoomDataBase.getDataBase(getActivity());
        localContactDAO = roomDataBase.getLocalContactDAO();
        mContactAdapter = new ContactAdapter(getActivity());
        mListLiveData = new MutableLiveData<>();
        mListLiveData.observe(this, new Observer<List<LocalContactObj>>() {
            @Override
            public void onChanged(List<LocalContactObj> localContactObjList) {
                mContactAdapter.setLocalContactObjList(localContactObjList);
                mContactAdapter.notifyDataSetChanged();
                Log.d(TAG, "observer Live data Contact" + localContactObjList.size());
            }
        });

        RoomDataBase.dataBaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mListLiveData.postValue(localContactDAO.getLocalContacts());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_local_contact, container, false);
        mRecyclerView = view.findViewById(R.id.music_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
/*        if (mContactAdapter == null) {
            mContactAdapter = new ContactAdapter(getActivity());
            mRecyclerView.setAdapter(mContactAdapter);
        } else {
            mContactAdapter.notifyDataSetChanged();
        }*/
        mRecyclerView.setAdapter(mContactAdapter);

//        Log.d(TAG, "onCreateView: " + updateNameAndNumber(getContext(), "09128129969", "mona", "912"));
//        Log.d(TAG, "onCreateView: " + updateNameAndNumber(getContext(), "+989128129969", "mona", "912"));
//        Log.d(TAG, "onCreateView: " + updateNameAndNumber(getContext(), "00989128129969", "mona", "912"));

        test();

        return view;
    }

/*    private final static String[] DATA_COLS = {

            ContactsContract.Data.MIMETYPE,
            ContactsContract.Data.DATA1,//phone number
            ContactsContract.Data.CONTACT_ID
    };*/

/*

    public static boolean updateNameAndNumber(final Context context, String number, String newName, String newNumber) {

        if (context == null || number == null || number.trim().isEmpty()) return false;

        if (newNumber != null && newNumber.trim().isEmpty()) newNumber = null;

        if (newNumber == null) return false;


        String contactId = getContactId(context, number);

        if (contactId == null) {
            Log.d(TAG, "updateNameAndNumber: " + "contactId NULL");
            return false;
        }

        //selection for name
        String where = String.format(
                "%s = '%s' AND %s = ?",
                DATA_COLS[0], //mimetype
                ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE,
                DATA_COLS[2]*/
    /*contactId*//*
);

        String[] args = {contactId};

        ArrayList<ContentProviderOperation> operations = new ArrayList<>();

        operations.add(
                ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI)
                        .withSelection(where, args)
                        .withValue(ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME, newName)
                        .build()
        );

        //change selection for number
        where = String.format(
                "%s = '%s' AND %s = ?",
                DATA_COLS[0],//mimetype
                ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE,
                DATA_COLS[1]*/
    /*number*//*
);

        //change args for number
        args[0] = number;

        operations.add(
                ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI)
                        .withSelection(where, args)
                        .withValue(DATA_COLS[1]*/
    /*number*//*
, newNumber)
                        .build()
        );

        try {

            ContentProviderResult[] results = context.getContentResolver().applyBatch(ContactsContract.AUTHORITY, operations);

            for (ContentProviderResult result : results) {

                Log.d("Update Result", result.toString());
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

*/

    /*    public static String getContactId(Context context, String number) {

            if (context == null) return null;

            Cursor cursor = context.getContentResolver().query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    new String[]{ContactsContract.CommonDataKinds.Phone.CONTACT_ID, ContactsContract.CommonDataKinds.Phone.NUMBER},
                    ContactsContract.CommonDataKinds.Phone.NUMBER + "=?",
                    new String[]{number},
                    null
            );

            if (cursor == null || cursor.getCount() == 0) return null;

            cursor.moveToFirst();

            String id = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID));

            cursor.close();
            return id;
        }*/
    public void test() {
        ContentResolver contentResolver = getContext().getContentResolver();

        Uri uri = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode("09126268905"));

        String[] projection = new String[]{ContactsContract.PhoneLookup.DISPLAY_NAME, ContactsContract.PhoneLookup._ID};

        Cursor cursor =
                contentResolver.query(
                        uri,
                        projection,
                        null,
                        null,
                        null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                String contactName = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.PhoneLookup.DISPLAY_NAME));
                String contactId = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.PhoneLookup._ID));
                Log.d(TAG, "contactMatch name: " + contactName);
                Log.d(TAG, "contactMatch id: " + contactId);

                ContentValues contentValues = new ContentValues();
                contentValues.put(ContactsContract.CommonDataKinds.Phone.NUMBER, "09151110057");
                String where = ContactsContract.Data.CONTACT_ID + "=?" + " AND " + ContactsContract.Data.MIMETYPE + "=?" + " AND " + ContactsContract.CommonDataKinds.Phone.NUMBER + "=?";
                String[] whereArgs = {(contactId).toString(), ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE, "09126268905"};
                contentResolver.update(ContactsContract.Data.CONTENT_URI, contentValues, where, whereArgs);
            }
            cursor.close();
        }

    }

}