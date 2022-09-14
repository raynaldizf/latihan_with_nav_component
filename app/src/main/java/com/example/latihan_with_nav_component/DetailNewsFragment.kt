package com.example.latihan_with_nav_component

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_detail_news.*

class DetailNewsFragment : Fragment() {
    val args : DetailNewsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var getNews = args.datanews
        detailJudulBerita.text = getNews.judul
        detailBeritaTanggal.text = getNews.tanggal
        detailBeritaPenulis.text = getNews.penulis
        imageDetalBerita.setImageResource(getNews.gambar)
        detailIsiBerita.text = getNews.isiBerita
    }

}