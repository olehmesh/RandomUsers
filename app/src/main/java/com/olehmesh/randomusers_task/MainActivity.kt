package com.olehmesh.randomusers_task

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.fragment.NavHostFragment
import com.arellomobile.mvp.MvpAppCompatActivity
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity() {

    @Inject
    lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navHostFragment.navController

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.saved, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.action_add -> {

                navHostFragment.navController.navigate(R.id.fragment_saved)
            }
        }

        return false

    }

}