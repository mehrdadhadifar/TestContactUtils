package com.hfad.contactutils.controller.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.contactutils.R;
import com.hfad.contactutils.controller.data.model.LocalContactObj;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactHolder> {
    public static final String TAG = "Contact Adapter";
    private Context mContext;
    private List<LocalContactObj> mLocalContactObjList;

    public ContactAdapter(Context context) {
        mContext = context;
        mLocalContactObjList = new ArrayList<>();
    }

    public void setLocalContactObjList(List<LocalContactObj> localContactObjList) {
        mLocalContactObjList = localContactObjList;
    }

    @NonNull
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_recycler_contact, parent, false);
        return new ContactHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactHolder holder, int position) {
        LocalContactObj contactObj = mLocalContactObjList.get(position);
        holder.bindLocalContact(contactObj);
    }

    @Override
    public int getItemCount() {
        return mLocalContactObjList.size();
    }

    public class ContactHolder extends RecyclerView.ViewHolder {
        private TextView mTextViewFullName;
        private TextView mTextViewPhoneNumber;
        private TextView mTextViewTotalDuration;


        public ContactHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewFullName = itemView.findViewById(R.id.contact_full_name);
            mTextViewPhoneNumber = itemView.findViewById(R.id.phone_number_text_view);
            mTextViewTotalDuration = itemView.findViewById(R.id.total_duration_text_view);

        }

        private void bindLocalContact(LocalContactObj localContactObj) {
            mTextViewFullName.setText(localContactObj.getFullName());
            mTextViewPhoneNumber.setText(localContactObj.getPrimaryNumber());
            mTextViewTotalDuration.setText(localContactObj.getTotalDuration());
            Log.d(TAG,"Bind Contact "+localContactObj.getFullName());
        }
    }

}
