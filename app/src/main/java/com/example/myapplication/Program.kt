package com.example.myapplication

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

data class Person(var name:String,var emailid:String) {
    fun display() {
        println("This is Display Method ")
    }
}

fun alsoScopeFunction(value:String){

    val res = value.also { println(it.length) }
    println(res)
}

fun letScop_Function(){
    var name: String? = null
    name= "Name"
    alsoScopeFunction(name)

    val str= name.let {
        "Hel"
    }
//    println(name)
    println(str)
}

class ScopFunctions{
    var name :String? = null

}

class ProblemStatment{

    fun thridlargestElement(){
        var list = listOf(2, 6, 8, 4, 5, 6, 9)
        val thridlargestElement = list.sortedDescending().distinct()[3]
        println("The thrid largestElement is${thridlargestElement} ${list}")
        list.forEach {
            print(it.dec())
        }
        println("Sorted list is ${list}")
    }
}

fun main(){


    val letScop = ScopFunctions()
    letScop.name= "Shishupal"
    letScop.name?.let {
        print("The name is ${it}")
    }
//    println("Scope function: ${response.let { it }}")
//    letScop_Function()

    val person = Person("Jon", "jon@gmail.com")
//    println(person.display())
    var result = person.apply {
        this.name
        this.emailid += "jadhavsheshupal@gmail.com"
    }
//    println(result.toString())


//    show()
//    async {
//        delay(1000)
////        println("From async")
//    }
//    println("Done")

}
suspend fun show() {
    coroutineScope{
        launch{
            delay(2000)
            println("Inside show function")
        }
    }
}