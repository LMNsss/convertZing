package com.ngoclm.mp3_demo.Model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "song_table")
data class Song(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "img_col") val img: String,
    @ColumnInfo(name = "song_name_col") val songName: String,
    @ColumnInfo(name = "singer_name_col") val singerName: String
)