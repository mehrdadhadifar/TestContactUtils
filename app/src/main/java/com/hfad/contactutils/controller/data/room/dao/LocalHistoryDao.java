package com.hfad.contactutils.controller.data.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.hfad.contactutils.controller.data.model.LocalContactObj;
import com.hfad.contactutils.controller.data.model.LocalHistoryObj;

import java.util.List;

@Dao
public interface LocalHistoryDao {
    @Insert
    void insertLocalHistory(LocalHistoryObj... localHistoryObjs);

    @Query("Select * from tblLocalHistory")
    LiveData<List<LocalHistoryObj>> getLocalHistoryLiveData();

    @Update
    void updateLocalHistory(LocalHistoryObj... localHistoryObj);

    @Delete
    void deleteLocalHistory(LocalHistoryObj... localHistoryObj);

    @Query("Delete from tblLocalHistory")
    void deleteAllLocalHistory();

    @Query("Select * from tbllocalhistory")
    List<LocalHistoryObj> getLocalHistory();

}
