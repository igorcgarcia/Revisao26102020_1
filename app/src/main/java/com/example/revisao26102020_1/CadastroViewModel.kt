package com.example.revisao26102020_1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CadastroViewModel : ViewModel() {

    val socioAtualizado: MutableLiveData<Socio> = MutableLiveData()

    fun setNovoSocio(socio: Socio) {
        socioAtualizado.postValue(socio)
    }

//    fun goToSocio(value: Boolean) {
//        onDataSaved.postValue()
//    }
}

data class Socio(
    val nome: String,
    val email: String,
    val telefone: String
)

