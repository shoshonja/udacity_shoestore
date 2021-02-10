package com.udacity.shoestore.shoelisting

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.activitymain.MainActivityViewModel
import com.udacity.shoestore.databinding.FragmentShoeListingBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.layout_shoe.view.*


class ShoeListingFragment : Fragment() {

    private lateinit var binding: FragmentShoeListingBinding
    private lateinit var viewModel: ShoeListingViewModel
    private lateinit var mainViewModel: MainActivityViewModel //by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_listing, container, false)
        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this).get(ShoeListingViewModel::class.java)
        mainViewModel = ViewModelProvider(requireActivity())[MainActivityViewModel::class.java]


        setObservers()


//TODO use databinding
        binding.fragmentShoeListingFab.setOnClickListener {
            findNavController().navigate(R.id.action_shoeListingFragment_to_shoeDetailsFragment)
        }

        return binding.root
    }

    private fun setObservers() {
        mainViewModel.shoeList.observe(viewLifecycleOwner, { newShoeList ->
            for (shoe in newShoeList) {
                addLayout(shoe)
            }
        })
    }

    private fun addLayout(shoe: Shoe) {
        val shoeLayout = layoutInflater.inflate(R.layout.layout_shoe, null)
        shoeLayout.layout_shoe_title.text = shoe.name
        shoeLayout.layout_shoe_description.text = shoe.description

        binding.fragmentShoeListingLinear.addView(shoeLayout)
    }
//TODO nav bar needs to work
}
