package com.bignerdranch.android.wordle

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WordGenerator {

    @GET("new-word")
    suspend fun getWord(
        @Query("wordlength") wordLength: Int
    ): Response<Word>

}