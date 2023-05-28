package com.dicoding.greenmor.ui.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.greenmor.R
import com.dicoding.greenmor.databinding.FragmentInfoBinding
import com.dicoding.greenmor.ui.control.Hero
import com.dicoding.greenmor.ui.control.InfoViewModel
import com.dicoding.greenmor.ui.control.ListHeroAdapter

class InfoFragment : Fragment() {

    private val list = ArrayList<Info>()

    private var _binding: FragmentInfoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(InfoViewModel::class.java)

        _binding = FragmentInfoBinding.inflate(inflater, container, false)
        val root: View = binding.root

        list.addAll(getListInfo())
        showRecyclerList()

        return root
    }
    private fun getListInfo(): ArrayList<Info> {
        val dataName = resources.getStringArray(R.array.data_info_name)
        val dataPhoto = resources.obtainTypedArray(R.array.data_info_photo)
        val listInfo = ArrayList<Info>()
        for (i in dataName.indices) {
            val hero = Info(dataName[i], dataPhoto.getResourceId(i, -1))
            listInfo.add(hero)
        }
        return listInfo
    }

    private fun showRecyclerList() {
        val listInfoAdapter = InfoAdapter(list, requireContext())
        binding.rvInfo.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
        binding.rvInfo.adapter = listInfoAdapter

        binding.rvPopular.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
        binding.rvPopular.adapter = listInfoAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}