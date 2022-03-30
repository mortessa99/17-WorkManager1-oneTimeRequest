package com.example.a17_workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class DbBackupScheduler(context: Context , workerParameters: WorkerParameters) : Worker(context,workerParameters) {
    override fun doWork(): Result {
        //backup DB
//        try {
//            for (i in 1..10000){ Log.i("mylog","Backing up data # $i")}
//            return Result.success()
//        } catch (e:Exception){
//            return Result.failure()
//        }


            //or up.down is professional!
        return try {
            for (i in 1..10000){ Log.i("mylog","Backing up data # $i")}
             Result.success()
        } catch (e:Exception){
             Result.failure()
        }

    }
}