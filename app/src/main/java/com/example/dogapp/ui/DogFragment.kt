package com.example.dogapp.ui

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.dogapp.databinding.FragmentDogBinding
import com.example.dogapp.viewmodel.DogFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DogFragment : Fragment() {
    private val viewModel: DogFragmentViewModel by viewModels()

    lateinit var binding: FragmentDogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDogBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backgroundAnimation()
        getSetImage()
        binding.floatingActionButton.setOnClickListener {
            viewModel.getDogImage()
        }

    }


    private fun getSetImage() {
        viewModel.dogResponse.observe(viewLifecycleOwner) { data ->

            if (data.isSuccessful) {
                val context = binding.root.context
                Glide.with(context).load(data.body()?.url)
                    .into(binding.ivRandomDog)

            }
        }


    }

    private fun backgroundAnimation() {
        val animationDrawable: AnimationDrawable =
            binding.fragmentDog.background as AnimationDrawable
        animationDrawable.apply {
            setEnterFadeDuration(1000)
            setExitFadeDuration(3000)
            start()
        }
    }


}
