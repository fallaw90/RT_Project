package com.fallntic.rt_project.Fragments


import android.annotation.SuppressLint
import android.graphics.Color
import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.fallntic.rt_project.R


/**
 * A simple [Fragment] subclass.
 */
class MostViewed : Fragment() {

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_most__viewed_, container, false)

        val text: TextView = view.findViewById(R.id.text)
        val linearLayout: LinearLayout = view.findViewById(R.id.linearLayout)

        linearLayout.setOnTouchListener { v, event ->
            val action = event.action
            when(action){

                MotionEvent.ACTION_DOWN -> {

                }

                MotionEvent.ACTION_MOVE -> {
                    text.visibility = View.VISIBLE
                }

                MotionEvent.ACTION_UP -> {

                }

                MotionEvent.ACTION_CANCEL -> {
                }

                else ->{

                }
            }
            true
        }

        var prefix: String = "text"
        var previous_color: String
        var colors = List(3){"#2196F3"; "#4CAF50"; "#F44336"}
        colors.shuffled()
        previous_color = colors[0]
        var start : Boolean = false
        for (i in 1..9){
            var id_name = prefix + i
            val id_text = resources.getIdentifier(id_name, "id", context?.packageName)
            val textView: TextView = view.findViewById(id_text)

            colors.shuffled()
            if (!start){
                textView.setBackgroundColor(Color.parseColor(previous_color))
                start = true
            }
            else{
                for (j in colors){
                    if (j == previous_color){
                        continue
                    }
                    else{
                        textView.setBackgroundColor(Color.parseColor(j))
                        previous_color = j
                        break
                    }
                }
            }
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }
}
