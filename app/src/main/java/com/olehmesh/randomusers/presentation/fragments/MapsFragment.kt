package com.olehmesh.randomusers.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.olehmesh.randomusers.R


class MapsFragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->

        //  val coordinates = LatLng(40.4221019, -3.70393)

        val lng = requireArguments().getString(R.string.longitude.toString())?.toDouble() as Double
        val lat = requireArguments().getString(R.string.latitude.toString())?.toDouble() as Double
        val city = requireArguments().getString(R.string.city.toString())


        val coordinates = LatLng(lat, lng)
        googleMap.addMarker(MarkerOptions().position(coordinates).title(city))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(coordinates))
        googleMap.mapType = GoogleMap.MAP_TYPE_NORMAL
//        googleMap.isMyLocationEnabled = true
        // googleMap.setMinZoomPreference(11f)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}