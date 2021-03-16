package com.hfad.contactutils.controller.data.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity(tableName = "tblLocalContact")
public class LocalContactObj {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "PK_FullName")
    private String fullName;
    @ColumnInfo(name = "PalId")
    private String palId;
    @ColumnInfo(name = "PrimaryNumber")
    private String primaryNumber;
    @Ignore
    private List<PhoneNumberObj> phoneNumbers;
    @Ignore
    private List<EmailObj> emails;
    //contact
    @ColumnInfo(name = "ImageUri")
    private String imageUri;
    //todo delete
    @ColumnInfo(name = "Image")
    private byte[] image;
    /* private boolean isBubbleObj;*/
    @ColumnInfo(name = "IsBubbleBiz")
    private boolean isBubbleBizObj;
    @ColumnInfo(name = "IsFavorite")
    private boolean isFavorite;
    @ColumnInfo(name = "TotalDuration")
    private String totalDuration;
    @ColumnInfo(name = "LastCallDay")
    private int lastCallDay = -1;
    @ColumnInfo(name = "Frequent")
    private int frequent;
    @ColumnInfo(name = "IsSection")
    public boolean isSection;

    public LocalContactObj() {
    }

    @Ignore
    public LocalContactObj(String fullName, String primaryNumber) {
        phoneNumbers = new ArrayList<>();
        emails = new ArrayList<>();
        this.fullName = fullName;
        this.primaryNumber = primaryNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocalContactObj that = (LocalContactObj) o;
        return isBubbleBizObj == that.isBubbleBizObj &&
                isFavorite == that.isFavorite &&
                lastCallDay == that.lastCallDay &&
                frequent == that.frequent &&
                isSection == that.isSection &&
                fullName.equals(that.fullName) &&
                Objects.equals(palId, that.palId) &&
                Objects.equals(primaryNumber, that.primaryNumber) &&
                Objects.equals(phoneNumbers, that.phoneNumbers) &&
                Objects.equals(emails, that.emails) &&
                Objects.equals(imageUri, that.imageUri) &&
                Arrays.equals(image, that.image) &&
                Objects.equals(totalDuration, that.totalDuration);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(fullName, palId, primaryNumber, phoneNumbers, emails, imageUri, isBubbleBizObj, isFavorite, totalDuration, lastCallDay, frequent, isSection);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }



    public String getPalId() {
        return palId;
    }

    public void setPalId(String palId) {
        this.palId = palId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPrimaryNumber() {
        return primaryNumber;
    }

    public void setPrimaryNumber(String primaryNumber) {
        this.primaryNumber = primaryNumber;
    }

    public List<PhoneNumberObj> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumberObj> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public List<EmailObj> getEmails() {
        return emails;
    }

    public void setEmails(List<EmailObj> emails) {
        this.emails = emails;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }


    public boolean isBubbleBizObj() {
        return isBubbleBizObj;
    }

    public void setBubbleBizObj(boolean bubbleBizObj) {
        isBubbleBizObj = bubbleBizObj;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public boolean isSection() {
        return isSection;
    }

    public void setSection(boolean section) {
        isSection = section;
    }

    public String getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(String totalDuration) {
        this.totalDuration = totalDuration;
    }

    public int getLastCallDay() {
        return lastCallDay;
    }

    public void setLastCallDay(int lastCallDay) {
        this.lastCallDay = lastCallDay;
    }

    public int getFrequent() {
        return frequent;
    }

    public void setFrequent(int frequent) {
        this.frequent = frequent;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

}
