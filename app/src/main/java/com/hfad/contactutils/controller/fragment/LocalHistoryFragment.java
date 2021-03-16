package com.hfad.contactutils.controller.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hfad.contactutils.R;

public class LocalHistoryFragment extends Fragment {

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_local_history, container, false);
    }
}