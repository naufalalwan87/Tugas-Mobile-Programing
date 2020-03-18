package com.example.utskotlin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_dashboard.*
import org.json.JSONArray
import org.json.JSONObject

class Dashboard : AppCompatActivity() {
    val context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        insert.setOnClickListener() {
            var name = nama_penduduk.text.toString()
            var ttl = ttl_penduduk.text.toString()
            var hp = hp_penduduk.text.toString()
            var address = alamat_penduduk.text.toString()
            postkeserver(name, ttl, hp, address)

            val intent = Intent(context, Dashboard::class.java)
            startActivity(intent)
        }

        button.setOnClickListener {
            val sharedPreferences = getSharedPreferences("CEKLOGIN", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()

            editor.putString("STATUS", "0")
            editor.apply()

            startActivity(Intent(this@Dashboard, MainActivity::class.java))
            finish()
        }


        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val users = ArrayList<User>()


        AndroidNetworking.get("http://192.168.43.197/utsvokasi/penduduk-json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("id_penduduk"))

                        // txt1.setText(jsonObject.optString("shubuh"))
                        var isi1 = jsonObject.optString("nama_penduduk").toString()
                        var isi2 = jsonObject.optString("ttl_penduduk").toString()
                        var isi3 = jsonObject.optString("hp_penduduk").toString()
                        var isi4 = jsonObject.optString("alamat_penduduk").toString()


                        users.add(User("$isi1", "$isi2", "$isi3", "$isi4"))


                    }

                    val adapter = CustomAdapter(users)
                    recyclerView.adapter = adapter


                }

                override fun onError(anError: ANError) {
                    Log.i("_err", anError.toString())
                }
            })
    }
    fun postkeserver(data: String, data2: String, data3: String, data4: String) {
        AndroidNetworking.post("http://192.168.43.197/utsvokasi/proses_penduduk.php")
            .addBodyParameter("nama_penduduk", data)
            .addBodyParameter("ttl_penduduk", data2)
            .addBodyParameter("hp_penduduk", data3)
            .addBodyParameter("alamat_penduduk", data4)
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