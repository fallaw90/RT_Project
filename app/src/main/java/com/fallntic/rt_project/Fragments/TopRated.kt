package com.fallntic.rt_project.Fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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
    var card = Card()
    var card2 = Card()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top__rated_, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        for (i in 2..14) {
            card.name = "card" + i
            card.value = i
            listCard.add(card)
        }

        listCard.shuffle()

        text.setOnClickListener {

            card = listCard.removeAt(listCard.size - 1)
            showCard(card.name, ImageView1)

            card2 = listCard.removeAt(listCard.size - 2)
            showCard(card2.name, ImageView2)


        }
    }

    fun showCard(card_name: String, imageView: ImageView) {
        val card_id = resources.getIdentifier(card_name, "drawable", context?.packageName)
        Glide.with(this)
            .load(card_id)
            .placeholder(R.drawable.back)
            .centerCrop()
            .into(imageView)
    }

}
