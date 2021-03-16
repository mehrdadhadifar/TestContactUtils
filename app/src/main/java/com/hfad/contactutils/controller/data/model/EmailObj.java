package com.hfad.contactutils.controller.data.model;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tblEmailAddress")
public class EmailObj {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "EmailAddress")
    private String emailAddress;
    @ColumnInfo(name = "Id")
    private int id;
    @ColumnInfo(name = "_Id")
    private String _id;
    @ColumnInfo(name = "LocalContactFullName")
    private String localContactFullName;
    @ColumnInfo(name = "PalId")
    private String palId;
    @ColumnInfo(name = "Title")
    private String title;
    @ColumnInfo(name = "Approved")
    private Boolean approved = false;

    public EmailObj() {
    }

    public EmailObj(int id, String _id, String title, String emailAddress, String localContactFullName, String palId) {
        this.id = id;
        this._id = _id;
        this.localContactFullName = localContactFullName;
        this.palId = palId;
        this.title = title;
        this.emailAddress = emailAddress;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
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
}
