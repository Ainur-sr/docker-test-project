package com.spb.dockertestproject

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class DockerTestProjectApplication


fun main(args: Array<String>) {
	runApplication<DockerTestProjectApplication>(*args)
}
