package com.danicode.firebase.data.remote

import android.util.Log
import com.danicode.firebase.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseAuthRepositoryImpl @Inject constructor(private val firebaseAuth: FirebaseAuth) :
    AuthRepository {
    override suspend fun login(email: String, password: String): Boolean {
        var isSuccessful = false
        try {
            /* firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener { isSuccessful = true }
                .addOnFailureListener { isSuccessful = false }
                .await()
            isSuccessful*/
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            isSuccessful = result.user != null
        } catch (e: Exception) {
            Log.i("FirebaseAuthRepositoryImpl : ERROR", e.message!!)
        }

        return isSuccessful
    }

    override suspend fun signup(email: String, password: String): Boolean {
        var isSuccessful = false
        try {
            /*firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.i("FirebaseAuthRepositoryImpl 1", isSuccessful.toString())
                    } else {
                        Log.i("FirebaseAuthRepositoryImpl 2", isSuccessful.toString())
                    }
                    isSuccessful = task.isSuccessful
                }.await()*/
            val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            isSuccessful = result.user != null
            Log.i("FirebaseAuthRepositoryImpl 2", isSuccessful.toString())
        } catch (e: Exception) {
            Log.i("FirebaseAuthRepositoryImpl : ERROR", e.message!!)
        }

        return isSuccessful
    }
}