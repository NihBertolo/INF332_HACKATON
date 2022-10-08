package com.equipe8.medsolution

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class MedsolutionApplication

fun main(args: Array<String>) {
	runApplication<MedsolutionApplication>(*args)
}
