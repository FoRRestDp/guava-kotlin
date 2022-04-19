package com.github.forrestdp.guava.kotlin.cache

import com.google.common.cache.CacheBuilder
import com.google.common.cache.CacheBuilderSpec
import com.google.common.cache.CacheLoader
import com.google.common.cache.LoadingCache

public fun <K, V, K1 : K, V1 : V> buildLoadingCache(
    cacheLoader: CacheLoader<K1, V1>,
    builderAction: KCacheBuilder<K, V>.() -> Unit,
): LoadingCache<K1, V1> {
    val kBuilder = KCacheBuilder<K, V>(CacheBuilder.newBuilder())
    return kBuilder.apply(builderAction).build(cacheLoader)
}

public fun <K, V, K1 : K, V1 : V> buildLoadingCache(
    spec: String,
    cacheLoader: CacheLoader<K1, V1>,
    builderAction: KCacheBuilder<K, V>.() -> Unit,
): LoadingCache<K1, V1> {
    val kBuilder = KCacheBuilder<K, V>(CacheBuilder.from(spec))
    return kBuilder.apply(builderAction).build(cacheLoader)
}

public fun <K, V, K1 : K, V1 : V> buildLoadingCache(
    spec: CacheBuilderSpec,
    cacheLoader: CacheLoader<K1, V1>,
    builderAction: KCacheBuilder<K, V>.() -> Unit,
): LoadingCache<K1, V1> {
    val kBuilder = KCacheBuilder<K, V>(CacheBuilder.from(spec))
    return kBuilder.apply(builderAction).build(cacheLoader)
}
