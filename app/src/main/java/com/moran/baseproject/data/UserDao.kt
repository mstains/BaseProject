package com.moran.baseproject.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAll() : MutableList<User>


    @Insert
    fun insert(user: User)


    @Delete
    fun delete(user: User)

}