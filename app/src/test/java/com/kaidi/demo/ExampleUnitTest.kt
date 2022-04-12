package com.kaidi.demo

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
//        CollectionDemo.main()

        println("1111")
        println("11 :${Demo.clearTimestampH_M_S(1649726465000)}")
        assertEquals(4, 2 + 2)
    }
}
