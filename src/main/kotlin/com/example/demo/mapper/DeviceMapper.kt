package com.example.demo.mapper

import com.example.demo.dto.DeviceDto
import com.example.demo.model.Device

fun DeviceDto.toModel() =
    Device(
        id = this.id,
        ip = this.ip,
        model = this.model,
        hostname = this.hostname,
        status = this.status,
        disabled = this.disabled,
    )

fun Collection<DeviceDto>.toModel() =
    this.map { it.toModel() }

fun Device.toDto() =
    DeviceDto(
        id = this.id,
        ip = this.ip,
        model = this.model,
        hostname = this.hostname,
        status = this.status,
        disabled = this.disabled,
    )

fun Collection<Device>.toDto() =
    this.map { it.toDto() }
