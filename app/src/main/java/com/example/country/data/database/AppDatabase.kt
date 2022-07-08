package com.example.country.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.country.domain.CountryModel

@Database(entities = [CountryModel::class], version = 1)

abstract class AppDatabase : RoomDatabase() {


    companion object {

        @Volatile
        private var instance: AppDatabase? = null

        private val LOCK = Any()
        operator fun invoke(context: Context) = instance ?: kotlin.synchronized(LOCK) {
            instance ?: makeDatabase(context).also {
                instance = it

            }
        }

        private fun makeDatabase(context: Context) = Room.databaseBuilder(context
            .applicationContext, AppDatabase::class.java, "database")
            .build()
    }


}