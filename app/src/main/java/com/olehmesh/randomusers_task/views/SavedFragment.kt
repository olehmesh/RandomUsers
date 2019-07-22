package com.olehmesh.randomusers_task.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.olehmesh.randomusers_task.R
import com.olehmesh.randomusers_task.adapters.SavedAdapter
import com.olehmesh.randomusers_task.database.DB
import com.olehmesh.randomusers_task.database.DatabaseManager
import com.olehmesh.randomusers_task.models.EntityData
import kotlinx.android.synthetic.main.fragment_saved.*


class SavedFragment : Fragment(), SavedAdapter.OnDeleteListener {

    private var databaseManager: DatabaseManager? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        databaseManager = DB.getDatabase(context)

        return inflater.inflate(R.layout.fragment_saved, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerViewSaved.layoutManager = LinearLayoutManager(context)

    }

    override fun onResume() {
        super.onResume()
        val recyclerAdapter = SavedAdapter(databaseManager?.daoMethods()?.all as MutableList<EntityData>)
        recyclerAdapter.setOnDeleteListener(this)

        recyclerViewSaved.adapter = recyclerAdapter
    }

    override fun onDelete(entityDatabase: EntityData) {
        databaseManager?.daoMethods()?.delete(entityDatabase)
    }

}
