package com.olehmesh.randomusers.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.olehmesh.randomusers.R
import com.olehmesh.randomusers.presentation.adapters.UsersAdapter
import com.olehmesh.randomusers.domain.MainViewModel
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {

    //  @Inject
    //  lateinit var adapter: UsersAdapter
    private val mainViewModel by viewModels<MainViewModel>()
    private val testAdapter = UsersAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mainViewModel.getData().observe(viewLifecycleOwner, Observer {
            testAdapter.submitList(it)
        })

        return inflater.inflate(R.layout.fragment_main, container, false)

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerMain.layoutManager = LinearLayoutManager(context)
        recyclerMain.adapter = testAdapter

    }

}