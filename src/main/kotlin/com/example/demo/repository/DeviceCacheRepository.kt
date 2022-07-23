package com.example.demo.repository

import com.example.demo.dto.DeviceDto
import com.hazelcast.map.IMap
import org.springframework.stereotype.Repository

@Repository
class DeviceCacheRepository(
    private val deviceCache: IMap<Long, DeviceDto>,
) {

    fun findById(id: Long): DeviceDto? = deviceCache[id]

    fun findAll() = deviceCache.values.toList().sortedBy { it.id }

    fun save(device: DeviceDto) {
        deviceCache.setAsync(device.id, device)
    }

    fun saveAll(devices: List<DeviceDto>) {
        deviceCache.setAllAsync(devices.associateBy { device -> device.id })
    }
}
