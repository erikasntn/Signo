package com.has.prova

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.text.Spanned
import android.widget.*
import com.has.prova.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener{ descobrirSigno() }

        val dayInput = findViewById<EditText>(R.id.editTextDiaAniv)
        dayInput.filters = arrayOf<InputFilter>(
            InputFilter.LengthFilter(2),
            InputFilterMinMax("1", "31")
        )

        val monthInput = findViewById<EditText>(R.id.editTextMesAniv)
        monthInput.filters = arrayOf<InputFilter>(
            InputFilter.LengthFilter(2),
            InputFilterMinMax("1", "12")
        )

    }

    fun descobrirSigno() {
        val MesText = binding.editTextMesAniv.text.toString()
        val mesInt = MesText.toInt()

        val DiaText = binding.editTextDiaAniv.text.toString()
        val diaInt = DiaText.toInt()

        val SignoImage: ImageView = findViewById(R.id.imageView)
        val SignoText = binding.retorno

        when(mesInt) {
            1 -> if(diaInt >= 1 && diaInt < 20) {
                SignoImage.setImageResource(R.drawable.imgcapricornio)
                SignoText.text = "Você é de Capricornio"
            } else {
                SignoImage.setImageResource(R.drawable.imgaquario)
                SignoText.text = "Você é de Aquário"
            }
            2 -> if(diaInt >= 1 && diaInt < 20) {
                SignoImage.setImageResource(R.drawable.imgaquario)
                SignoText.text = "Você é de Aquário"
            } else {
                SignoImage.setImageResource(R.drawable.imgpeixes)
                SignoText.text = "Você é de Peixes"
            }
            3 -> if(diaInt >= 1 && diaInt < 21) {
                SignoImage.setImageResource(R.drawable.imgpeixes)
                SignoText.text = "Você é de Peixes"
            } else {
                SignoImage.setImageResource(R.drawable.imgaries)
                SignoText.text = "Você é de Áries"
            }
            4 -> if(diaInt >= 1 && diaInt < 21) {
                SignoImage.setImageResource(R.drawable.imgaries)
                SignoText.text = "Você é de Áries"
            } else {
                SignoImage.setImageResource(R.drawable.imgtouro)
                SignoText.text = "Você é de Touro"
            }
            5 -> if(diaInt >= 1 && diaInt < 21) {
                SignoImage.setImageResource(R.drawable.imgtouro)
                SignoText.text = "Você é de Touro"
            } else {
                SignoImage.setImageResource(R.drawable.imggemeos)
                SignoText.text = "Você é de Gêmeos"
            }
            6 -> if(diaInt >= 1 && diaInt < 21) {
                SignoImage.setImageResource(R.drawable.imggemeos)
                SignoText.text = "Você é de Gêmeos"
            } else {
                SignoImage.setImageResource(R.drawable.imgcancer)
                SignoText.text = "Você é de Câncer"
            }
            7 -> if(diaInt >= 1 && diaInt < 23) {
                SignoImage.setImageResource(R.drawable.imgcancer)
                SignoText.text = "Você é de Câncer"
            } else {
                SignoImage.setImageResource(R.drawable.imgleao)
                SignoText.text = "Você é de Leão"
            }
            8 -> if(diaInt >= 1 && diaInt < 23) {
                SignoImage.setImageResource(R.drawable.imgleao)
                SignoText.text = "Você é de Leão"
            } else {
                SignoImage.setImageResource(R.drawable.imgvirgem)
                SignoText.text = "Você é de Virgem"
            }
            9 -> if(diaInt >= 1 && diaInt < 23) {
                SignoImage.setImageResource(R.drawable.imgvirgem)
                SignoText.text = "Você é de Virgem"
            } else {
                SignoImage.setImageResource(R.drawable.imglibra)
                SignoText.text = "Você é de Libra"
            }
            10 -> if(diaInt >= 1 && diaInt < 23) {
                SignoImage.setImageResource(R.drawable.imglibra)
                SignoText.text = "Você é de Libra"
            } else {
                SignoImage.setImageResource(R.drawable.imgescorpiao)
                SignoText.text = "Você é de Escorpião"
            }
            11 -> if(diaInt >= 1 && diaInt < 22) {
                SignoImage.setImageResource(R.drawable.imgescorpiao)
                SignoText.text = "Você é de Escorpião"
            } else {
                SignoImage.setImageResource(R.drawable.imgsagitario)
                SignoText.text = "Você é de Sagitário"
            }
            12 -> if(diaInt >= 1 && diaInt < 22) {
                SignoImage.setImageResource(R.drawable.imgsagitario)
                SignoText.text = "Você é de Sagitário"
            } else {
                SignoImage.setImageResource(R.drawable.imgcapricornio)
                SignoText.text = "Você é de Capricórnio"
            }
        }

    }

} //Aioria de Leão, Shaka de Virgem, Dohko de Libra, Milo de Escorpião, Aioros de Sagitário

class InputFilterMinMax : InputFilter {
    private var min: Int
    private var max: Int

    constructor(minValue: Int, maxValue: Int) {
        this.min = minValue
        this.max = maxValue
    }

    constructor(minValue: String, maxValue: String) {
        this.min = minValue.toInt()
        this.max = maxValue.toInt()
    }

    override fun filter(
        source: CharSequence,
        start: Int,
        end: Int,
        dest: Spanned,
        dstart: Int,
        dend: Int
    ): CharSequence? {
        try {
            val input = (dest.toString() + source.toString()).toInt()
            if (isInRange(min, max, input)) return null
        } catch (nfe: NumberFormatException) {
        }
        return ""
    }

    private fun isInRange(a: Int, b: Int, c: Int): Boolean {
        return if (b > a) c in a..b else c in b..a
    }
}








