package com.example.demo.service

import com.example.demo.mapper.toDto
import com.example.demo.mapper.toModel
import com.example.demo.model.Device
import com.example.demo.repository.DeviceCacheRepository
import com.example.demo.repository.DeviceRepository
import org.springframework.stereotype.Service

@Service
class DeviceService(
    private val deviceRepository: DeviceRepository,
    private val deviceCacheRepository: DeviceCacheRepository,
) {

    fun saveDevice(device: Device): Device =
        deviceRepository.save(device)

    fun getDevice(id: Long): Device =
        deviceCacheRepository.findById(id)?.toModel()
            ?: deviceRepository.findById(id).get().also { device ->
                deviceCacheRepository.save(device.toDto())
            }

    fun getDevices(): List<Device> =
        deviceCacheRepository.findAll().toModel().ifEmpty {
            deviceRepository.findAll().also { devices ->
                deviceCacheRepository.saveAll(devices.toDto())
            }
        }
}
