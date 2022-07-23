package com.example.demo.repository

import com.example.demo.model.DeviceDto
import org.springframework.data.hazelcast.repository.HazelcastRepository
import org.springframework.data.hazelcast.repository.query.Query

interface DeviceCacheRepository : HazelcastRepository<DeviceDto, Long> {

    fun findAllByDisabled(disabled: Boolean): List<DeviceDto>

    fun findByIp(ip: String): DeviceDto

    @Query(
        """
            UPDATE DeviceDto d 
                SET d.ip = :ip
                WHERE d.id = :id
        """
    )
    fun updateIp(id: Long, ip: String): Long
}
