package com.example.demo.model

import com.example.demo.consts.TableName
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = TableName.DEVICE_TABLE)
data class Device(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long = 0,

    val ip: String,

    val model: String,

    val hostname: String,

    val status: Int,

    val disabled: Boolean = false,
)
