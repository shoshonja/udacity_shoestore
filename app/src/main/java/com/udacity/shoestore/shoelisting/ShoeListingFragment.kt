package com.udacity.shoestore.shoelisting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.activitymain.MainActivityViewModel
import com.udacity.shoestore.databinding.FragmentShoeListingBinding

class ShoeListingFragment : Fragment() {

    private lateinit var binding: FragmentShoeListingBinding
    private lateinit var viewModel: ShoeListingViewModel
    private lateinit var mainViewModel: MainActivityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_listing, container, false)
        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this).get(ShoeListingViewModel::class.java)
        mainViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        mainViewModel.shoeList.observe(viewLifecycleOwner, Observer {
            //TODO populate listview
            Toast.makeText(context, "Shoe is created", Toast.LENGTH_SHORT).show()
        })




        binding.fragmentShoeListingFab.setOnClickListener {
            findNavController().navigate(R.id.action_shoeListingFragment_to_shoeDetailsFragment)
        }

        return binding.root
    }


    //TODO back button need to work
    //TODO nav bar needs to work
    //TODO list view needs to be populated with shoes - just list view, not a custom one
    //TODO get args from bundle - safeargs
    //TODO or use activity level viewModel instead of safeArgs!
}
