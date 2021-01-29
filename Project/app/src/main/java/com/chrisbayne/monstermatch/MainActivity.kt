package com.chrisbayne.monstermatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chrisbayne.monstermatch.databinding.ActivityMainBinding // this was added because when we added viewbinding, it creates a class for every layout.

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding // this line automatically created/imported the com.chrisbayne.monstermatch.... line above // declared a class level variable

    private val monsters: List<Monster> = listOf (
        Monster(R.drawable.monster1_head, R.drawable.monster1_body, R.drawable.monster1_feet),
        Monster(R.drawable.monster2_head, R.drawable.monster2_body, R.drawable.monster2_feet),
        Monster(R.drawable.monster3_head, R.drawable.monster3_body, R.drawable.monster3_feet)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // this inflates the layout to say that it is accessible // it can be drawn/rendered on the screen
        setContentView(binding.root) // the binding root is based off of the ActivityMainBinding xml
        //setContentView(R.layout.activity_main)
        shuffleMonsters()
        // On click listener attached to the button
        binding.shuffleButton.setOnClickListener {
            shuffleMonsters()
        }
    }

    private fun shuffleMonsters() {
        binding.monsterHeadImageView.setImageResource(monsters.random().head)
        binding.monsterBodyImageView.setImageResource(monsters.random().body)
        binding.monsterFeetImageView.setImageResource(monsters.random().feet)
    }

    
}

data class Monster (val head: Int, val body: Int, val feet: Int)
