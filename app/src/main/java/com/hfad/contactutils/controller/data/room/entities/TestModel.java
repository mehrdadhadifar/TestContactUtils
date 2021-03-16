package com.hfad.contactutils.controller.data.room.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "tblTest")
public class TestModel {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "productid")
    private Integer mProductid;
    @ColumnInfo(name = "count")
    private int count;

    @NonNull
    public Integer getProductid() {
        return mProductid;
    }

    public void setProductid(@NonNull Integer productid) {
        mProductid = productid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Ignore
    public TestModel(Integer productid, int count) {
        mProductid = productid;
        this.count = count;
    }

    @Ignore
    public TestModel(Integer productid) {
        mProductid = productid;
    }

    public TestModel() {
    }

    @Override
    public String toString() {
        return "Cart{" +
                "mProductId=" + mProductid +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestModel cart = (TestModel) o;
        return mProductid.equals(cart.mProductid);
    }

}
