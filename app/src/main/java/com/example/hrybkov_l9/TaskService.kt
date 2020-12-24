package com.example.hrybkov_l9

import android.app.Service
import android.content.Intent
import android.os.IBinder

class TaskService : Service() {

    override fun onCreate() {
        super.onCreate()

        val additionResult = (5 + 10)
        val intent = Intent("ADDITION_ACTION")

        intent.putExtra("ADDITION_ACTION", additionResult)
        sendBroadcast(intent)
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Return the communication channel to the service.")
    }
}