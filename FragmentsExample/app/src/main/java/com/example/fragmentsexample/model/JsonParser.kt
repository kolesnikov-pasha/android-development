package com.example.fragmentsexample.model

import java.io.InputStream

interface JsonParser<T> {
    fun parse(json: InputStream): T
}