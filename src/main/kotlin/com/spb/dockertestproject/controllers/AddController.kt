package com.spb.dockertestproject.controllers

import com.spb.dockertestproject.service.KeyMapperService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*


@Controller
@RequestMapping("add")
class AddController {

    @Autowired lateinit var service: KeyMapperService

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseBody
    fun add(@RequestBody request: AddRequest) =
            ResponseEntity.ok(AddResponse(request.link, service.add(request.link)))

    data class AddRequest(val link: String)
    data class AddResponse(val link: String, val key: String)

}