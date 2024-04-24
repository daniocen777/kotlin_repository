package com.danicode.basic.imc_calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.danicode.basic.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {
    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var currentHeight: Int = 120
    private var currentWeight: Int = 60
    private var currentAge: Int = 30

    private lateinit var cvMale: CardView;
    private lateinit var cvFemale: CardView;
    private lateinit var tvHeight: TextView;
    private lateinit var rsHeight: RangeSlider;
    private lateinit var tvWeight: TextView;
    private lateinit var fabSubtractWeight: FloatingActionButton;
    private lateinit var fabPlusWeight: FloatingActionButton;
    private lateinit var tvAge: TextView;
    private lateinit var fabSubtractAge: FloatingActionButton;
    private lateinit var fabPlusAge: FloatingActionButton;
    private lateinit var btnCalculate: Button
    // Creando un objeto donde todos puedan acceder a el
    companion object {
        const val IMC_KEY = "IMC_RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)
        initComponents()
        initListeners()
        initUI()
    }

    private fun initComponents() {
        cvMale = findViewById(R.id.cvMale)
        cvFemale = findViewById(R.id.cvFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        tvWeight = findViewById(R.id.tvWeight)
        fabSubtractWeight = findViewById(R.id.fabSubtractWeight)
        fabPlusWeight = findViewById(R.id.fabPlusWeight)
        tvAge = findViewById(R.id.tvAge)
        fabSubtractAge = findViewById(R.id.fabSubtractAge)
        fabPlusAge = findViewById(R.id.fabPlusAge)
        btnCalculate = findViewById(R.id.btnCalculate)

    }

    private fun initListeners() {
        cvMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        cvFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }

        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            currentHeight = df.format(value).toInt()
            tvHeight.text = "$currentHeight cm"
        }

        fabSubtractWeight.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }
        fabPlusWeight.setOnClickListener {
            currentWeight += 1
            setWeight()
        }

        fabSubtractAge.setOnClickListener {
            currentAge -= 1
            setAge()
        }
        fabPlusAge.setOnClickListener {
            currentAge += 1
            setAge()
        }

        btnCalculate.setOnClickListener {
            val result = calculateIMC()
            navigateToResult(result)
        }
    }

    private fun navigateToResult(result: Double) {
        val intent = Intent(this, ResultImcActivity::class.java)
        intent.putExtra(IMC_KEY, result)
        startActivity(intent)
    }

    private fun calculateIMC(): Double {
        val df = DecimalFormat("#.##")
        val denominator = currentHeight.toDouble().div(100) *
                currentHeight.toDouble().div(100)
        val imc = currentWeight / denominator
        return df.format(imc).toDouble()

    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    private fun setGenderColor() {
        cvMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        cvFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {
        val referenceColor = if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }

        return ContextCompat.getColor(this, referenceColor)
    }

    private fun setWeight() {
        tvWeight.text = currentWeight.toString()
    }

    private fun setAge() {
        tvAge.text = currentAge.toString()
    }

    private fun initUI() {
        setGenderColor()
        setWeight()
        setAge()
    }
}
