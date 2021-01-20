package com.hawk.soundrecoder.listRecords

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hawk.soundrecoder.database.ReacordDatabaseDao
import java.lang.IllegalArgumentException

class ListRecordViewModelFactory (private var databaseDao : ReacordDatabaseDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ListRecordViewModel::class.java)){
            return ListRecordViewModel(databaseDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}