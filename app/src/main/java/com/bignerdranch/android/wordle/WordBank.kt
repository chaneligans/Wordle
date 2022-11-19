package com.bignerdranch.android.wordle

class WordBank {

    private var wordBank = mutableListOf(
        Word("hello"),
        Word("biker"),
        Word("table"),
        Word("wheel"),
        Word("posse"),
        Word("crazy"),
        Word("super"),
        Word("pleat"),
        Word("dress"),
        Word("whose"),
        Word("shift"),
        Word("drive"),
        Word("crave"),
    )

    fun getRandomWord(): Word {
        val index = (0 until wordBank.size).random()
        return wordBank[index]
    }

}