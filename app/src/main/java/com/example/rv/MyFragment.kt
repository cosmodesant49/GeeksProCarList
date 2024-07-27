package com.example.rv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rv.databinding.FragmentMyBinding

class MyFragment : Fragment() {

    private var _binding: FragmentMyBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: MyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = listOf(
            DataModel("https://www.motortrend.com/uploads/sites/10/2015/11/2008-toyota-camry-xle-v6-sedan-angular-front.png?w=640&width=640&q=75&format=webp", "Toyota", "2000"),
            DataModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTnwXVLLH1vmRml1JtZe_dYCoVd2n-A5thRpA&s", "Toyota", "2010"),
            DataModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQUrETbVjL35U4QF4LDdQ0r5xfekEX38MOuqw&s", "Toyota", "2020")
        )

        adapter = MyAdapter(items, requireContext())
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
