package com.example.naufalminggu1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

/*
        var ip = 80
        if (ip >= 90 && ip < 100) {
            Log.i("Nilai Anda", "A")
            tampil.text="Nilai Anda A"
        } else if (ip >= 80 && ip < 90) {
            Log.i("Nilai Anda", "AB")
            tampil.text="Nilai Anda AB"
        } else if (ip >= 70 && ip < 90) {
            Log.i("Nilai Anda ", "B")
            tampil.text="Nilai Anda B"
        }
           else if (ip >= 60 && ip < 70)
         { Log.i("Nilai Anda ", "BC")
             tampil.text="Nilai Anda BC"
    }
     else if (ip < 50) {
        Log.i("Nilai Anda ", "C")
            tampil.text="Nilai Anda C"
            */

    /*    for (x in 0..10)
        Log.i("Hasil", "$x")
        var i = 1
        while (i <= 5){
            Log.i("Line", "$i")
            ++i
            */

    /*    var num =2
        var i = 1
        do {
            Log.i("Hasil","2 * $i ="+ num * i)
            i++
    }while(i < 10)
*/

        var a = 5
        var b=6
        var c=10
        penjumlahan(a,b,c)
    }
    fun penjumlahan(a:Int, b:Int, c:Int)
    {
        var d :Int
        d=(a*b-10)/c
        Log.i ("Hasil","$d")
    }
    }


