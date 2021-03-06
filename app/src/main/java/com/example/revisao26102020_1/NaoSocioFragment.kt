package com.example.revisao26102020_1

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputLayout

class NaoSocioFragment : Fragment() {

    private lateinit var etNome: TextInputLayout
    private lateinit var etEmail: TextInputLayout
    private lateinit var etFone: TextInputLayout
    private lateinit var etSenha: TextInputLayout
    private lateinit var etConfSenha: TextInputLayout
    private lateinit var buttonCadastrar: Button
    private lateinit var viewModel: CadastroViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nao_socio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initComponents()
        setupObservables()
    }

    private fun setupObservables(){

//        buttonCadastrar.isEnabled = textChangedDefault(tietName, tilName, R.string.textInputName, isNameOk) &&
//                textChangedDefault(tietEmail, tilEmail, R.string.textInputEmail, isEmailOk) &&
//                textChangedDefault(tietPhone, tilPhone, R.string.textInputPhone, isPhoneOk) &&
//                textChangedDefault(tietPassword, tilPassword, R.string.textInputPassword, isPasswordOk) &&
//                confirmPassword(tietConfirmPassword, tietPassword)

        //criar instancia para validar preenchimento e liberar botao para clique

        buttonCadastrar.setOnClickListener(){
            val nome = etNome.editText?.text.toString()
            val email = etEmail.editText?.text.toString()
            val fone = etFone.editText?.text.toString()
            val senha = etSenha.editText?.text.toString()
            val confSenha = etConfSenha.editText?.text.toString()

            if (nome.isBlank()){
                etNome.error = getString(R.string.campo_obrigatorio)
//              etNome.error = getString(R.string.campo_obrigatorio,getString(R.string.nome_empresa))
            }else {
                etNome.isErrorEnabled = false
            }
            if (email.isBlank()){
                etEmail.error = getString(R.string.campo_obrigatorio)
            }else {
                etEmail.isErrorEnabled = false
            } //validar email valido
            if (fone.isBlank()){
                etFone.error = getString(R.string.campo_obrigatorio)
            }else {
                etFone.isErrorEnabled = false
            }
            if (senha.isBlank()){
                etSenha.error = getString(R.string.campo_obrigatorio)
            }else {
                etSenha.isErrorEnabled = false
            }
            if (confSenha.isBlank()){
                etConfSenha.error = getString(R.string.campo_obrigatorio)
            }else {
                etConfSenha.isErrorEnabled = false
                if(senha != confSenha){
                    etConfSenha.error = getString(R.string.senha_diferente)
                } else {
                    etConfSenha.isErrorEnabled = false
                }//melhorar script
            }


                viewModel.setNovoSocio(
                    Socio(
                        nome = nome,
                        email = email,
                        telefone = fone
                    )
                )
            
        }
    }

    fun textChangedDefault(editText: EditText, textInput: TextInputLayout, errorString: Int, xpto: Boolean): Boolean {

//        Log.i("validaPreenchimento()",validaPreenchimento().toString())
//        if (!validaPreenchimento()) {
//            buttonCadastrar.isEnabled = true
//            viewModel.setNovoSocio(
//                Socio(
//                    nome = nome,
//                    email = email,
//                    telefone = fone
//                )
//            )
//        } else {
//            buttonCadastrar.isEnabled = false
//        }

        return true
    }




    private fun initComponents(){
        activity?.let{

            viewModel = ViewModelProvider(it).get(CadastroViewModel::class.java)

            etNome = it.findViewById(R.id.textField)
            etEmail = it.findViewById(R.id.textEmail)
            etFone = it.findViewById(R.id.textTelefone)
            etSenha = it.findViewById(R.id.textSenha)
            etConfSenha = it.findViewById(R.id.textConfSenha)
            buttonCadastrar = it.findViewById(R.id.buttonCadastrar)
        }
    }

    //it.tabLayout.getTabAt(1).select()
    // trocar para o próximo fragment



    fun validaPreenchimento():Boolean{
        return etNome.isErrorEnabled && etEmail.isErrorEnabled && etFone.isErrorEnabled && etSenha.isErrorEnabled && etConfSenha.isErrorEnabled
    }
}