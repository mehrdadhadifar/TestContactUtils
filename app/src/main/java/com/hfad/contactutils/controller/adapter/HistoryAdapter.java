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
import com.hfad.contactutils.controller.data.model.LocalHistoryObj;

import java.util.ArrayList;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryHolder> {
    public static final String TAG = "History Adapter";
    private Context mContext;
    private List<LocalHistoryObj> mLocalHistoryObjList;

    public HistoryAdapter(Context context) {
        mContext = context;
        mLocalHistoryObjList = new ArrayList<>();
    }

    public void setLocalHistoryObjList(List<LocalHistoryObj> localHistoryObjList) {
        mLocalHistoryObjList = localHistoryObjList;
    }

    @NonNull
    @Override
    public HistoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_recycler_history, parent, false);
        return new HistoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryHolder holder, int position) {
        LocalHistoryObj localHistoryObj = mLocalHistoryObjList.get(position);
        holder.bindLocalHistory(localHistoryObj);
    }

    @Override
    public int getItemCount() {
        return mLocalHistoryObjList.size();
    }

    public class HistoryHolder extends RecyclerView.ViewHolder {
        private TextView callerName;
        private TextView callType;
        private TextView callDuration;
        private TextView callNumber;
        private TextView callDetails;

        public HistoryHolder(@NonNull View itemView) {
            super(itemView);
            callerName = itemView.findViewById(R.id.caller_name_text_view);
            callType = itemView.findViewById(R.id.call_type_text_view);
            callDuration = itemView.findViewById(R.id.call_duration_text_view);
            callNumber = itemView.findViewById(R.id.call_number_text_view);
            callDetails = itemView.findViewById(R.id.call_details_text_view);

        }

        public void bindLocalHistory(LocalHistoryObj localHistoryObj) {
            callerName.setText(localHistoryObj.getCallerName());
            callType.setText(localHistoryObj.getCallType().toString());
            callDuration.setText(localHistoryObj.getCallDuration());
            callNumber.setText(localHistoryObj.getPhNumber());
            String detail = localHistoryObj.getCallDateTime() + "   " + localHistoryObj.getCallDay() + "    " + localHistoryObj.getCallDayTime();
            callDetails.setText(detail);
            Log.d(TAG, "Bind History " + localHistoryObj.getPhNumber());
        }
    }
}
