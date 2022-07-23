package com.example.demo.model

import org.springframework.data.annotation.Id
import java.io.Serializable

data class DeviceDto(
    @Id
    val id: Long,
    val ip: String,
    val model: String,
    val hostname: String,
    val status: Int
) : Serializable
