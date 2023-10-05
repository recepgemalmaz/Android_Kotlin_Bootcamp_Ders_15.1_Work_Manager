package com.recepgemalmaz.workmanagerkullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.recepgemalmaz.workmanagerkullanimi.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonYap.setOnClickListener {
            /*val calismaKusulu =Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
            val istek = OneTimeWorkRequestBuilder<MyWorker>().setInitialDelay(10,TimeUnit.SECONDS).setConstraints(calismaKusulu).build()

            WorkManager.getInstance(this).enqueue(istek)

            WorkManager.getInstance(this).getWorkInfoByIdLiveData(istek.id).observe(this) {
                val durum = it.state.name
                Log.e("TAG", durum)
            }*/

            //minimum 15 dakikada bir çalışır
            val istek = PeriodicWorkRequestBuilder<MyWorkerBildirim>(15,TimeUnit.MINUTES).setInitialDelay(10,TimeUnit.SECONDS).build()
            WorkManager.getInstance(this).enqueue(istek)

        }
    }
}