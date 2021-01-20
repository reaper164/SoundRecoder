package com.hawk.soundrecoder.listRecords

import androidx.lifecycle.ViewModel
import com.hawk.soundrecoder.database.ReacordDatabaseDao

class ListRecordViewModel (datasource : ReacordDatabaseDao) : ViewModel() {

    val database =  datasource
    val records = database.getAllRecords()

}