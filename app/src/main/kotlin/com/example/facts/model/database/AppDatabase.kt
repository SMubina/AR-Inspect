package com.example.facts.model.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.facts.model.FactDao
import com.example.facts.model.RowsData

@Database(entities = [RowsData::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun factDao(): FactDao
}