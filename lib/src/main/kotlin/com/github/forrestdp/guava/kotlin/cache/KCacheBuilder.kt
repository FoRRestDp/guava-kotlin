package com.github.forrestdp.guava.kotlin.cache

import com.github.forrestdp.guava.kotlin.utils.NO_GETTER_MESSAGE
import com.github.forrestdp.guava.kotlin.utils.noGetter
import com.google.common.base.Ticker
import com.google.common.cache.Cache
import com.google.common.cache.CacheBuilder
import com.google.common.cache.CacheLoader
import com.google.common.cache.LoadingCache
import com.google.common.cache.RemovalListener
import com.google.common.cache.Weigher
import java.util.concurrent.TimeUnit

public class KCacheBuilder<K, V>(internal val innerValue: CacheBuilder<Any, Any>) {
    internal fun <K1 : K, V1 : V> build(cacheLoader: CacheLoader<K1, V1>): LoadingCache<K1, V1> =
        innerValue.build(cacheLoader)

    internal fun build(): Cache<K, V> = innerValue.build()
}

public var <K, V> KCacheBuilder<K, V>.initialCapacity: Int
    @Deprecated(NO_GETTER_MESSAGE, level = DeprecationLevel.HIDDEN)
    get() = noGetter
    set(value) {
        innerValue.initialCapacity(value)
    }

public var <K, V> KCacheBuilder<K, V>.concurrencyLevel: Int
    @Deprecated(NO_GETTER_MESSAGE, level = DeprecationLevel.HIDDEN)
    get() = noGetter
    set(value) {
        innerValue.concurrencyLevel(value)
    }

public var <K, V> KCacheBuilder<K, V>.maximumSize: Long
    @Deprecated(NO_GETTER_MESSAGE, level = DeprecationLevel.HIDDEN)
    get() = noGetter
    set(value) {
        innerValue.maximumSize(value)
    }

public var <K, V> KCacheBuilder<K, V>.maximumWeight: Long
    @Deprecated(NO_GETTER_MESSAGE, level = DeprecationLevel.HIDDEN)
    get() = noGetter
    set(value) {
        innerValue.maximumWeight(value)
    }

public fun <K, V, K1 : K, V1 : V> KCacheBuilder<K, V>.weigher(weigher: Weigher<out K1, out V1>) {
    innerValue.weigher(weigher)
}

public fun <K, V> KCacheBuilder<K, V>.weakKeys() {
    innerValue.weakKeys()
}

public fun <K, V> KCacheBuilder<K, V>.weakValues() {
    innerValue.weakValues()
}

public fun <K, V> KCacheBuilder<K, V>.softValues() {
    innerValue.softValues()
}

public var <K, V> KCacheBuilder<K, V>.expirationAfterWrite: kotlin.time.Duration
    @Deprecated(NO_GETTER_MESSAGE, level = DeprecationLevel.HIDDEN)
    get() = noGetter
    set(value) {
        if (value.inWholeNanoseconds % 1000 != 0L) {
            innerValue.expireAfterWrite(value.inWholeNanoseconds, TimeUnit.NANOSECONDS)
        } else {
            innerValue.expireAfterWrite(value.inWholeMilliseconds, TimeUnit.MILLISECONDS)
        }
    }

public fun <K, V> KCacheBuilder<K, V>.expireAfterWrite(duration: java.time.Duration) {
    innerValue.expireAfterWrite(duration)
}

public fun <K, V> KCacheBuilder<K, V>.expireAfterWrite(duration: Long, unit: TimeUnit) {
    innerValue.expireAfterWrite(duration, unit)
}

public var <K, V> KCacheBuilder<K, V>.expirationAfterAccess: kotlin.time.Duration
    @Deprecated(NO_GETTER_MESSAGE, level = DeprecationLevel.HIDDEN)
    get() = noGetter
    set(value) {
        if (value.inWholeNanoseconds % 1000 != 0L) {
            innerValue.expireAfterAccess(value.inWholeNanoseconds, TimeUnit.NANOSECONDS)
        } else {
            innerValue.expireAfterAccess(value.inWholeMilliseconds, TimeUnit.MILLISECONDS)
        }
    }

public fun <K, V> KCacheBuilder<K, V>.expireAfterAccess(duration: java.time.Duration) {
    innerValue.expireAfterAccess(duration)
}

public fun <K, V> KCacheBuilder<K, V>.expireAfterAccess(duration: Long, unit: TimeUnit) {
    innerValue.expireAfterAccess(duration, unit)
}

public var <K, V> KCacheBuilder<K, V>.refreshingAfterWrite: kotlin.time.Duration
    @Deprecated(NO_GETTER_MESSAGE, level = DeprecationLevel.HIDDEN)
    get() = noGetter
    set(value) {
        if (value.inWholeNanoseconds % 1_000_000 != 0L) {
            innerValue.refreshAfterWrite(value.inWholeNanoseconds, TimeUnit.NANOSECONDS)
        } else {
            innerValue.refreshAfterWrite(value.inWholeMilliseconds, TimeUnit.MILLISECONDS)
        }
    }

public fun <K, V> KCacheBuilder<K, V>.refreshAfterWrite(duration: java.time.Duration) {
    innerValue.refreshAfterWrite(duration)
}

public fun <K, V> KCacheBuilder<K, V>.refreshAfterWrite(duration: Long, unit: TimeUnit) {
    innerValue.refreshAfterWrite(duration, unit)
}

public var <K, V> KCacheBuilder<K, V>.ticker: Ticker
    @Deprecated(NO_GETTER_MESSAGE, level = DeprecationLevel.HIDDEN)
    get() = noGetter
    set(value) {
        innerValue.ticker(value)
    }

public fun <K, V, K1 : K, V1 : V> KCacheBuilder<K, V>.removalListener(listener: RemovalListener<out K1, out V1>) {
    innerValue.removalListener(listener)
}

public fun <K, V> KCacheBuilder<K, V>.recordStats() {
    innerValue.recordStats()
}
