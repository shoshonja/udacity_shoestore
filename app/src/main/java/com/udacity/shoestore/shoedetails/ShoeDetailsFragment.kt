package com.udacity.shoestore.shoedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.activitymain.MainActivityViewModel
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.models.Shoe


class ShoeDetailsFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailsBinding
    private lateinit var viewModel: ShoeDetailsViewModel
    private lateinit var mainViewModel: MainActivityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)

        viewModel = ViewModelProvider(this).get(ShoeDetailsViewModel::class.java)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        setObservers()

        return binding.root
    }

    private fun setObservers() {
        viewModel.eventCanceled.observe(viewLifecycleOwner, Observer { isCanceled ->
            if (isCanceled) {
                shoeCanceled()
            }
        })

        viewModel.newShoe.observe(viewLifecycleOwner, Observer { newShoe ->
            shoeSaved(newShoe)
        })
    }

    private fun shoeSaved(shoe: Shoe) {
        mainViewModel.addShoe(shoe)
        goBack()
    }

    private fun shoeCanceled() {
        goBack()
    }

    private fun goBack() {
        findNavController().navigateUp()
    }

}