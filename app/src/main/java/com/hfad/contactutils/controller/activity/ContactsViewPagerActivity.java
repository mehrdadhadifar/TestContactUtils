package com.hfad.contactutils.controller.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.hfad.contactutils.R;
import com.hfad.contactutils.controller.data.model.CallType;
import com.hfad.contactutils.controller.data.model.LocalContactObj;
import com.hfad.contactutils.controller.data.model.LocalHistoryObj;
import com.hfad.contactutils.controller.data.room.RoomDataBase;
import com.hfad.contactutils.controller.data.room.dao.LocalContactDao;
import com.hfad.contactutils.controller.data.room.dao.LocalHistoryDao;
import com.hfad.contactutils.controller.fragment.LocalContactFragment;
import com.hfad.contactutils.controller.fragment.LocalHistoryFragment;
import com.hfad.contactutils.controller.utils.RandomString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ContactsViewPagerActivity extends AppCompatActivity {
    public static final int PERMISSION_REQUEST_CODE = 1;
    //    private MusicRepository mRepository;
    private TabLayout mMusicTabLayout;
    private ViewPager2 mMusicViewPager;
    private ContactViewPagerAdapter mAdapter;
    public static final String TAG = "Contact View Pager";
    public LocalContactDao localContactDAO;
    public LocalHistoryDao localHistoryDao;
    private Random random = new Random();

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, ContactsViewPagerActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_view_pager);
//        mRepository=MusicRepository.getInstance(this);
        findAllViews();
        handelPermission();
        initData();
//        addDataToDataBase();
    }

    private void initData() {
        RoomDataBase roomDataBase = RoomDataBase.getDataBase(getApplicationContext());
        localContactDAO = roomDataBase.getLocalContactDAO();
        localHistoryDao = roomDataBase.getLocalHistoryDAO();
    }

    private void addDataToDataBase() {
        for (int i = 60; i < 600; i++) {
            LocalHistoryObj localHistoryObj = new LocalHistoryObj(i, new Date(), "Sun", "14:23", String.valueOf(random.nextLong()), CallType.OUT, "1:04", "Caller Name");
            LocalContactObj localContactObj = new LocalContactObj(new RandomString().nextString(), String.valueOf(random.nextLong()));
            localContactObj.setTotalDuration(random.nextInt(10) + ":" + random.nextInt(100));


            RoomDataBase.dataBaseWriteExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    localHistoryDao.insertLocalHistory(localHistoryObj);
                    localContactDAO.insertLocalContacts(localContactObj);
                    List<LocalContactObj> localContactObjs = localContactDAO.getLocalContacts();
                    Log.d(TAG, String.valueOf(localContactObjs.size()));
                }
            });
        }
    }

    private void handelPermission() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}
                    , PERMISSION_REQUEST_CODE);
        } else {
            Toast.makeText(this, "WELCOME", Toast.LENGTH_LONG).show();
            updateUI();
        }
    }

    private void updateUI() {
//        mRepository.getMusicList();
        mAdapter = new ContactViewPagerAdapter(this);
        mAdapter.addFragments(LocalContactFragment.newInstance());
        mAdapter.addFragments(LocalHistoryFragment.newInstance());
        mMusicViewPager.setAdapter(mAdapter);
        new TabLayoutMediator(mMusicTabLayout, mMusicViewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position == 0)
                    tab.setText("Contacts");
                else if (position == 1)
                    tab.setText("History");
            }
        }).attach();
    }


    private void findAllViews() {
        mMusicTabLayout = findViewById(R.id.tab_layout_music);
        mMusicViewPager = findViewById(R.id.view_pager_music);
    }

    public class ContactViewPagerAdapter extends FragmentStateAdapter {
        private List<Fragment> mFragmentList;

        public ContactViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
            mFragmentList = new ArrayList<>();
        }

        public void addFragments(Fragment fragment) {
            mFragmentList.add(fragment);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getItemCount() {
            return mFragmentList.size();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                updateUI();
            } else {
                finish();
            }
        }
    }
}