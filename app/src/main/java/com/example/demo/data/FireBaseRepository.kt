package com.example.demo.data

import com.google.firebase.Firebase
import com.google.firebase.database.*
import com.google.gson.Gson
import com.squareup.moshi.Moshi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow


interface Repository {
    fun getData(): Flow<Response>
}

class FirebaseRepository(val gson: Gson, val moshi: Moshi) : Repository {
    private val databaseReference: DatabaseReference = Firebase.database.reference

    override fun getData(): Flow<Response> = callbackFlow {
        val listener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // get the firebase data as json
                // firebase returns data as a hashmap by default so here comes gson
                val fireBaseJson = gson.toJson(dataSnapshot.value)
                // moshi library will handle polymorphic deserialization
                val adapter = moshi.adapter(Response::class.java)
                val data = adapter.fromJson(fireBaseJson)

                if (data != null) {
                    trySend(data)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle error here
            }
        }

        databaseReference.addValueEventListener(listener)

        awaitClose { databaseReference.removeEventListener(listener) }
    }

}