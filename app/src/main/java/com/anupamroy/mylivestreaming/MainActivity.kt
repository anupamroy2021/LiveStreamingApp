package com.anupamroy.mylivestreaming

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Random

class MainActivity : AppCompatActivity() {

    lateinit var startLiveBtn : ImageButton
    lateinit var joinLiveBtn : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startLiveBtn = findViewById(R.id.startLiveBtn)
        joinLiveBtn = findViewById(R.id.joinLiveBtn)

        val appID: Long = 27761975
        val appSign = "757e25c2ee735d474f33527500d8a82b3dd4668df476a1f70e8abfbd678055b5"

        val userID: String = generateUserID()
        val userName = userID + "_Name"
        val liveID = "test_live_id"

        startLiveBtn.setOnClickListener { v: View? ->
            val intent = Intent(this@MainActivity, LiveActivity::class.java)
            intent.putExtra("host",true)
            intent.putExtra("appID", appID)
            intent.putExtra("appSign", appSign)
            intent.putExtra("userID", userID)
            intent.putExtra("userName",userName)
            intent.putExtra("liveID",liveID)
            startActivity(intent)
        }
        joinLiveBtn.setOnClickListener { v: View? ->
            val intent = Intent(this@MainActivity, LiveActivity::class.java)
            intent.putExtra("appID", appID)
            intent.putExtra("appSign", appSign)
            intent.putExtra("userID", userID)
            intent.putExtra("userName",userName)
            intent.putExtra("liveID",liveID)
            startActivity(intent)
        }
    }

    private fun generateUserID(): String{
        val builder = StringBuilder()
        val random = Random()
        while(builder.length<5)
        {
            val nextInt =  random.nextInt(10);
            if(builder.length == 0 && nextInt == 0)
            {
                continue
            }
            builder.append(nextInt)
        }
        return builder.toString()
    }
}