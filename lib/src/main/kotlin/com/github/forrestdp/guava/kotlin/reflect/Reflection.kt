package com.github.forrestdp.guava.kotlin.reflect

import com.google.common.annotations.Beta
import com.google.common.reflect.Reflection
import java.lang.reflect.InvocationHandler

@Suppress("UnstableApiUsage")
@Beta
public fun <T> Class<T>.getPackageName(): String = Reflection.getPackageName(this)

@Suppress("UnstableApiUsage")
@Beta
public fun <T> Class<T>.newProxy(handler: InvocationHandler): T = Reflection.newProxy(this, handler)
