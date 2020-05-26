package com.olehmesh.randomusers.presentation.fragments.detail_fragment

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.bottomappbar.BottomAppBar
import com.olehmesh.randomusers.R
import com.olehmesh.randomusers.databinding.FragmentDetailBinding
import com.olehmesh.randomusers.di.App
import com.olehmesh.randomusers.repository.database.DatabaseManager
import com.olehmesh.randomusers.repository.database.entity.DateLatLng
import com.olehmesh.randomusers.repository.database.entity.UserEntity
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.coroutines.*
import java.text.SimpleDateFormat
import javax.inject.Inject


class DetailFragment : Fragment() {

    private lateinit var navController: NavController

    @Inject
    lateinit var userEntity: UserEntity

    @Inject
    lateinit var date: DateLatLng

    @Inject
    lateinit var db: DatabaseManager

    private val scope = CoroutineScope(Job())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        App.component.createDetailComponent().inject(this)

        val binding: FragmentDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)

        val detail =
            DetailModel(
                requireArguments().getString(R.string.name.toString()),
                requireArguments().getString(R.string.city.toString()),
                requireArguments().getString(R.string.email.toString()),
                requireArguments().getString(R.string.phone.toString())
            )

        binding.result = detail

        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Glide.with(this).asBitmap()
            .load(requireArguments().getString(R.string.image.toString()))
            .apply(RequestOptions().encodeQuality(100))
            .into(ivDetailLarge)

        fab_bottom.setOnClickListener {

            scope.launch(Dispatchers.Main) {
                val job = launch(Dispatchers.IO) {

                    val daoUserAndDate = db.daoUserAndDate()

                    userEntity.name = requireArguments().getString(R.string.name.toString())
                    userEntity.city = requireArguments().getString(R.string.city.toString())
                    userEntity.image =
                        requireArguments().getString(R.string.image.toString()).toString()

                    date.latitude = requireArguments().getString(R.string.latitude.toString())
                    date.longitude = requireArguments().getString(R.string.longitude.toString())
                    date.date = timeToDate()

                    daoUserAndDate.insertUserAndDate(userEntity, date)

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

        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")
            .parse(requireArguments().getString(R.string.date.toString()).toString())

        return SimpleDateFormat("dd.MM 'at' HH.mm").format(dateFormat!!)

    }
}












