package com.example.demo.di

import com.example.demo.data.FirebaseRepositoryImpl
import com.example.demo.data.Repository
import com.example.demo.util.MoshiBuilder
import com.google.firebase.Firebase
import com.google.firebase.database.*
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {

    @Provides
    fun provideRepository(
        gson: Gson,
        moshi: Moshi
    ): Repository {
        return FirebaseRepositoryImpl(gson, moshi)
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return MoshiBuilder().buildMoshi()
    }

    @Provides
    fun provideDatabaseReference(): DatabaseReference {
        return Firebase.database.reference
    }
}