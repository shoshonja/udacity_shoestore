package com.udacity.shoestore.shoelisting

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.activitymain.MainActivityViewModel
import com.udacity.shoestore.databinding.FragmentShoeListingBinding
import com.udacity.shoestore.models.Shoe


class ShoeListingFragment : Fragment() {

    private lateinit var binding: FragmentShoeListingBinding
    private lateinit var viewModel: ShoeListingViewModel
    private lateinit var mainViewModel: MainActivityViewModel //by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_listing, container, false)
        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this).get(ShoeListingViewModel::class.java)
        mainViewModel = ViewModelProvider(requireActivity())[MainActivityViewModel::class.java]



        mainViewModel.shoeList.observe(requireActivity(), { newShoeList ->
            run {
//                Toast.makeText(context, "Shoe is created", Toast.LENGTH_SHORT).show()
                Log.d("SHOE_LOG", "Observer si triggered")

                val name = TextView(context)
                name.text = newShoeList[newShoeList.size-1].name
                name.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                binding.fragmentShoeListingLinear.addView(name)

//                binding.invalidateAll()
//                binding.fragmentShoeListingLinear.addView(tv, -1)
//                binding.fragmentShoeListingLinear.requestLayout()
//                binding.fragmentShoeListingLinear.invalidate()
                Log.d("SHOE_LOG", "View is added")

            }
        })

        //TODO: bug - addView se triggera više puta
        //TODO: bug - addView radi replace view, a ne add



        binding.fragmentShoeListingFab.setOnClickListener {
            findNavController().navigate(R.id.action_shoeListingFragment_to_shoeDetailsFragment)
            //TODO zašto ovo dolje zakomentirano radi, a ono iz Observera ne radi??


//            mainViewModel.addShoe(Shoe("Shoe", 40.0, "sdgf", "sdfg"))


//            val tv = TextView(context)
//            tv.text = "newShoeList[newShoeList.size-1].name"
//            tv.layoutParams = LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT
//            )
//
//            binding.fragmentShoeListingLinear.addView(tv)
        }

        return binding.root
    }


    //TODO back button need to work
    //TODO nav bar needs to work
    //TODO use activity level viewModel instead of safeArgs!
}
