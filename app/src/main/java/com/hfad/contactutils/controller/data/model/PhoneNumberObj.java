package com.hfad.contactutils.controller.data.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tblPhoneNumber")
public class PhoneNumberObj {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "PK_PhoneNumber")
    private String phoneNumber;
    @ColumnInfo(name = "_Id")
    private String _id;
    @ColumnInfo(name = "Id")
    private int id;
    @ColumnInfo(name = "LocalContactFullName")
    private String localContactFullName;
    @ColumnInfo(name = "PalId")
    private String palId;
    @ColumnInfo(name = "Type")
    private String type;
    @ColumnInfo(name = "Approved")
    private Boolean approved;
    @ColumnInfo(name = "CountryCode")
    private String countryCode;

    public PhoneNumberObj() {
    }

    public PhoneNumberObj(String _id, int id, String phoneNumber, String type, Boolean approved, String countryCode, String localContactFullName, String palId) {
        this.phoneNumber = phoneNumber;
        this._id = _id;
        this.id = id;
        this.localContactFullName = localContactFullName;
        this.palId = palId;
        this.type = type;
        this.approved = approved;
        this.countryCode = countryCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLocalContactFullName() {
        return localContactFullName;
    }

    public void setLocalContactFullName(String localContactFullName) {
        this.localContactFullName = localContactFullName;
    }

    public String getPalId() {
        return palId;
    }

    public void setPalId(String palId) {
        this.palId = palId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

}
