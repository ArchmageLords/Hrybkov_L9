package com.example.hrybkov_l9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        var valueIntent = 0

        val broadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                intent?.also {
                    valueIntent = intent.getIntExtra("ADDITION_ACTION", 0)
                }
            }
        }

        registerReceiver(broadcastReceiver, IntentFilter("ADDITION_ACTION"))

        startService(Intent(this, TaskService::class.java))

        val textView = findViewById<TextView>(R.id.mainTextView)
        textView.setOnClickListener {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, TaskFragment.fragmentInstance(valueIntent))
                    .commit()
            unregisterReceiver(broadcastReceiver)
        }
    }

    override fun onStart() {
        super.onStart()
        startService(Intent(this, TaskService::class.java))
    }

    override fun onStop() {
        super.onStop()
        stopService(Intent(this, TaskService::class.java))
    }
}
