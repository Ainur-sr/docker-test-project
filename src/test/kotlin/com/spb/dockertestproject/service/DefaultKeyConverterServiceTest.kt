package com.spb.dockertestproject.service

import org.junit.Test
import java.util.*
import org.junit.Assert.*

class DefaultKeyConverterServiceTest {

    val service: KeyConverterService = DefaultKeyConverterService()

    @Test
    fun givenIdMustBeConvertableBothWays(){
        val rand = Random()
        for (i in 0..1000L){
            val initialId = Math.abs(rand.nextLong())
            val link = service.idToKey(initialId)
            val id = service.keyToId(link)
            assertEquals(initialId, id)
        }
    }
}

