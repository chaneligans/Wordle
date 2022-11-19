package com.bignerdranch.android.wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.bignerdranch.android.wordle.databinding.ActivityMainBinding
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val wordleViewModel: WordleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        updateWord()

        binding.newWordButton.setOnClickListener {
            updateWord()
        }

        binding.guessButton.setOnClickListener {
            checkGuess()
        }
    }

    private fun updateWord() {
        wordleViewModel.updateWord()
        binding.word.text = wordleViewModel.currentWord.value?.text
    }

    private fun checkGuess() {
        val guessWord = binding.guessEditText.text.toString()
        val answer = wordleViewModel.currentWord.value?.text.toString()

        val messageResId = when {
            guessWord == answer -> R.string.correct
            else -> R.string.incorrect
        }

        Snackbar.make(
            binding.guessEditText,
            messageResId,
            BaseTransientBottomBar.LENGTH_SHORT
        ).show()
    }
}