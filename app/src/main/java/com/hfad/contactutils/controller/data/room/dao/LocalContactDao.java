package com.hfad.contactutils.controller.data.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.hfad.contactutils.controller.data.model.LocalContactObj;

import java.util.List;

@Dao
public interface LocalContactDao {
    @Insert
    void insertLocalContacts(LocalContactObj... localContactObj);

    @Query("Select * from tblLocalContact")
    LiveData<List<LocalContactObj>> getLocalContactsLiveData();

    @Query("select * from tblLocalContact where PK_FullName = :PK_FullName")
    LocalContactObj getLocalContact(String PK_FullName);

    @Query("select * from tbllocalcontact where PrimaryNumber= :primaryNumber")
    LiveData<List<LocalContactObj>> getLocalContactsByNumber(String primaryNumber);

    @Update
    void updateLocalContacts(LocalContactObj... localContactObj);

    @Delete
    void deleteLocalContacts(LocalContactObj... localContactObj);

    @Query("Delete from tblLocalContact")
    void deleteAllLocalContacts();

    @Query("Select * from tblLocalContact")
    List<LocalContactObj> getLocalContacts();

}
