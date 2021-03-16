package com.hfad.contactutils.controller.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        mListLiveData=new MutableLiveData<>();
        mListLiveData.observe(this, new Observer<List<LocalContactObj>>() {
            @Override
            public void onChanged(List<LocalContactObj> localContactObjList) {
                mContactAdapter.setLocalContactObjList(localContactObjList);
                mContactAdapter.notifyDataSetChanged();
                Log.d(TAG,"observer Live data Contact"+localContactObjList.size());
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


        return view;
    }
}