package com.olehmesh.randomusers_task.views


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.olehmesh.randomusers_task.Constants
import com.olehmesh.randomusers_task.R
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

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

    }

}
