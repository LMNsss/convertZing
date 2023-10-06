package com.ngoclm.mp3_demo.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ngoclm.mp3_demo.Database.dao.SongDao
import com.ngoclm.mp3_demo.Model.Song

@Database(entities = [Song::class], version = 1 )
abstract class SongDatabase: RoomDatabase() {
    abstract fun getSongDao(): SongDao

    companion object{
        @Volatile
        private var instance : SongDatabase? = null

        fun getInstance(context: Context): SongDatabase {
            if (instance == null){
                instance = Room.databaseBuilder(context, SongDatabase::class.java, "song_table").build()
            }
            return instance!!
        }
    }
}