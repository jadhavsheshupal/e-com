package com.example.myapplication

import android.content.Context
import android.content.ContextParams
import androidx.annotation.WorkerThread
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.util.concurrent.Executor

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