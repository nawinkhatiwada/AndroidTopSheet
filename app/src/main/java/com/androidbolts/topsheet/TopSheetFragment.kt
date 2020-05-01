package com.androidbolts.topsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.androidbolts.topsheet.databinding.FragmentTopSheetBinding

class TopSheetFragment : Fragment() {
    private lateinit var binding: FragmentTopSheetBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_top_sheet, null, false)
        return binding.root
    }
}