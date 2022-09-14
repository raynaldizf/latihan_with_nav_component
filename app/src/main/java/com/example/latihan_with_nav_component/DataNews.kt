package com.example.latihan_with_nav_component

import java.io.Serializable

data class DataNews(val judul : String, val tanggal : String, val penulis : String, val gambar : Int, val isiBerita : String) :
    Serializable
