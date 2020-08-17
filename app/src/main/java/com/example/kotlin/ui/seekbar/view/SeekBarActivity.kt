package com.example.kotlin.ui.seekbar.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.R
import com.example.kotlin.ui.scroll.view.ScrollViewActivity
import kotlinx.android.synthetic.main.activity_seek_bar.*
import timber.log.Timber


class SeekBarActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seek_bar)


        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                Toast.makeText(
                    this@SeekBarActivity,
                    "Progress is: " + seekBar.progress + "%",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })



        discreate_seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                //here we can write some code to do something when progress is changed
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                //here we can write some code to do something whenever the user touche the seekbar
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // show some message after user stopped scrolling the seekbar
                Toast.makeText(
                    this@SeekBarActivity,
                    "Discrete Value of SeekBar is  " + seekBar.progress,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

        btn_submit.setOnClickListener(View.OnClickListener {
            val rating = "Rating is :" + ratingBar.rating
            if (ratingBar.rating == 0.0F) {
                Toast.makeText(this, "Give Rating", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, rating, Toast.LENGTH_LONG).show()

            }
        })

        btn_move.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ScrollViewActivity::class.java)
            // start your next activity
            startActivity(intent)
        })


        // lambda expression with function
        val lambda: (Int) -> Unit = { s: Int -> println("Sum Value: ${s}") }

        LamdaFuntions(4, 5, lambda)
//        LamdaFuntions(4,5,{ s-> println("Sum Value: ${s}") })
//        LamdaFuntions(4,5){ s-> println("Sum Value: ${s}") }

//        Parameters("Nive ")
        Parameters("Nive ", 10)


    }


    private fun LamdaFuntions(i: Int, i1: Int, lambda: (Int) -> Unit) {

        val add = i + i1
        lambda(add)

    }

    inner class Parameters(stringName: String) {

        init {
            Log.e("Nive ", ":ParametersName " + stringName)
        }

        constructor(name: String, id: Int) : this(name) {
            Log.e("Nive ", ":Secondary Constructor ${name} : ${id}")
        }
    }

}


