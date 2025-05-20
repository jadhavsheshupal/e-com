package com.example.myapplication.allDummyFolder

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class WorkManagerExample(context:Context,params: WorkerParameters): Worker(context, params) {

    override fun doWork(): Result {
        performWork()
            return Result.success()
    }

    fun performWork(){
        Thread.sleep(1000)
        System.out.print("This is Work manager")
    }
}