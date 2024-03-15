package com.example.fragmenttest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

// TODO: disini berpindah fragment tampa berpinda activity
class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnMoveFragment:Button = view.findViewById(R.id.move_fragment)

        btnMoveFragment.setOnClickListener{
            val fragmentManager = parentFragmentManager
            val optionsFragment = OptionsFragment()
            fragmentManager.beginTransaction()
                .apply {
                    replace(R.id.frame_container,optionsFragment,OptionsFragment::class.java.simpleName)
                        .addToBackStack(null)
                        .commit()
                }

        }
    }

}