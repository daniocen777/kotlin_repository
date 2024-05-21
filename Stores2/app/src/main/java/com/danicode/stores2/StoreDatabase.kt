package com.danicode.stores2

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [StoreEntity::class], version = 1)
abstract class StoreDatabase : RoomDatabase() {
    abstract fun storeDao(): IStoreDao
}