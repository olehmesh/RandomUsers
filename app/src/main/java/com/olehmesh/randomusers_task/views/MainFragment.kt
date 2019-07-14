package com.olehmesh.randomusers_task.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.olehmesh.randomusers_task.R
import com.olehmesh.randomusers_task.adapters.UsersAdapter
import com.olehmesh.randomusers_task.common.UsersContract
import com.olehmesh.randomusers_task.models.Result
import com.olehmesh.randomusers_task.presenters.UsersPresenter
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(), UsersContract.View {

    var list: List<Result>? = null
    private lateinit var adapter: UsersAdapter
    private lateinit var mPresenter: UsersContract.Presenter

    override fun init() {

        mPresenter.loadUsers()
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.INVISIBLE
    }

    override fun showError(message: String) {
        Toast.makeText(activity, "No Internet Connection", Toast.LENGTH_SHORT).show()
    }

    override fun loadDataInList(users: List<Result>) {
        adapter = UsersAdapter(list)

        adapter.setData(users)

        recyclerView.adapter = adapter

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mPresenter = UsersPresenter(this)
        mPresenter.start()

        return inflater.inflate(R.layout.fragment_main, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(context)

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                if (dy > 0 || dy < 0 && fab.isShown)
                    fab.hide()
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {

                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    fab.show()
                }
                super.onScrollStateChanged(recyclerView, newState)
            }
        })

        fab.setOnClickListener {
            mPresenter.onRefreshButtonClick()
            mPresenter.loadUsers()

        }
    }
}
