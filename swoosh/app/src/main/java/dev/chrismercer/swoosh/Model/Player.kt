package dev.chrismercer.swoosh.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Player(var league: String, var skill: String) : Parcelable