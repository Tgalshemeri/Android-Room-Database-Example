package com.elmaravilla.roomdatabaseexample

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        var db: UserDatabase? = null
         fun getInstance(context: Context): UserDatabase? {
            if (db == null)
                db = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java, "database-user")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()

            return db!!
        }
    }
}


