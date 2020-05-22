package com.olehmesh.randomusers.presentation.fragments

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
import com.olehmesh.randomusers.R
import com.olehmesh.randomusers.di.App
import com.olehmesh.randomusers.repository.database.DatabaseManager
import com.olehmesh.randomusers.repository.database.entity.DateCurrent
import com.olehmesh.randomusers.repository.database.entity.UserEntity
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.coroutines.*
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


class DetailFragment : Fragment() {

    private lateinit var navController: NavController

    @Inject
    lateinit var userEntity: UserEntity

    @Inject
    lateinit var date: DateCurrent

    private val scope = CoroutineScope(Job())


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        App.component.createDetailComponent().inject(this)
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        tvDetailName!!.text = requireArguments().getString(R.string.name.toString())
        tvDetailCity!!.text = requireArguments().getString(R.string.city.toString())

        Glide.with(this).asBitmap()
            .load(requireArguments().getString(R.string.image.toString()))
            .apply(RequestOptions().encodeQuality(100))
            .into(ivDetailLarge)

        tvDetailEmail!!.text = requireArguments().getString(R.string.email.toString())
        tvDetailPhone!!.text = requireArguments().getString(R.string.phone.toString())


        fab_bottom.setOnClickListener {

            scope.launch(Dispatchers.Main) {
                val job = launch(Dispatchers.IO) {

                    val db = DatabaseManager.getDatabase(context)
                    val daoUserAndDate = db?.daoUserAndDate()

                    userEntity.name = tvDetailName!!.text as String
                    userEntity.city = tvDetailCity!!.text as String
                    userEntity.image =
                        requireArguments().getString(R.string.image.toString()).toString()

                    date.dateCurrent = timeToDate()

                    daoUserAndDate?.insertUserAndDate(userEntity, date)

                }

                job.join()
                Toast.makeText(context, "Successfully added", Toast.LENGTH_SHORT).show()
                bottom_app_bar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
                fab_bottom.isEnabled = false
                delay(2000)
                navController =
                    Navigation.findNavController(context as Activity, R.id.nav_host_fragment)
                navController.navigate(R.id.fragment_main)

            }

        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun timeToDate(): String {

        val currentTime = System.currentTimeMillis()
        val simpleDateFormat = SimpleDateFormat("dd.MM 'at' HH.mm")
        val date = Date(currentTime)
        return simpleDateFormat.format(date)

    }
}












