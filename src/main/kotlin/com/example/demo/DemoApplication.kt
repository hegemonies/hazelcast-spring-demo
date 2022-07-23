package com.example.demo

import com.example.demo.dto.DeviceDto
import com.example.demo.repository.DeviceCacheRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}

@Component
class Foo(
	private val deviceCacheRepository: DeviceCacheRepository,
) : CommandLineRunner {

	override fun run(vararg args: String?) {
		saveDevices()
		println(deviceCacheRepository.findAll())
	}

	fun saveDevices() {
		val devices = listOf(
			DeviceDto(1, "1.1.1.1", "ESR", "esr-home", 1, false),
			DeviceDto(2, "2.2.2.2", "CISCO", "cisco1", 0, false),
			DeviceDto(3, "3.3.3.3", "MES", "mes52", 1, true),
		)

		deviceCacheRepository.saveAll(devices)
	}
}
