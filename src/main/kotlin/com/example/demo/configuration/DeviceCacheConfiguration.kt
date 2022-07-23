package com.example.demo.configuration

import com.example.demo.dto.DeviceDto
import com.hazelcast.core.HazelcastInstance
import com.hazelcast.map.IMap
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DeviceCacheConfiguration {

    @Bean
    fun deviceCache(hazelcastInstance: HazelcastInstance): IMap<Long, DeviceDto> =
        hazelcastInstance.getMap("devices")
}
