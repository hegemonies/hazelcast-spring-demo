package com.example.demo.repository

import com.example.demo.model.DeviceDto
import org.springframework.data.hazelcast.repository.HazelcastRepository

interface DeviceCacheRepository : HazelcastRepository<DeviceDto, Long>
