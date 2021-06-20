package com.example.projectsatu.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SaranDAO {
    @Insert
    long insertSaran(SaranModel saranModel);

    @Delete
    int deleteSaran(SaranModel saranModel);

    @Query("SELECT * from data_saran")
    List<SaranModel> getSaran();
}
