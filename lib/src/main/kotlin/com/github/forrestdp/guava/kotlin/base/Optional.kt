package com.github.forrestdp.guava.kotlin.base

import com.google.common.base.Optional

/**
 * Represents Guava [Optional] as Kotlin nullable [T].
 */
public fun <T : Any> Optional<T>.asNullable(): T? = orNull()

/**
 * Represents Kotlin nullable [T] as Guava [Optional].
 */
public fun <T> T?.asOptional(): Optional<T> = Optional.fromNullable(this)
