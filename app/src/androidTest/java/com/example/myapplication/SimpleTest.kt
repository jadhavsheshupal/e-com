package com.example.myapplication

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.myapplication.allDummyFolder.EmailService
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class SimpleTest {

    @Test
    fun buttonClick(){
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.myapplication", appContext.packageName)
    }

    @Test
    fun addition(){
        val a = 10
        val b = 20
        val r = 30

        assertEquals(r,a+b)
    }

    @Test
    fun testNotificationServiccesModul(){
        val context = EmailService::class.java
    }
}