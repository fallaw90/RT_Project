package com.fallntic.rt_project.Fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.fallntic.rt_project.Model.Card
import com.fallntic.rt_project.R
import kotlinx.android.synthetic.main.fragment_top__rated_.*

/**
 * A simple [Fragment] subclass.
 */
class TopRated : Fragment() {

    var listCard = ArrayList<Card>()
    var score1 = 0
    var score2 = 0

    lateinit var textView1: TextView
    lateinit var textView2: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_top__rated_, container, false)

        textView1 = view.findViewById(R.id.score1)
        textView2 = view.findViewById(R.id.score2)

        // Inflate the layout for this fragment
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        for (i in 2..14) {
            val card = Card()
            card.name = "card" + i
            card.value = i
            listCard.add(card)
        }

        listCard.shuffle()

        text.setOnClickListener {

            val tempCard1: Card
            val tempCard2: Card

            if (listCard.size >= 2) {
                tempCard1 = listCard.removeAt(listCard.size - 1)
                showCard(tempCard1.name, ImageView1)

                tempCard2 = listCard.removeAt(listCard.size - 1)
                showCard(tempCard2.name, ImageView2)

                if(tempCard1.value > tempCard2.value){
                    score1++
                }
                else{
                    score2++
                }

                textView1.text = score1.toString()
                textView2.text = score2.toString()
            }
        }
    }

    fun showCard(card_name: String, imageView: ImageView) {
        val card_id = resources.getIdentifier(card_name, "drawable", context?.packageName)
        Glide.with(this)
            .load(card_id)
            .centerInside()
            .into(imageView)
    }
}
