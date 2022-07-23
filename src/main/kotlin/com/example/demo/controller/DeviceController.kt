package com.example.demo.controller

import com.example.demo.model.Device
import com.example.demo.service.DeviceService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class DeviceController(
    private val deviceService: DeviceService,
) {

    @GetMapping("/devices")
    suspend fun getDevices(): List<Device> =
        deviceService.getDevices()

    @PostMapping("/device")
    suspend fun createDevice(@RequestBody device: Device): Device =
        deviceService.saveDevice(device)

    @GetMapping("/device/{id}")
    suspend fun getDevice(@PathVariable(value = "id") id: Long): Device =
        deviceService.getDevice(id)
}
