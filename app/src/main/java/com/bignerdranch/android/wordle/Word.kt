package com.bignerdranch.android.wordle

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Word(
    val text: CharSequence
) : Parcelable