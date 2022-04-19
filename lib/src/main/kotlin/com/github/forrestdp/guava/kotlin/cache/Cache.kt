package com.github.forrestdp.guava.kotlin.cache

import com.google.common.cache.Cache
import com.google.common.cache.CacheBuilder
import com.google.common.cache.CacheBuilderSpec

public fun <K, V> buildCache(builderAction: KCacheBuilder<K, V>.() -> Unit): Cache<K, V> {
    val kBuilder = KCacheBuilder<K, V>(CacheBuilder.newBuilder())
    return kBuilder.apply(builderAction).build()
}

public fun <K, V> buildCache(spec: String, builderAction: KCacheBuilder<K, V>.() -> Unit): Cache<K, V> {
    val kBuilder = KCacheBuilder<K, V>(CacheBuilder.from(spec))
    return kBuilder.apply(builderAction).build()
}

public fun <K, V> buildCache(spec: CacheBuilderSpec, builderAction: KCacheBuilder<K, V>.() -> Unit): Cache<K, V> {
    val kBuilder = KCacheBuilder<K, V>(CacheBuilder.from(spec))
    return kBuilder.apply(builderAction).build()
}

public operator fun <K, V> Cache<K, V>.set(key: K, value: V) {
    put(key, value)
}
