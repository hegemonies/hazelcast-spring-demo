package com.example.demo.configuration

import com.hazelcast.core.Hazelcast
import com.hazelcast.core.HazelcastInstance
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
class HazelcastConfiguration {

    @Bean
    @Primary
    fun hazelcastInstance(): HazelcastInstance =
        Hazelcast.newHazelcastInstance()
}
