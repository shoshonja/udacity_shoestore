package com.udacity.shoestore.shoedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.models.Shoe


class ShoeDetailsFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailsBinding
    private lateinit var viewModel: ShoeDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)
        binding.lifecycleOwner = this


        viewModel = ViewModelProvider(this).get(ShoeDetailsViewModel::class.java)

        viewModel.eventCanceled.observe(viewLifecycleOwner, Observer { isCanceled ->
            if (isCanceled) {
                //TODO pop backstack
                goBack()
            }
        })

        viewModel.newShoeDetail.observe(viewLifecycleOwner, Observer { shoe ->
            //TODO return shoe to previous fragment (safeargs)
        })

        binding.fragmentShoeDetailsBtSave.setOnClickListener { shoeSaved(gatherShoeData()) }
        binding.fragmentShoeDetailsBtCancel.setOnClickListener { shoeCanceled() }


        //observe for cancel and new shoe detail

        return binding.root
    }

    private fun gatherShoeData(): Shoe {
        return Shoe(
            binding.fragmentShoeDetailsEtName.text.toString(),
            binding.fragmentShoeDetailsEtSize.text.toString().toDouble(),
            binding.fragmentShoeDetailsEtCompany.toString(),
            binding.fragmentShoeDetailsEtDesc.text.toString(),
            null
        )
    }

    private fun shoeSaved(shoe: Shoe) {
        viewModel.onSave(shoe)
    }

    private fun shoeCanceled() {
        viewModel.onCancel()
    }

    private fun goBack() {
        findNavController().navigateUp()
    }


}