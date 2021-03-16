package com.hfad.contactutils.controller.data.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.hfad.contactutils.controller.data.room.entities.TestModel;

import java.util.List;

@Dao
public interface TestModelDAO {
    @Insert
    void insertCarts(TestModel... carts);

    @Update
    void updateCarts(TestModel... carts);

    @Delete
    void deleteCarts(TestModel... carts);

    @Query("select * from tblTest")
    LiveData<List<TestModel>> getCarts();

    @Query("select * from tblTest where productid = :productid")
    TestModel getCart(Integer productid);

    @Query("delete from tblTest")
    void deleteAllCarts();
}
