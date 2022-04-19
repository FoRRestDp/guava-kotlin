package com.github.forrestdp.guava.kotlin.collect

import com.google.common.collect.ClassToInstanceMap
import kotlin.reflect.KClass

public fun <B : Any, T : B> ClassToInstanceMap<B>.getInstance(key: KClass<T>): T? = getInstance(key.java)

public inline fun <reified B : Any, reified T : B> ClassToInstanceMap<B>.getInstance(): T? = getInstance(T::class)

public operator fun <B : Any, T : B> ClassToInstanceMap<B>.get(key: KClass<T>): B? = get(key.java)

public fun <B : Any, T : B> ClassToInstanceMap<B>.putInstance(key: KClass<T>, value: T): T = putInstance(key.java, value)

public inline fun <reified B : Any, reified T: B> ClassToInstanceMap<B>.putInstance(value: T): T = putInstance(T::class, value)

public fun <B : Any, T : B> ClassToInstanceMap<B>.set(key: Class<T>, value: T): T = putInstance(key, value)

public fun <B : Any, T : B> ClassToInstanceMap<B>.set(key: KClass<T>, value: T): T = putInstance(key, value)
