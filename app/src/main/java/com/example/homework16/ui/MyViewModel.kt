package com.example.homework16.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.homework16.data.models.DataPagingSource

class MyViewModel : ViewModel() {
    val data = Pager(config = PagingConfig(pageSize = 6, enablePlaceholders = false),
        pagingSourceFactory = { DataPagingSource() }).flow.cachedIn(viewModelScope)

}