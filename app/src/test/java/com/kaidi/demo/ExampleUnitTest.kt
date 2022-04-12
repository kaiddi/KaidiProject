package com.kaidi.demo

import org.junit.Test

import org.junit.Assert.*
import java.util.HashMap

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
//        ReflectionDemo.accessPrivate()
        ReflectionDemo.getClassRelatedInfo();

        assertEquals(4, 2 + 2)
    }
}
