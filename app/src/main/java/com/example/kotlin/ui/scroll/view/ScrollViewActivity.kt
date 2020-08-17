package com.example.kotlin.ui.scroll.view

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.R
import com.example.kotlin.ui.ItemsList
import com.example.kotlin.ui.scroll.ExampleModel
import com.example.kotlin.ui.scroll.adapter.ScrollViewAdapter
import kotlinx.android.synthetic.main.activity_scroll_view.*
import timber.log.Timber


class ScrollViewActivity : AppCompatActivity() {

    private var count: Int = 0
    lateinit var scrollViewAdapter: ScrollViewAdapter

    var arrayList: ArrayList<String> = ArrayList()

    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var exampleModelList: ArrayList<ExampleModel>

    companion object {
        val TAG: String = javaClass.simpleName
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll_view)

        // set Data
        arrayList.add("Yellow")
        arrayList.add("Red")
        arrayList.add("Blue")
        arrayList.add("Violet")
        arrayList.add("green")
        arrayList.add("Pink End")


        initRecyclerView()


        nested_scrollview.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            if (v.getChildAt(v.childCount - 1) != null) {
                val visibleItemCount: Int = linearLayoutManager.childCount
                val totalItemCount: Int = linearLayoutManager.itemCount
                val pastVisiblesItems: Int = linearLayoutManager.findFirstVisibleItemPosition()

                if (visibleItemCount + pastVisiblesItems >= totalItemCount) {
                    //Load Your Data

                    count++;
                    if (count == 1) {

                        Handler().postDelayed({
                            arrayList.add("Orange New")
                            arrayList.add("Black")
                            arrayList.add("White")

                            scrollViewAdapter.notifyDataSetChanged()
                            progressBar.visibility = View.GONE
                        }, 5000)

                    }

                }

            }
        })

        // default parameters
        normalFunction(10)

        // setting model class values
        var exampleModel: ExampleModel = ExampleModel()
        exampleModel.name = "Android"
        exampleModel.id = 1
        exampleModel.Designation = "Android Developer"

        exampleModelList = ArrayList()
        exampleModelList.add(exampleModel)


        callMethod()

        Timber.d("ScrollViewActivity")


    }

    private fun callMethod() {

        // atleast one parameter need
        // var or val need
        // it holds the state/data

       data class Person(val name: String, val id: Int)

        val person: Person = Person("Nivi", 1)
        val person1: Person = Person("Nivi", 1)

        val p2 = person1.copy(id = 10)

        if (person == person1) {
            Timber.d(">>> check values true: ${person.component1()}")
            Timber.d(">>> check values toString: ${person.toString()}")
            Timber.d(">>> check values copy p2: $p2")
            Timber.d(">>> check values hashCode for Person: ${person.hashCode()}")
            Timber.d(">>> check values hashCode for Person1: ${person1.hashCode()}")
        } else {
            Timber.d(">>> check values false: $person")
            Timber.d(">>> check values false: $person1")
        }

    }

    private fun initRecyclerView() {
        linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = RecyclerView.VERTICAL
        rv_list.layoutManager = linearLayoutManager
        scrollViewAdapter = ScrollViewAdapter(arrayList)
        rv_list.adapter = scrollViewAdapter

    }

    fun normalFunction(a: Int = 5) {
        Log.e(TAG, "normalFunction:a value " + a)
    }
}