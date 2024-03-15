package com.example.fragmenttest

import android.content.Context
import android.graphics.Path.Op
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment


class optionDialogFragment : DialogFragment() {

    private lateinit var btnChoose: Button
    private lateinit var btnClose: Button
    private lateinit var rgOptions: RadioGroup
    private lateinit var rbSaf: RadioButton
    private lateinit var rbMou: RadioButton
    private lateinit var rbEth: RadioButton
    private lateinit var rbMoyes: RadioButton
    private var optionDialogListener: OnOptionDialogListener? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_option_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnChoose = view.findViewById(R.id.btn_choose)
        btnClose = view.findViewById(R.id.btn_close)
        rgOptions = view.findViewById(R.id.rg_options)
        rbEth = view.findViewById(R.id.rb_eth)
        rbMou = view.findViewById(R.id.rb_mou)
        rbMoyes = view.findViewById(R.id.rb_moyes)
        rbSaf = view.findViewById(R.id.rb_saf)

        btnChoose.setOnClickListener{
            val checkRadioButtonId = rgOptions.checkedRadioButtonId
            if (checkRadioButtonId != -1){
                var coach :String? = when (checkRadioButtonId){
                    R.id.rb_saf -> rbSaf.text.toString().trim()
                    R.id.rb_eth -> rbEth.text.toString().trim()
                    R.id.rb_moyes -> rbMoyes.text.toString().trim()
                    R.id.rb_mou -> rbMou.text.toString().trim()
                    else -> null
                }
                optionDialogListener?.onOptionChosen(coach)
                dialog?.dismiss()
            }

        }
        btnClose.setOnClickListener{
            dialog?.cancel()
        }

    }

    //untuk mengelola dialog digunakan atau tidak

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val fragment = parentFragment

        if (fragment is OptionsFragment) {
            this.optionDialogListener = fragment.optionDialogListener
        }
    }
    //untuk mengelola dialog tidak digunakan

    override fun onDetach() {
        super.onDetach()
        this.optionDialogListener = null
    }


    interface OnOptionDialogListener {
       fun onOptionChosen(text : String?)
    }

}

