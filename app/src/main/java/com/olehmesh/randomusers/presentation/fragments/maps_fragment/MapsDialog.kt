package com.olehmesh.randomusers.presentation.fragments.maps_fragment

import android.R
import android.app.AlertDialog
import android.app.Dialog

import android.os.Bundle
import androidx.fragment.app.DialogFragment

class MapsDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(activity)
            .setTitle("Attention")
            .setMessage("Current coordinates from API don't match the name of the location")
            .setPositiveButton(
                R.string.yes
            ) { _, _ ->
            }
            .create()
    }
}