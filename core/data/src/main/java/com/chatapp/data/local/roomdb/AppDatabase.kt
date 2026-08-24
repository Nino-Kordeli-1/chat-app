package com.chatapp.data.local.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.chatapp.data.local.entity.UserEntity
import com.chatapp.data.local.dao.UserDao

@Database(
    entities = [UserEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract val userDao: UserDao
}