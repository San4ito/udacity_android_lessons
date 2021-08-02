package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.InputDevice
import android.view.View
import android.view.inputmethod.InputMethod
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    public lateinit var binding: ActivityMainBinding
    private val sashaName: MyName = MyName("Sashko")
    private val coffename: CoffeName = CoffeName("Robusta")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = sashaName
        binding.coffeName = coffename

        binding.BtnDone.setOnClickListener {
            addCoffeName(it)
        }
    }

    private fun addCoffeName(view: View) {
        binding.apply {
            coffeName?.coffe = TextEditCoffe.text.toString()
            invalidateAll()
            TextEditCoffe.visibility = View.GONE
            BtnDone.visibility = View.GONE
            textView2.visibility = View.VISIBLE
        }

        //Hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}