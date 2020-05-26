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
import com.olehmesh.randomusers.di.App
import com.olehmesh.randomusers.domain.RoomViewModel
import com.olehmesh.randomusers.presentation.adapters.SavedAdapter
import com.olehmesh.randomusers.repository.database.DatabaseManager
import com.olehmesh.randomusers.repository.database.entity.UserEntity
import com.olehmesh.randomusers.repository.database.relation.DateAndUser
import kotlinx.android.synthetic.main.fragment_saved.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject


class SavedFragment : Fragment(), SavedAdapter.OnDeleteListener {

    private val roomViewModel by viewModels<RoomViewModel>()
    private val scope = CoroutineScope(Job())

    @Inject
    lateinit var databaseManager: DatabaseManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        App.component.inject(this)

        roomViewModel.dbLiveData.observe(viewLifecycleOwner, Observer { initRecyclerView(it) })

        return inflater.inflate(R.layout.fragment_saved, container, false)
    }

    private fun initRecyclerView(users: MutableList<DateAndUser>) {

        val recyclerAdapter = SavedAdapter(users)
        recyclerViewSaved.layoutManager = LinearLayoutManager(context)
        recyclerViewSaved.adapter = recyclerAdapter
        recyclerAdapter.setOnDeleteListener(this)

    }

    override fun onDelete(userEntity: UserEntity) {
        scope.launch(Dispatchers.IO) {
            databaseManager.daoUserInfo().delete(userEntity)
        }
    }

}