package com.hfad.contactutils.controller.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.contactutils.R;
import com.hfad.contactutils.controller.adapter.HistoryAdapter;
import com.hfad.contactutils.controller.data.model.LocalHistoryObj;
import com.hfad.contactutils.controller.data.room.RoomDataBase;
import com.hfad.contactutils.controller.data.room.dao.LocalHistoryDao;

import java.util.List;

public class LocalHistoryFragment extends Fragment {
    private static final String TAG = "Local History Fragment";
    private RecyclerView mRecyclerView;
    private HistoryAdapter mHistoryAdapter;
    public LocalHistoryDao mLocalHistoryDao;
    MutableLiveData<List<LocalHistoryObj>> mListLiveData;

    public LocalHistoryFragment() {
        // Required empty public constructor
    }


    public static LocalHistoryFragment newInstance() {
        LocalHistoryFragment fragment = new LocalHistoryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RoomDataBase roomDataBase = RoomDataBase.getDataBase(getActivity());
        mLocalHistoryDao = roomDataBase.getLocalHistoryDAO();
        mHistoryAdapter = new HistoryAdapter(getActivity());
        mListLiveData = new MutableLiveData<>();
        mListLiveData.observe(this, new Observer<List<LocalHistoryObj>>() {
            @Override
            public void onChanged(List<LocalHistoryObj> localHistoryObjs) {
                mHistoryAdapter.setLocalHistoryObjList(localHistoryObjs);
                mHistoryAdapter.notifyDataSetChanged();
                Log.d(TAG, "observer Live data history " + localHistoryObjs.size());
            }
        });

        RoomDataBase.dataBaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mListLiveData.postValue(mLocalHistoryDao.getLocalHistory());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_local_history, container, false);

        mRecyclerView = view.findViewById(R.id.music_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mRecyclerView.setAdapter(mHistoryAdapter);

        return view;
    }
}