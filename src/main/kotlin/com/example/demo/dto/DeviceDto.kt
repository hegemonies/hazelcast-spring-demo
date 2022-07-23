package com.example.demo.dto

import java.io.Serializable

data class DeviceDto(
    val id: Long,
    val ip: String,
    val model: String,
    val hostname: String,
    val status: Int,
    val disabled: Boolean = false,
) : Serializable
