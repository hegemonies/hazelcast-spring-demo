package com.example.demo.repository

import com.hazelcast.core.HazelcastInstance
import org.springframework.stereotype.Repository

@Repository
class DeviceCacheRepository(
    private val hazelcastInstance: HazelcastInstance,
){

}
