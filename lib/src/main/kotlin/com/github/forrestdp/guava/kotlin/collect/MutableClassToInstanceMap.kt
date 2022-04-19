package com.github.forrestdp.guava.kotlin.collect

import com.google.common.collect.MutableClassToInstanceMap
import kotlin.reflect.KClass

public fun <B : Any> emptyMutableClassToInstanceMap(): MutableClassToInstanceMap<B> = MutableClassToInstanceMap.create()

public fun <B : Any> mutableClassToInstanceMapFrom(backingMap: Map<Class<out B>, B>): MutableClassToInstanceMap<B> =
    MutableClassToInstanceMap.create(backingMap)

@JvmName("mutableClassToInstanceMapFromKt")
public fun <B : Any> mutableClassToInstanceMapFrom(backingMap: Map<KClass<out B>, B>): MutableClassToInstanceMap<B> =
    MutableClassToInstanceMap.create(backingMap.mapKeys { (k, _) -> k.java })
