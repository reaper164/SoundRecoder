package com.hawk.soundrecoder.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ReacordDatabaseDao {
    @Insert
    fun insert(record : RecordingItem)

    @Update
    fun update(record : RecordingItem)

    @Query("SELECT * FROM recordings_table WHERE id = :key")
    fun getRecord(key:Long?) : RecordingItem?

    @Query("DELETE FROM recordings_table")
    fun clearAll()

    @Query("DELETE FROM recordings_table WHERE id=:key")
    fun removeRecord(key: Long?)

    @Query("SELECT * FROM recordings_table ORDER BY id DESC")
    fun getAllRecords() : LiveData<MutableList<RecordingItem>>

    @Query("SELECT COUNT(*) FROM recordings_table")
    fun getCount() : Int//LiveData<Int>
}