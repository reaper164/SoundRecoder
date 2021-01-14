package com.hawk.soundrecoder.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(version = 1, entities = [RecordingItem::class])
abstract class RecordDatabase : RoomDatabase() {

    abstract val recordDatabaseDao : ReacordDatabaseDao

    companion object{
        @Volatile
        private var INSTANCE : RecordDatabase? = null

        fun getInstance(context : Context) : RecordDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RecordDatabase::class.java,
                        "recorder_app_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
                return instance
            }
        }

    }

}