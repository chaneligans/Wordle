package com.bignerdranch.android.wordle

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.flow.MutableStateFlow

private const val TAG = "WordleViewModel"
const val CURRENT_WORD_KEY = "CURRENT_WORD_KEY"

class WordleViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    private val wordBank = WordBank()

    private val _currentWord = savedStateHandle.getLiveData<Word>(CURRENT_WORD_KEY)
    val currentWord = _currentWord

    fun updateWord() {
        savedStateHandle[CURRENT_WORD_KEY] = wordBank.getRandomWord()
    }


}