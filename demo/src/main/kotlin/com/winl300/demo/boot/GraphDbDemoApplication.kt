package com.winl300.demo.boot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

/**
 * This is the main function of the program, run this in order to start the application
 *
 * @Author Korey Sniezek
 * @Date 05April2022
 */

@SpringBootApplication
@Import(SpringConfiguration::class)
class GraphDbDemoApplication

fun main(args: Array<String>) {
	runApplication<GraphDbDemoApplication>(*args)
}
