package com.dicoding.greenmor.ui.control

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dicoding.greenmor.R
import com.dicoding.greenmor.databinding.FragmentControlBinding

class ControlFragment : Fragment() {
    private var _binding: FragmentControlBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(ControlViewModel::class.java)

        _binding = FragmentControlBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.switchLamp.setOnCheckedChangeListener{_, isChecked ->
            if(isChecked){
                binding.statusLamp.text = "On"
                binding.statusLamp.setTextColor(getResources().getColor(R.color.teal_200))
            } else {
                binding.statusLamp.text = "Off"
                binding.statusLamp.setTextColor(getResources().getColor(R.color.danger))
            }
        }
        binding.switchFan.setOnCheckedChangeListener{_, isChecked ->
            if(isChecked){
                binding.statusFan.text = "On"
                binding.statusFan.setTextColor(getResources().getColor(R.color.teal_200))
            } else {
                binding.statusFan.text = "Off"
                binding.statusFan.setTextColor(getResources().getColor(R.color.danger))
            }
        }
        binding.switchPump.setOnCheckedChangeListener{_, isChecked ->
            if(isChecked){
                binding.statusPump.text = "On"
                binding.statusPump.setTextColor(getResources().getColor(R.color.teal_200))
            } else {
                binding.statusPump.text = "Off"
                binding.statusPump.setTextColor(getResources().getColor(R.color.danger))
            }
        }
        binding.switchWater.setOnCheckedChangeListener{_, isChecked ->
            if(isChecked){
                binding.statusWater.text = "On"
                binding.statusWater.setTextColor(getResources().getColor(R.color.teal_200))
            } else {
                binding.statusWater.text = "Off"
                binding.statusWater.setTextColor(getResources().getColor(R.color.danger))
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}