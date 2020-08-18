package com.spb.dockertestproject.repositories

import com.spb.dockertestproject.model.Link
import org.springframework.data.repository.CrudRepository
import java.util.*

interface LinkRepository : CrudRepository<Link, Long> {
    fun save(link: Link): Link
}