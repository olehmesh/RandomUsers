package com.olehmesh.randomusers.presentation.fragments.maps_fragment

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.olehmesh.randomusers.R
import kotlinx.coroutines.*


class MapsFragment : Fragment() {

    private val scope = CoroutineScope(Job())
    private val callback = OnMapReadyCallback { googleMap ->

        val lng = requireArguments().getString(R.string.longitude.toString())?.toDouble() as Double
        val lat = requireArguments().getString(R.string.latitude.toString())?.toDouble() as Double
        val city = requireArguments().getString(R.string.city.toString())


        val coordinates = LatLng(lat, lng)
        googleMap
            .addMarker(
                MarkerOptions().position(coordinates)
                    .icon(bitmapDescriptorFromVector(context as Activity, R.drawable.ic_marker_4))
                    .title(city)
            ).showInfoWindow()
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


        scope.launch(Dispatchers.Main) {

            delay(3000)
            val myDialogFragment = MapsDialog()
            activity?.supportFragmentManager?.let { myDialogFragment.show(it, "myDialog") }

        }

    }


    private fun bitmapDescriptorFromVector(context: Context, vectorResId: Int): BitmapDescriptor? {
        return ContextCompat.getDrawable(context, vectorResId)?.run {
            setBounds(0, 0, intrinsicWidth, intrinsicHeight)
            val bitmap =
                Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888)
            draw(Canvas(bitmap))
            BitmapDescriptorFactory.fromBitmap(bitmap)
        }
    }

}