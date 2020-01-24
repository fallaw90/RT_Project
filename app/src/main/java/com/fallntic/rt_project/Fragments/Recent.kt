package com.fallntic.rt_project.Fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import android.widget.TextView

import com.fallntic.rt_project.R
import kotlin.random.Random

/**
 * A simple [Fragment] subclass.
 */
class Recent : Fragment() {

    lateinit var numberPicker: NumberPicker
    lateinit var generate: TextView
    lateinit var numbers : TextView
    lateinit var results : TextView
    var num : Int = 0

    val random = List(10){Random.nextInt(1,100)}


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val v = inflater.inflate(R.layout.fragment_recent_, container, false)

        numberPicker = v.findViewById(R.id.number_picker)
        generate = v.findViewById(R.id.button)
        numbers = v.findViewById(R.id.numbers)
        results = v.findViewById(R.id.result)

        numberPicker.minValue = 1
        numberPicker.maxValue = 10

        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var numGenerate: Boolean = false
        var strnum = random.toString()
        strnum = strnum.removeRange(0,1)
        strnum = strnum.removeRange(strnum.length-1,strnum.length)

        generate.setOnClickListener {
            numbers.text = strnum
            results.text = calcMod(num)
            numGenerate = true
        }


        numberPicker.setOnValueChangedListener { numberPicker, i, i2 ->
            num = numberPicker.value
            if (numGenerate) {
                results.text = calcMod(num)
            }
        }
    }

    fun calcMod(num:Int):String{
        var str: String = ""

        for (i in random) {
            if (i % num == 0) {
                str = str + i + ", "
            }
        }
        if (str.length > 1)
            str = str.removeRange(str.length - 2, str.length)
        else
            str = ""

        return str
    }

}
