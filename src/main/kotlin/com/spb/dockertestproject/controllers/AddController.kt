package com.spb.dockertestproject.controllers

import com.spb.dockertestproject.service.KeyMapperService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*


@Controller
class AddController {

    @Value("\${smlr.prefix}")
    private lateinit var prefix: String

    @Autowired lateinit var service: KeyMapperService

    @PostMapping(path = ["add"],
            consumes = [MediaType.APPLICATION_JSON_VALUE],
            produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseBody
    fun addRest(@RequestBody request: AddRequest) =
            ResponseEntity.ok(AddResponse(request.link, service.add(request.link)))

    @PostMapping(path = ["addhtml"])
    fun addHtml(model: Model, @RequestParam(value = "link", required = true) link: String):String {
        val result = add(link)
        model.addAttribute("link", result.link)
        model.addAttribute("keyed", prefix + result.key)
        return "result"
    }

    data class AddRequest(val link: String)
    data class AddResponse(val link: String, val key: String)

    private fun add(link: String) = AddResponse(link, service.add(link))

}