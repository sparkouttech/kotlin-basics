package com.example.kotlin.ui.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.kotlin.BuildConfig
import com.example.kotlin.R
import com.example.kotlin.ui.scroll.view.ScrollViewActivity
import com.example.kotlin.ui.seekbar.view.SeekBarActivity
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    var stringName = "SparkoutTech"
    val stringSecond: String? = null

    // use only non null values, must initialize before use that value, use only mutable data type var
    lateinit var stringLater: String

    // lazy initialize
    val pi: Float = 3.1F

    // when use that pi1 value after that memory will be allocated
    // it is thread safe means only one time memory will be allocated second case use cache memory
    val pi1: Float by lazy {
        3.14F
    }


    // Initialize a new array with elements
    val colors = arrayOf(
        "Red", "Green", "Blue", "Maroon", "Magenta",
        "Gold", "GreenYellow"
    )

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timber.d(">>>> Nive is printing for chekcing${stringName}")


        // to setting the dynamic value to the textview
        text_view_sample.text =
            stringName.plus(" ").plus(resources.getString(R.string.msg_solutions))

        // setting Animation to TextView
        val animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in)
        text_view_sample.startAnimation(animationFadeIn)

        text_view_sample.setOnClickListener {
            Toast.makeText(this, text_view_sample.text.toString(), Toast.LENGTH_LONG).show()
            val intent = Intent(this, SeekBarActivity::class.java)
            // start your next activity
            startActivity(intent)
        }

//        text_view_Second.text = stringLater
        checkNullableCaseSafe()
        autocompleteView()


    }

    private fun autocompleteView() {

        val adapter = ArrayAdapter<String>(
            this, // Context
            android.R.layout.simple_dropdown_item_1line, // Layout
            colors // Array
        )
        // Set the AutoCompleteTextView adapter
        autoTextView.setAdapter(adapter)
        autoTextView.setOnClickListener(View.OnClickListener {
            autoTextView.showDropDown()
        })


    }

    private fun checkNullableCaseSafe() {
        // 1. safe call returns the length if nam is not null else returns Null
        text_view_Second.text = stringSecond?.length.toString()
    }

    private fun checkNullableCaseLet() {
        // 2.safe call with let operator it executes the block only if name is not null
        stringSecond?.let {
            text_view_Second.text = stringSecond.length.toString()
        }
    }


    private fun checkNullableCaseElvis() {
        text_view_Second.text = (stringSecond?.length ?: "Empty").toString()

    }

    private fun checkNullableCaseNonNull() {
        // non null assertion operator
        // use it only when you are sure that value non null
        // if value is found null throws null pointer exception

        if (stringSecond != null) {
            // throws exception
        } else {
            // use it
        }


        text_view_Second.text = stringSecond!!.length.toString()
    }


}