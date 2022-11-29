package com.bignerdranch.android.wordle

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Word(
    val word: String
) : Parcelable