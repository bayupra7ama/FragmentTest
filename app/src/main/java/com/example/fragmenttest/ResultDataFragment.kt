package com.example.fragmenttest

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

// TODO: disini menerima data dengan bundel dan menerima data dengan set dan get 

class ResultDataFragment : Fragment() {

    private lateinit var tvFragmentName : TextView
    private lateinit var tvFragmentDescription : TextView
    var description:String?  = null

    companion object{
       const val EXTRA_NAME = "extra_name"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvFragmentName = view.findViewById(R.id.tv_fragment_name)
        tvFragmentDescription = view.findViewById(R.id.tv_fragment_description)

        if (arguments != null){
            val fragmentName = arguments?.getString(EXTRA_NAME)
            tvFragmentName.text = fragmentName

                //menangkap dengan set
            tvFragmentDescription.text = description

        }
    }
}