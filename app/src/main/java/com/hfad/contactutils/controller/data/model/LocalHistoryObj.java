package com.hfad.contactutils.controller.data.model;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "tblLocalHistory")
public class LocalHistoryObj {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "PK_Id")
    private int id;
    @ColumnInfo(name = "PalId")
    private String palId;
    @ColumnInfo(name = "ProfileImage")
    private String profileImage;
    @ColumnInfo(name = "CallDateTime")
    private Date callDateTime;
    @ColumnInfo(name = "CallDay")
    private String callDay;
    @ColumnInfo(name = "CallDayTime")
    private String callDayTime;
    @ColumnInfo(name = "PhNumber")
    private String phNumber;
    @ColumnInfo(name = "CallType")
    private CallType callType;
    @ColumnInfo(name = "CallDuration")
    private String callDuration;
    @ColumnInfo(name = "MessageText")
    private String messageText;
    @ColumnInfo(name = "NumberOfMessage")
    private String numberOfMessage;
    @ColumnInfo(name = "CallerName")
    private String callerName;
    @ColumnInfo(name = "NumberOfCall")
    private int numberOfCall;
    @ColumnInfo(name = "IsBubble")
    private boolean isBubbleObj;
    @ColumnInfo(name = "IsBubbleBiz")
    private boolean isBubbleBizObj;
    @ColumnInfo(name = "IsSection")
    public boolean isSection;

    public LocalHistoryObj() {
    }

    @Ignore
    public LocalHistoryObj(int id, Date callDateTime, String callDay, String callDayTime, String phNumber, CallType callType, String callDuration, String callerName) {
        this.id = id;
        this.callDateTime = callDateTime;
        this.callDay = callDay;
        this.callDayTime = callDayTime;
        this.phNumber = phNumber;
        this.callType = callType;
        this.callDuration = callDuration;
        this.callerName = callerName;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPalId() {
        return palId;
    }

    public void setPalId(String myPalId) {
        this.palId = myPalId;
    }

    public String getProfileImage() {
        return this.profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public Date getCallDateTime() {
        return this.callDateTime;
    }

    public void setCallDateTime(Date callDateTime) {
        this.callDateTime = callDateTime;
    }

    public String getCallDay() {
        return this.callDay;
    }

    public void setCallDay(String callDay) {
        this.callDay = callDay;
    }

    public String getCallDayTime() {
        return this.callDayTime;
    }

    public void setCallDayTime(String callDayTime) {
        this.callDayTime = callDayTime;
    }

    public String getPhNumber() {
        return this.phNumber;
    }

    public void setPhNumber(String phNumber) {
        this.phNumber = phNumber;
    }

    public CallType getCallType() {
        return callType;
    }

    public void setCallType(CallType callType) {
        this.callType = callType;
    }

    public String getCallDuration() {
        return this.callDuration;
    }

    public void setCallDuration(String callDuration) {
        this.callDuration = callDuration;
    }

    public String getMessageText() {
        return this.messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public int getNumberOfCall() {
        return this.numberOfCall;
    }

    public void setNumberOfCall() {
        this.numberOfCall++;
    }

    public String getNumberOfMessage() {
        return this.numberOfMessage;
    }

    public void setNumberOfMessage(String numberOfMessage) {
        this.numberOfMessage = numberOfMessage;
    }

    public String getCallerName() {
        return this.callerName;
    }

    public void setCallerName(String userName) {
        this.callerName = userName;
    }

    public boolean isSection() {
        return isSection;
    }

    public void setSection(boolean section) {
        isSection = section;
    }

    public void setNumberOfCall(int numberOfCall) {
        this.numberOfCall = numberOfCall;
    }

    public boolean isBubbleObj() {
        return isBubbleObj;
    }

    public void setBubbleObj(boolean bubbleObj) {
        isBubbleObj = bubbleObj;
    }

    public boolean isBubbleBizObj() {
        return isBubbleBizObj;
    }

    public void setBubbleBizObj(boolean bubbleBizObj) {
        isBubbleBizObj = bubbleBizObj;
    }
}
