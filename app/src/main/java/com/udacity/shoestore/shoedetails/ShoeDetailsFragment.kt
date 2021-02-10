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
        binding.lifecycleOwner = this


        viewModel = ViewModelProvider(this).get(ShoeDetailsViewModel::class.java)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)

        setObservers()
        setLiseners()

        return binding.root
    }

    private fun setObservers() {
        viewModel.eventCanceled.observe(viewLifecycleOwner, Observer { isCanceled ->
            if (isCanceled) {
                shoeCanceled()
            }
        })

        viewModel.eventSaved.observe(viewLifecycleOwner, Observer { isSaved ->
            if (isSaved) {
                shoeSaved(gatherShoeData())
            }
        })
    }

    private fun setLiseners() {
        binding.fragmentShoeDetailsBtSave.setOnClickListener { viewModel.onSave() }
        binding.fragmentShoeDetailsBtCancel.setOnClickListener { viewModel.onCancel() }
    }


    private fun gatherShoeData(): Shoe {
        return Shoe(
            viewModel.handleEmptyEditTexts(binding.fragmentShoeDetailsEtName.text.toString()),
            viewModel.handleEmptyEditTextsAsDoubles(binding.fragmentShoeDetailsEtSize.text.toString()),
            viewModel.handleEmptyEditTexts(binding.fragmentShoeDetailsEtCompany.text.toString()),
            viewModel.handleEmptyEditTexts(binding.fragmentShoeDetailsEtDesc.text.toString()),
            null
        )
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