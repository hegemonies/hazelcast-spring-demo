package com.example.demo.controller

import com.example.demo.dto.DeviceDto
import com.example.demo.repository.DeviceCacheRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class DeviceController(
    private val deviceCacheRepository: DeviceCacheRepository,
) {

    @GetMapping("/devices")
    suspend fun getDevices(): List<DeviceDto> {
        return deviceCacheRepository.findAll()
    }

    @PostMapping("/device")
    suspend fun createDevice(@RequestBody device: DeviceDto) {
        deviceCacheRepository.save(device)
    }
}
