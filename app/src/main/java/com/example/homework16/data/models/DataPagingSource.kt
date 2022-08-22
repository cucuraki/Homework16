package com.example.homework16.data.models

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.homework16.network.RetrofitClient
import kotlinx.coroutines.delay
import java.lang.Exception
import kotlin.math.max
private const val STARTING_KEY = 0
private const val LOAD_DELAY_MILLIS = 3_000L

class DataPagingSource: PagingSource<Int, Data>() {
    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val article = state.closestItemToPosition(anchorPosition) ?: return null
        return ensureValidKey(article.id - (state.config.pageSize / 2))
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        return try{
            val nextPageNumber = params.key ?: 0
            if (nextPageNumber != STARTING_KEY) delay(LOAD_DELAY_MILLIS)

            val response = RetrofitClient.getService.requestData(page = nextPageNumber)
            if(response.isSuccessful) {
                val body = response.body()
                LoadResult.Page(
                    data = body?.data?:listOf(),
                    prevKey = if (nextPageNumber > 0) nextPageNumber - 1 else null,
                    nextKey = if (nextPageNumber < body?.totalPages?:10) nextPageNumber + 1 else null
                )
            }else{
                LoadResult.Error(Exception("Error"))
            }
        }catch (e: Exception){
            LoadResult.Error(e)
        }
    }

    private fun ensureValidKey(key: Int) = max(STARTING_KEY, key)
}