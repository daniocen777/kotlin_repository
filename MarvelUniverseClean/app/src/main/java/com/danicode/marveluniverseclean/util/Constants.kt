package com.danicode.marveluniverseclean.util

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class Constants {

    companion object {
        const val BASE_URL = "https://gateway.marvel.com"
        const val API_KEY = ""
        private const val PRIVATE_KEY = ""
        const val LIMIT = "20"
        val timeStamp = Timestamp(System.currentTimeMillis()).time.toString()
        fun hash(): String {
            val input = "$timeStamp$PRIVATE_KEY$API_KEY"
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(input.toByteArray()))
                .toString(16)
                .padStart(32, '0')
        }
    }
}