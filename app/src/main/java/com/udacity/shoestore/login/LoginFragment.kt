package com.udacity.shoestore.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.fragmentLoginBtExisting.setOnClickListener { view: View ->
            navigateToWelcomeFragment(view)
        }

        binding.fragmentLoginBtNew.setOnClickListener { view: View ->
            navigateToWelcomeFragment(view)
        }

        return binding.root
    }

    private fun navigateToWelcomeFragment(view: View) {
        view.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)

    }
}