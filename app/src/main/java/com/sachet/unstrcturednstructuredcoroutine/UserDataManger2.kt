package com.sachet.unstrcturednstructuredcoroutine

import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

class UserDataManger2 {
    lateinit var deffered: Deferred<Int>
    suspend fun getTotalUserCount(): Int{
        var count = 0

        coroutineScope {
            launch(IO) {
                delay(1000)
                count = 50
            }
            deffered = async(IO) {
                delay(3000)
                return@async 70
            }
        }
        val deffered = CoroutineScope(Dispatchers.IO).async {
            delay(3000)
            return@async 70
        }
        return count + deffered.await()
    }

}
/**
 * Structured concurrency guarantees to complete all the
 * work started by coroutines within the child scope
 * before the return of the suspending function
 */