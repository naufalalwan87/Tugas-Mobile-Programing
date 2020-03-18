package com.example.tugasnaufal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_identitas_masjid.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.jadwalsholat.txt1
import kotlinx.android.synthetic.main.jadwalsholat.txt2
import kotlinx.android.synthetic.main.activity_marquee.*
import kotlinx.android.synthetic.main.activity_pengumuman.*
import org.json.JSONArray
import org.json.JSONObject

class pengumuman : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengumuman)

        getdariserver()

        val context = this

        btnBack_home4.setOnClickListener {
            var intent = Intent(context,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnUpdate_pengumuman.setOnClickListener {

            var data_judulpengumuman :String = edit_judulpengumuman.text.toString()
            var data_isipengumuman :String = edit_isipengumuman.text.toString()

            postkeserver(data_judulpengumuman,data_isipengumuman)

            var intent = Intent(context,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun getdariserver(){

        AndroidNetworking.get("https://jamsholat.000webhostapp.com/contoh_pengumuman_json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)

                        txt1.setText(jsonObject.optString("judul_pengumuman"))
                        txt2.setText(jsonObject.optString("isi_pengumuman"))

                    }
                }

                override fun onError(anError: ANError?) {
                    Log.i("_err", anError.toString())
                }
            })

    }

    fun postkeserver(data1:String,data2:String)
    {
        AndroidNetworking.post("https://jamsholat.000webhostapp.com/proses_pengumuman.php")
            .addBodyParameter("judul_pengumuman", data1)
            .addBodyParameter("isi_pengumuman", data2)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray?) {
                }

                override fun onError(anError: ANError?) {
                }
            })
    }
}
