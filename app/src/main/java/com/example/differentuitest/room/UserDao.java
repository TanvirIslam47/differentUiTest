package com.example.differentuitest.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM userTable")
    List<Users> getAll();

    @Query("SELECT * FROM userTable WHERE uid IN (:userIds)")
    List<Users> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM userTable WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    Users findByName(String first, String last);

    @Insert
    void insertAll(Users users);

    @Delete
    void delete(Users user);
}
