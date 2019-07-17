package com.olehmesh.randomusers_task.views

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.bottomappbar.BottomAppBar
import com.olehmesh.randomusers_task.Constants
import com.olehmesh.randomusers_task.R
import com.olehmesh.randomusers_task.database.DB
import com.olehmesh.randomusers_task.database.EntityData
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        tvDetailName!!.text = "Name: " + arguments!!.getString(Constants.NAME)
        tvDetailCity!!.text = "City: " + arguments!!.getString(Constants.CITY)

        Glide.with(this).asBitmap()
            .load(arguments!!.getString(Constants.IMAGE))
            .apply(RequestOptions().encodeQuality(100))
            .into(ivDetailLarge)

        tvDetailEmail!!.text = "E-mail: " + arguments!!.getString(Constants.EMAIL)
        tvDetailPhone!!.text = "Phone: " + arguments!!.getString(Constants.PHONE)


        fab_bottom.setOnClickListener {

            bottom_app_bar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END

            val db = DB.getDatabase(context)
            val daoMethods = db.daoMethods()

            val entityData = EntityData()

            entityData.name = tvDetailName!!.text as String
            entityData.city = tvDetailCity!!.text as String
            entityData.image = arguments!!.getString(Constants.IMAGE)

            daoMethods.insert(entityData)


            Toast.makeText(context, "Successfully added", Toast.LENGTH_LONG).show()
            fab_bottom.visibility = View.INVISIBLE

        }

    }

}











