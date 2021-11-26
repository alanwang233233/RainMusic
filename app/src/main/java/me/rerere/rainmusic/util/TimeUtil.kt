package me.rerere.rainmusic.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*

fun now() = System.currentTimeMillis()

@SuppressLint("SimpleDateFormat")
private val sdf = SimpleDateFormat("yyyy年MM月dd日")

@SuppressLint("SimpleDateFormat")
private val sdfDetail = SimpleDateFormat("yyyy年MM月dd日 HH:mm")

fun Long.format(
    detail: Boolean = false
): String = if (detail) sdfDetail.format(Date(this)) else sdf.format(Date(this))

fun Pair<Long, Long>?.formatAsPlayerTime(): String {
    val first = this?.first?.formatAsPlayerTime() ?: "00:00"
    val second = this?.second?.formatAsPlayerTime() ?: "00:00"
    return "$first / $second"
}

fun Long.formatAsPlayerTime() : String {
    val minutes = String.format("%02d", this / 60_000L)
    val seconds = String.format("%02d", (this % 60_000L) / 1000L)
    return "$minutes:$seconds"
}