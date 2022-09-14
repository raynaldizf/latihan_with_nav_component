package com.example.latihan_with_nav_component

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    lateinit var newsAdapter : NewsAdapter
    lateinit var vmNews : NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataNews()

        vmNews =ViewModelProvider(requireActivity()).get(NewsViewModel::class.java)
        vmNews.getNews()
        vmNews.listberita.observe(viewLifecycleOwner) {
            newsAdapter.setDataNews(it as ArrayList<DataNews>)
        }

    }

    fun dataNews() {
        newsAdapter = NewsAdapter(ArrayList())
        rvNews.adapter = newsAdapter
        rvNews.layoutManager = LinearLayoutManager(context)
        newsAdapter.onClick = {
            val pindah = HomeFragmentDirections.actionHomeFragmentToDetailNewsFragment(it)
            findNavController().navigate(pindah)
        }

    }

}