package com.example.facts.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Table of Fact
 */
@Entity(tableName = "Fact")
data class Fact(
        val userId: Int,
        @field:PrimaryKey
        val id: Int,
        val title: String,
        val body: String
)