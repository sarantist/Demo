package com.example.demo.data

import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getData(): Flow<Response>
}