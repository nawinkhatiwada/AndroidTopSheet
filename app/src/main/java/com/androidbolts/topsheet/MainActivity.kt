package com.androidbolts.topsheet

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.databinding.DataBindingUtil
import com.androidbolts.topsheet.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), TopSheetFragment.ButtonClickCompleteListener {
    private lateinit var binding: ActivityMainBinding
    private val rotation = 0f
    private var fragment: TopSheetFragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        fragment = TopSheetFragment()
        fragment?.let { frag ->
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, frag)
                .commit()
            frag.setListener(this)
        }

        binding.motionLayout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
            }

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
                binding.icon.animate().rotationBy(180f)
            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
            }
        })

        binding.fragmentContainer.setOnClickListener {
            Toast.makeText(this, "Button Button", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        super.onResume()
        fragment?.setListener(this)
    }

    override fun onButtonClicked() {
        // set the state to initial state after button click from Top sheet fragment
        binding.motionLayout.transitionToStart()
    }
}
