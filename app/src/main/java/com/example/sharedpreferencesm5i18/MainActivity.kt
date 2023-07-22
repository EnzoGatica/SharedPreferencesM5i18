package com.example.sharedpreferencesm5i18

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sharedpreferencesm5i18.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var mSharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mSharedPreferences = getSharedPreferences("cookie", Context.MODE_PRIVATE)
        binding.btnGuardar.setOnClickListener {
            val entero = binding.editTxtNum1.text.toString().toInt()
            val texto = binding.editTxtString.text.toString()
            val decimal = binding.editTxtNum2.text.toString().toFloat()
            val boleano = binding.switch1.isChecked

            guardarDatos(texto,entero, decimal, boleano)
        }
        binding.btnMostrar.setOnClickListener {
            mostrarDatos()
        }
        binding.btnBorrar.setOnClickListener {
            borrar()
        }
    }

    private fun borrar() {
        binding.txtnum1.text = ""
        binding.txtString1.text = ""
        binding.txtNum2.text = ""
        binding.switch1.isChecked = false
    }

    private fun guardarDatos(texto: String, entero: Int, decimal : Float, boleano: Boolean){
        mSharedPreferences.edit().putString("miTeXTO",texto).apply()
        mSharedPreferences.edit().putInt("miEntero",entero).apply()
        mSharedPreferences.edit().putFloat("miDecimal",decimal).apply()
        mSharedPreferences.edit().putBoolean("miBooleano",boleano).apply()

        Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show()
    }

    private fun mostrarDatos() {
        val texto = mSharedPreferences.getString("miTexto","")
        val entero = mSharedPreferences.getInt("miEntero",0)
        val decimal = mSharedPreferences.getFloat("miDecimal",0.0f)
        val boleano = mSharedPreferences.getBoolean("miBooleano",false)

        binding.txtnum1.text = entero.toString()
        binding.txtString1.text = texto
        binding.txtNum2.text = decimal.toString()
        binding.switch1.isChecked = boleano

    }
}