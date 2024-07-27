package com.example.rv

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.rv.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageUrl = arguments?.getString("imageUrl") ?: ""
        val text = arguments?.getString("text") ?: ""
        val textYear = arguments?.getString("textYear") ?: ""

        Glide.with(this)
            .load(imageUrl)
            .into(binding.imageView)
        binding.textView.text = text
        binding.textViewYear.text = textYear
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
