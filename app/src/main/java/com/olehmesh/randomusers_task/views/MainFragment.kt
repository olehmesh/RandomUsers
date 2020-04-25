package com.olehmesh.randomusers_task.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.arellomobile.mvp.presenter.ProvidePresenterTag
import com.olehmesh.randomusers_task.R
import com.olehmesh.randomusers_task.adapters.UsersAdapter
import com.olehmesh.randomusers_task.common.ContractView
import com.olehmesh.randomusers_task.di.App
import com.olehmesh.randomusers_task.models.Result
import com.olehmesh.randomusers_task.presenters.UsersPresenter
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

class MainFragment : MvpAppCompatFragment(), ContractView {


    @Inject
    lateinit var adapter: UsersAdapter

    @InjectPresenter
    lateinit var mPresenter: UsersPresenter

    @ProvidePresenterTag(presenterClass = UsersPresenter::class)
    fun mPresenter() = UsersPresenter()

    @ProvidePresenter
    fun providePresenter() = UsersPresenter()

    override fun init() {
        fab.visibility = View.INVISIBLE
        mPresenter.loadUsers()

    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE

    }

    override fun hideProgress() {
        progressBar.visibility = View.INVISIBLE
        fab.visibility = View.VISIBLE
    }

    override fun showError(message: String) {
        Toast.makeText(activity, "No Internet Connection", Toast.LENGTH_SHORT).show()
        hideProgress()
    }

    override fun loadDataInList(users: List<Result>) {

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        adapter.setData(users)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        App.component.inject(this)
        mPresenter.start()

        return inflater.inflate(R.layout.fragment_main, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


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
