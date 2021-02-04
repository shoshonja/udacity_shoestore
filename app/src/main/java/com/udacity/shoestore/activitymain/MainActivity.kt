package com.udacity.shoestore.activitymain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.R
import timber.log.Timber

class MainActivity : AppCompatActivity() {

//    lateinit var mainViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.plant(Timber.DebugTree())

//        mainViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
//
//        mainViewModel.shoeList.observe(this, Observer {
//                            Toast.makeText(this, "Shoe is created", Toast.LENGTH_SHORT).show()
//
//        })
    }

    //TODO get this viewModel
}
