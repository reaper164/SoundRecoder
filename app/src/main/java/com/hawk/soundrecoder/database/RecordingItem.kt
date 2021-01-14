package com.hawk.soundrecoder.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recordings_table")
data class RecordingItem(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo(name = "name")
    val name : String = "",
    @ColumnInfo(name = "filePath")
    val filePath : String = "",
    @ColumnInfo(name = "length")
    val length : Long = 0L,
    @ColumnInfo(name = "time")
    val time : Long = 0L
)
