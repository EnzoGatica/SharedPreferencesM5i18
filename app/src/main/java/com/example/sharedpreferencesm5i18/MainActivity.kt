package com.example.sharedpreferencesm5i18

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreferencesm5i18.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGuardar.setOnClickListener {
            val entero = binding.editTxtNum1.text.toString()
            val texto = binding.editTxtString.text.toString()
            val decimal = binding.editTxtNum2.text.toString()
            val switch = binding.switch1.isChecked
        }
    }
}