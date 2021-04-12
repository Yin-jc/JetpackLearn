package com.yjc.kotlin

import kotlinx.coroutines.*

/**
 * author: yinjiacheng
 * date: 4/6/21 8:53 PM
 * description:
 */
fun main() {

    /**
     * 显式等待job执行结束
     */
    /*runBlocking {
        val job = GlobalScope.launch {
            delay(1000)
            println("World!")
        }
        println("Hello")
        job.join() // 等待直到子协程执行结束
    }*/

    /**
     * 结构化并发 指定作用域
     * 外部协程（runBlocking）直到在其作用域中启动的所有协程都执行完毕后才会结束
     */
    /*runBlocking {
        launch {
            delay(1000)
            println("World!")
        }
        println("Hello")
    }*/

    /**
     * 作用域构建器 等待其协程体以及所有子协程结束
     */
    /*runBlocking {
        launch {
            delay(200)
            println("Task from runBlocking")
        }

        coroutineScope {
            launch {
                delay(500)
                println("Task from nested launch")
            }
            delay(100)
            println("Task from coroutine scope")
        }

        println("Coroutine scope is over")
    }*/

    /**
     * 提取suspend函数
     */
    /*runBlocking {
        launch {
            doWorld()
        }
        println("Hello")
    }*/

    /**
     * 协程很轻量
     */
    /*runBlocking {
        repeat(100 * 1000) {
            launch {
                delay(5000)
                print(".")
            }
        }
    }*/

    /**
     * 全局协程不会保活进程
     */
    /*runBlocking {
        GlobalScope.launch {
            repeat(1000) {
                println("I'm sleeping $it ...")
                delay(500)
            }
        }
        delay(1300)
    }*/
}

suspend fun doWorld() {
    delay(1000)
    println("World!")
}