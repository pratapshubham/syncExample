package com.example.user.syncexample.Dao;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.user.syncexample.Entituy.Local;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface DaoDB {

    @Query("select * from mydata ORDER BY email ASC")
   List<Local> getallmail();

    @Insert
    void insert(Local... local);


}
