package com.example.myrecyclerview

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imgUniversity: ImageView = findViewById(R.id.img_university)
        val tvName: TextView = findViewById(R.id.tv_name)
        val tvDescription: TextView = findViewById(R.id.tv_description)
        val tvYears: TextView = findViewById(R.id.tv_year)

        val hero: Hero = intent.getParcelableExtra<Hero>("EXTRA_HERO")!!
        imgUniversity.setImageResource(hero.photo)
        tvName.text = hero.name
        tvDescription.text = hero.description
        tvYears.text = hero.year

        supportActionBar?.title = hero.name
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_share -> {
                shareUniversity()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun shareUniversity() {
        val description: TextView = findViewById(R.id.tv_description)
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, description.text.toString())
        startActivity(Intent.createChooser(intent, "Share to"))
    }
}