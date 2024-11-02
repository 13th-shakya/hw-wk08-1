package com.example.lab4

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab4.databinding.ActivitySecBinding

@SuppressLint("SetTextI18n")
class SecActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySecBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(view) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnSend.setOnClickListener {
            if (binding.edDrink.text.isEmpty()) {
                Toast.makeText(this, "請輸入飲料名稱", Toast.LENGTH_SHORT).show()
            } else {
                val b = bundleOf(
                    "drink" to binding.edDrink.text.toString(),
                    "sugar" to findViewById<RadioButton>(binding.rgSugar.checkedRadioButtonId).text.toString(),
                    "ice" to findViewById<RadioButton>(binding.rgIce.checkedRadioButtonId).text.toString()
                )
                val i = Intent().putExtras(b)
                setResult(RESULT_OK, i)
                finish()
            }
        }
    }
}
