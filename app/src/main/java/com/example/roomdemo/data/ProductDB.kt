package com.example.roomdemo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.time.Instant

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class ProductDB : RoomDatabase() {
    abstract val productDao: ProductDao

    companion object {

        @Volatile
        private var INSTANCE: ProductDB? = null

        fun getInstance(context: Context): ProductDB {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ProductDB::class.java,
                        "MyProductDatabase"
                    )
                    .fallbackToDestructiveMigration()
                    .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}