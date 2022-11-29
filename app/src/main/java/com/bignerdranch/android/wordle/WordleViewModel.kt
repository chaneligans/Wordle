package com.bignerdranch.android.wordle

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

private const val TAG = "WordleViewModel"
const val CURRENT_WORD_KEY = "CURRENT_WORD_KEY"

class WordleViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    private val service = RetrofitInstance.api

    private val _currentWord = savedStateHandle.getLiveData<Word>(CURRENT_WORD_KEY)
    val currentWord = _currentWord

    fun updateWord() {
        viewModelScope.launch {
            val response = service.getWord(5)
            if (response.isSuccessful) {
                response.body()?.let { body ->
                    savedStateHandle[CURRENT_WORD_KEY] = body
                }
            }
        }
    }
}