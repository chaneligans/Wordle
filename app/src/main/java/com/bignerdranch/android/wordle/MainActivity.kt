package com.bignerdranch.android.wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.bignerdranch.android.wordle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val wordleViewModel: WordleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.newWordButton.setOnClickListener {
            updateWord()
        }

        updateWord()
    }

    private fun updateWord() {
        wordleViewModel.updateWord()
        binding.word.text = wordleViewModel.currentWord.value?.text
    }
}