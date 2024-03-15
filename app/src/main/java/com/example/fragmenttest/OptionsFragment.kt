package com.example.fragmenttest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

// TODO: disini mengirm data dengan set dan get , dan juga mengirim data dengan bundel
// TODO: menampilkan jendela dialog dengan radio button , dan menampilkan hasil radio button yang di pilih


class OptionsFragment : Fragment() {
    private lateinit var btnShowDIalog : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_options, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnMoveWithData : Button = view.findViewById(R.id.btn_move_with_data)
        btnMoveWithData.setOnClickListener{
            val resultDataFragment = ResultDataFragment()

            //mengirim data mengunakan bundel
            val bundle = Bundle()
            bundle.putString(ResultDataFragment.EXTRA_NAME,"Fragment Hasil")
            val kirimDescription = "Disini Hasil dari Description menggunakan set dan get"

            //mengirim data dengan bundel
            resultDataFragment.arguments = bundle

                //mengirim data dengan set and get
            resultDataFragment.description = kirimDescription


            val fragmentManager = parentFragmentManager

            fragmentManager.beginTransaction().apply {
                replace(R.id.frame_container,resultDataFragment,ResultDataFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }

        btnShowDIalog = view.findViewById(R.id.btn_dialog)
        btnShowDIalog.setOnClickListener {
            val optionDialogFragment = optionDialogFragment()
            //menggunakamn child fragment pada nested fragment agar lebih cepat
            val fragmentManager = childFragmentManager


            //menampilkan dialog ke fragment
            optionDialogFragment.show(fragmentManager , optionDialogFragment::class.java.simpleName)
        }

    }
    internal var optionDialogListener : optionDialogFragment.OnOptionDialogListener = object : optionDialogFragment.OnOptionDialogListener{

        override fun onOptionChosen(text: String?) {
            Toast.makeText(requireActivity(), text, Toast.LENGTH_SHORT).show()
        }

    }


}