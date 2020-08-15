package com.spb.dockertestproject.service

import org.junit.Test
import org.junit.Assert.*

class DefaultKeyMapperServiceTest {

    private val KEY: String = "aAbBcCdD"
    private val LINK = "http://www.eveonline.com"
    private val LINK_NEW: String = "https://yandex.ru"

    val service: KeyMapperService = DefaultKeyMapperService()

    @Test
    fun clientCanAddNewKeyWithLink() {
        assertEquals(KeyMapperService.Add.Success(KEY, LINK), service.add(KEY, LINK))
        assertEquals(KeyMapperService.Get.Link(LINK), service.getLink(KEY))
    }

    @Test
    fun clientCanNotAddExistingKey(){
        service.add(KEY, LINK)
        assertEquals(KeyMapperService.Add.AlreadyExist(KEY), service.add(KEY, LINK_NEW))
        assertEquals(KeyMapperService.Get.Link(LINK), service.getLink(KEY))
    }

    @Test
    fun clientCanNotTakeLinkIfKeyIsNotFoundInService() {
        assertEquals(KeyMapperService.Get.NotFound(KEY), service.getLink(KEY))
    }

}
