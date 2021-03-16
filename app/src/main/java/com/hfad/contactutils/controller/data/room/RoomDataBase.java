package com.hfad.contactutils.controller.data.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;


import com.hfad.contactutils.controller.data.model.LocalContactObj;
import com.hfad.contactutils.controller.data.model.LocalHistoryObj;
import com.hfad.contactutils.controller.data.room.dao.LocalContactDao;
import com.hfad.contactutils.controller.data.room.dao.LocalHistoryDao;
import com.hfad.contactutils.controller.data.room.dao.TestModelDAO;
import com.hfad.contactutils.controller.data.room.entities.TestModel;
import com.hfad.contactutils.controller.data.room.utils.Converters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {LocalContactObj.class,
        TestModel.class,
        LocalHistoryObj.class,
},
        version = 1,
        exportSchema = false)
@TypeConverters({Converters.class})
public abstract class RoomDataBase extends RoomDatabase {
    private static final String DATABASE_NAME = "contactUtil.db";
    private static final int NUMBER_OF_THREADS = 4;

    public static ExecutorService dataBaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public abstract LocalContactDao getLocalContactDAO();

    public abstract TestModelDAO getTestModelDAO();

    public abstract LocalHistoryDao getLocalHistoryDAO();

    public static RoomDataBase getDataBase(Context context) {
        return Room.databaseBuilder(context, RoomDataBase.class, DATABASE_NAME).build();
    }

}
