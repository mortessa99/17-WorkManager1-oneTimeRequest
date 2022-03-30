package com.example.a17_workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //One Time Work Request
        buttonBackUp.setOnClickListener {
            setOneTimeWorkRequest()
        }
    }

    private fun setOneTimeWorkRequest(){
        val constraint = Constraints.Builder()
            //.setRequiresCharging(true)
            //.setRequiresDeviceIdle(true)
            //.setRequiresStorageNotLow(true)
            //.setRequiresBatteryNotLow(true)
            .setRequiredNetworkType(NetworkType.CONNECTED) //METERED is for mobile internet only //UNMETERED is for Wifi only
            .build()
        val oneTimeWorkRequest = OneTimeWorkRequest.Builder(DbBackupScheduler::class.java).setConstraints(constraint).build()
        //WorkManager.getInstance(applicationContext).enqueue(oneTimeWorkRequest)

        //for report ontime above code write down
        val workManager = WorkManager.getInstance(applicationContext)
        workManager.enqueue(oneTimeWorkRequest)
        workManager.getWorkInfoByIdLiveData(oneTimeWorkRequest.id).observe(this){
            textViewReport.text = textViewReport.text.toString() + it.state.name + "\n"
        }
        //
    }
}