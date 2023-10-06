package com.ngoclm.mp3_demo.Reponsitory

import android.app.Application
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.lifecycle.LiveData
import com.ngoclm.mp3_demo.Database.SongDatabase
import com.ngoclm.mp3_demo.Database.dao.SongDao
import com.ngoclm.mp3_demo.Model.Song

class SongReponsitory(app:Application) {
    private val songDao: SongDao

    init {
        val songDataBase:SongDatabase = SongDatabase.getInstance(app)
        songDao = songDataBase.getSongDao()
    }

    suspend fun insertSong(song: Song) = songDao.insertSong(song)
    suspend fun updateSong(song: Song) = songDao.updateSong(song)
    suspend fun deleteSong(song: Song) = songDao.deleteSong(song)

    fun getAllSong(): LiveData<List<Song>> = songDao.getAllSong()
}