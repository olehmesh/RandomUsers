package com.olehmesh.randomusers_task.views

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.bottomappbar.BottomAppBar
import com.olehmesh.randomusers_task.Constants
import com.olehmesh.randomusers_task.R
import com.olehmesh.randomusers_task.database.DatabaseManager
import com.olehmesh.randomusers_task.database.entity.DateCurrent
import com.olehmesh.randomusers_task.database.entity.UserInfo
import com.olehmesh.randomusers_task.di.App
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.coroutines.*
import javax.inject.Inject

class DetailFragment : Fragment() {

    private lateinit var navController: NavController

    @Inject
    lateinit var userInfo: UserInfo

    @Inject
    lateinit var dateCurrent: DateCurrent

    private val scope = CoroutineScope(Job())


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        App.component.createDetailComponent().inject(this)
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        tvDetailName!!.text = "Name: " + requireArguments().getString(Constants.NAME)
        tvDetailCity!!.text = "City: " + requireArguments().getString(Constants.CITY)

        Glide.with(this).asBitmap()
            .load(requireArguments().getString(Constants.IMAGE))
            .apply(RequestOptions().encodeQuality(100))
            .into(ivDetailLarge)

        tvDetailEmail!!.text = "E-mail: " + requireArguments().getString(Constants.EMAIL)
        tvDetailPhone!!.text = "Phone: " + requireArguments().getString(Constants.PHONE)

        fab_bottom.setOnClickListener {

            scope.launch(Dispatchers.Main) {
                val job = launch(Dispatchers.IO) {

                    val db = DatabaseManager.getDatabase(context)
                    val daoUserAndDate = db?.daoUserAndDate()

                    userInfo.name = tvDetailName!!.text as String
                    userInfo.city = tvDetailCity!!.text as String
                    userInfo.image = requireArguments().getString(Constants.IMAGE).toString()

                    dateCurrent.dateCurrent = System.currentTimeMillis()

                    daoUserAndDate?.insertUserAndDate(userInfo, dateCurrent)

                }

                job.join()
                Toast.makeText(context, "Successfully added", Toast.LENGTH_SHORT).show()
                bottom_app_bar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
                fab_bottom.isEnabled = false
                delay(2400)
                navController =
                    Navigation.findNavController(context as Activity, R.id.nav_host_fragment)
                navController.navigate(R.id.fragment_main)

            }

        }

    }

}












