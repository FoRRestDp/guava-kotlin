package com.github.forrestdp.guava.kotlin.reflect

import com.google.common.annotations.Beta
import com.google.common.reflect.TypeParameter
import com.google.common.reflect.TypeToken

@Suppress("UnstableApiUsage")
@Beta
public fun <T> typeTokenOf(clazz: Class<T>): TypeToken<T> = TypeToken.of(clazz)

@Suppress("UnstableApiUsage")
@Beta
public inline fun <reified T> typeToken(): TypeToken<T> = object : TypeToken<T>() {}

@Suppress("UnstableApiUsage")
@Beta
public inline fun <reified T> typeParameter(): TypeParameter<T> = object : TypeParameter<T>() {}
