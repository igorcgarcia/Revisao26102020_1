package com.example.revisao26102020_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider


class SocioFragment : Fragment() {

    private lateinit var viewModel : CadastroViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_socio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //val texto = it.findViewById(R.id.tvNomeEmpresa)

        activity?.let {
            viewModel = ViewModelProvider(it).get(CadastroViewModel::class.java)

            viewModel.socioAtualizado.observe(viewLifecycleOwner) {
                activity?.findViewById<TextView>(R.id.tvNomeEmpresa)?.text =
                    "O novo sócio é ${it.nome}\ncom e-mail ${it.email}\ne o telefone ${it.telefone}"
            }

        }
    }
}