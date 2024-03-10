package com.example.demo.di

import com.example.demo.data.FirebaseRepositoryImpl
import com.example.demo.data.Repository
import com.google.firebase.database.DatabaseReference
import com.google.gson.Gson
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideRepository(
        gson: Gson,
        moshi: Moshi,
        databaseReference: DatabaseReference
    ): Repository {
        return FirebaseRepositoryImpl(gson, moshi, databaseReference)
    }
}
