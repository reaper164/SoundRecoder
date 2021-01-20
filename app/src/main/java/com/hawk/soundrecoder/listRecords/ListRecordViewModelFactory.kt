package com.hawk.soundrecoder.listRecords

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hawk.soundrecoder.database.ReacordDatabaseDao

class ListRecordViewModelFactory (private var databaseDao : ReacordDatabaseDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        TODO("Not yet implemented")
    }
}