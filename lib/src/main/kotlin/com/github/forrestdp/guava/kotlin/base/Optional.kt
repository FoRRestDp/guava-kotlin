package com.github.forrestdp.guava.kotlin.base

import com.google.common.base.Optional

public fun <T : Any> Optional<T>.asNullable(): T? = orNull()

public fun <T> T?.asOptional(): Optional<T> = Optional.fromNullable(this)
