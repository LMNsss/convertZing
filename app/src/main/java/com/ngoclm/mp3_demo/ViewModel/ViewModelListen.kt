package com.ngoclm.mp3_demo.ViewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.ngoclm.mp3_demo.Reponsitory.SongReponsitory
import com.ngoclm.mp3_demo.Model.Song
import kotlinx.coroutines.launch

class ViewModelListen(application: Application): ViewModel() {
    private val reponsitory: SongReponsitory = SongReponsitory(application)

    fun insertSong(song: Song) = viewModelScope.launch {
        reponsitory.insertSong(song)
    }

    fun updateSong(song: Song) = viewModelScope.launch {
        reponsitory.updateSong(song)
    }

    fun deleteSong(song: Song) = viewModelScope.launch {
        reponsitory.deleteSong(song)
    }

    fun getAllSong(): LiveData<List<Song>> = reponsitory.getAllSong()

    @Suppress("UNCHECKED_CAST")
    class SongViewModelFactory(private val application:Application): ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ViewModelListen::class.java)){
                return ViewModelListen(application) as T
            }
            throw IllegalAccessException("Unable contruct viewmodel")
        }
    }
}