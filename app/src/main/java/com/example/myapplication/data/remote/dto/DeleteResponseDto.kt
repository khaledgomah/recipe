package com.example.myapplication.data.remote.dto


data class DeleteResponseDto (
    val id: Int,
    val isDeleted: Boolean,
    val deletedOn: String? = null
)