package com.androidbolts.topsheet

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.androidbolts.topsheet.databinding.FragmentTopSheetBinding

class TopSheetFragment : Fragment() {
    private lateinit var binding: FragmentTopSheetBinding
    private var listener: ButtonClickCompleteListener? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_top_sheet, null, false)
        binding.btnClick.setOnClickListener {
            val toast = Toast.makeText(requireContext(), "Click Click", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
            listener?.onButtonClicked()
        }
        return binding.root
    }

    fun setListener(listener: ButtonClickCompleteListener) {
        this.listener = listener
    }

    interface ButtonClickCompleteListener {
        fun onButtonClicked()
    }
}