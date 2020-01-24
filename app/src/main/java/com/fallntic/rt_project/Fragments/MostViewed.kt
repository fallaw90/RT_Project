package com.fallntic.rt_project.Fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.fallntic.rt_project.R


/**
 * A simple [Fragment] subclass.
 */
class MostViewed : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_most__viewed_, container, false)

        //val layout: FrameLayout = view.findViewById(R.id.frame_layout)

        /*val params = layout.getLayoutParams() as FrameLayout.LayoutParams
        params.setMargins(0, 100, 0, 0)
        layout.setLayoutParams(params)*/

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }
}
