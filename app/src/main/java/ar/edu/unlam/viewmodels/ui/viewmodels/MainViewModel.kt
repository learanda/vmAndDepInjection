package ar.edu.unlam.viewmodels.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.viewmodels.data.NumeroRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(val numberRepository: NumeroRepository) : ViewModel() {

    var numero = MutableLiveData<Int>()

    fun add() {
        numberRepository.add()
        viewModelScope.launch {
            delay(1000L)
            numero.value = numberRepository.get()
        }
    }

    fun delete() {
        numberRepository.delete()
        viewModelScope.launch {
            numero.value = numberRepository.get()
        }
    }

    fun get(): Int {
        return numberRepository.get()
    }
}