package com.example.revisao26102020_1

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.textfield.TextInputEditText


class SalgadosFragment : Fragment() {

    private lateinit var etFabricacao: TextInputEditText
    private lateinit var etValor: TextInputEditText


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_salgados, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initComponents()

    }

    private fun initComponents(){
        activity?.let{

            etFabricacao = it.findViewById(R.id.etFabricacao)
            etFabricacao.addTextChangedListener(MaskWatcher(etFabricacao,
                "##/##/####"))

            etValor = it.findViewById(R.id.etValor)
            etValor.addTextChangedListener(MaskWatcher(etValor,
            "#####.##"))
        }


        //etFabricacao.addTextChangedListener(textWatcher)
    }
}