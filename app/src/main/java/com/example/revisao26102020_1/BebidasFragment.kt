package com.example.revisao26102020_1

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.textfield.TextInputEditText


class BebidasFragment : Fragment() {

    private lateinit var etFabBebida: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_bebidas, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initComponents()

    }


    private fun initComponents(){
        activity?.let{

            etFabBebida = it.findViewById(R.id.etFabBebida)
            etFabBebida.addTextChangedListener(MaskWatcher(etFabBebida,
                "##/##/####"))
        }

        val textWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        }

        //etFabricacao.addTextChangedListener(textWatcher)
    }

}
