package ar.edu.unlam.viewmodels.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ar.edu.unlam.viewmodels.databinding.ActivityMainBinding
import ar.edu.unlam.viewmodels.ui.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val vm: MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListeners()
        setObservers()
    }

    private fun setListeners() {
        binding.btnSumar.setOnClickListener {
            vm.add()
        }
        binding.btnRestar.setOnClickListener {
            vm.delete()
        }
    }

    private fun setObservers() {
        binding.texto.text = vm.get().toString()  // ver número inicial desde que se lanza la app
        vm.numero.observe(this, {
            binding.texto.text = it.toString()
        })
    }
}