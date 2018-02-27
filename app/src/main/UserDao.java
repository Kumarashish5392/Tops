package com.example.ashishkumarpatel.tops;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by ashishkumarpatel on 26/02/18.
 */
@Dao
public interface UserDao {
    @Query("SELECT * FROM userdata")
    List<UserData> getAll();

    @Query("SELECT * FROM userdata where name LIKE  :name AND address LIKE :address")
    UserData findByNameandAddress(String name, String address);

    @Query("SELECT COUNT(*) from userdata")
    int countUsers();

    @Insert
    void insertAll(UserData... users);

    @Delete
    void delete(UserData user);
}
