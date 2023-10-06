package com.ngoclm.mp3_demo

import android.view.View

interface  ButtonClickListener {
    fun onClickButton(view: View, pos: Int){}
    fun onClickItem(view: View, pos: Int){}
}