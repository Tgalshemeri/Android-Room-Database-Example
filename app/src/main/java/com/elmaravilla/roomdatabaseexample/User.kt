package com.elmaravilla.roomdatabaseexample

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "database-user")
data class User(
    @PrimaryKey @ColumnInfo(name = "username") val username:String,
    @ColumnInfo(name = "password") val password:String)