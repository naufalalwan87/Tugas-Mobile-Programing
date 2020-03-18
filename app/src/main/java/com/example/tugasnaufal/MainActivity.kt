package com.example.tugasnaufal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val context = this

        identitas.setOnClickListener {
            val intent = Intent(context,IdentitasMasjid::class.java)
            startActivity(intent)
            finish()
        }

        jadwal.setOnClickListener {
            val intent = Intent(context,jadwalsholat::class.java)
            startActivity(intent)
            finish()
        }

        marquee.setOnClickListener {
            val intent = Intent(context,Marquee::class.java)
            startActivity(intent)
            finish()
        }

        pengumuman.setOnClickListener {
            val intent = Intent(context,pengumuman::class.java)
            startActivity(intent)
            finish()
        }

        slideshow.setOnClickListener {
            val intent = Intent(context,SlideShow::class.java)
            startActivity(intent)
            finish()
        }

        tagline.setOnClickListener {
            val intent = Intent(context,Tagline::class.java)
            startActivity(intent)
            finish()
        }

    }
}
