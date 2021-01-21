package com.hawk.soundrecoder.listRecords

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.hawk.soundrecoder.R
import com.hawk.soundrecoder.database.RecordDatabase
import com.hawk.soundrecoder.databinding.FragmentListRecordsBinding


class ListRecordsFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentListRecordsBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_list_records, container, false
        )
        val application = requireNotNull(this.activity).application

        val dataSource = RecordDatabase.getInstance(application).recordDatabaseDao
        val viewModelFactory = ListRecordViewModelFactory(dataSource)

        val listRecordViewModel = ViewModelProviders.of(
                this, viewModelFactory).get(ListRecordViewModel::class.java)

        binding.listRecordViewModel = listRecordViewModel

        val adapter = ListRecordAdapter()
        binding.recyclerView.adapter = adapter

        listRecordViewModel.records.observe(viewLifecycleOwner, Observer {
            it?.let { adapter.data = it }
        })

        binding.lifecycleOwner = this

        return binding.root
    }


}