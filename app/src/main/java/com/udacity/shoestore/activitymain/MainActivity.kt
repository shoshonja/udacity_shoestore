package com.udacity.shoestore.activitymain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import timber.log.Timber

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        Timber.plant(Timber.DebugTree())

        NavigationUI.setupActionBarWithNavController(
            this,
            findNavController(R.id.main_nav_host_fragment)
        )
    }

    override fun onSupportNavigateUp(): Boolean {
        return this.findNavController(R.id.main_nav_host_fragment).navigateUp()
    }

}
