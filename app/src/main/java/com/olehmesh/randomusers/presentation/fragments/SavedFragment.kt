package com.olehmesh.randomusers.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.olehmesh.randomusers.R
import com.olehmesh.randomusers.presentation.adapters.SavedAdapter
import com.olehmesh.randomusers.repository.database.DatabaseManager
import com.olehmesh.randomusers.repository.database.entity.UserEntity
import kotlinx.android.synthetic.main.fragment_saved.*


class SavedFragment : Fragment(), SavedAdapter.OnDeleteListener {

    private var databaseManager: DatabaseManager? = null
    private lateinit var dbLiveData: LiveData<MutableList<UserEntity>>
    private lateinit var recyclerAdapter: SavedAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        databaseManager = DatabaseManager.getDatabase(context)
        dbLiveData = databaseManager?.daoUserInfo()!!.all

        dbLiveData.observe(viewLifecycleOwner, Observer {

            recyclerAdapter = SavedAdapter(it)
            recyclerViewSaved.adapter = recyclerAdapter
            recyclerViewSaved.layoutManager = LinearLayoutManager(context)

            recyclerAdapter.setOnDeleteListener(this)
        })

        return inflater.inflate(R.layout.fragment_saved, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



    }

    override fun onDelete(entityDatabase: UserEntity) {
        databaseManager?.daoUserInfo()?.delete(entityDatabase)
    }


}



