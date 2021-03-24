package com.elmaravilla.roomdatabaseexample

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    //get all the users stored in the database
    @Query("Select * from `database-user`")
    fun getAll():List<User>

    //insert new users into the database
    @Insert
    fun insert(user: User)

    //delete user
    @Delete
    fun delete(user: User)
}