package com.recepgemalmaz.workmanagerkullanimi

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker (appContext : Context, workerParams : WorkerParameters):Worker(appContext,workerParams) {
       override fun doWork(): Result {
           val toplam = 10+20
           Log.e("TAG", toplam.toString())
           return Result.success()
       }
}