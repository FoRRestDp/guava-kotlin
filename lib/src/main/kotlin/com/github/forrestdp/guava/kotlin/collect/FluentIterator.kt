package com.github.forrestdp.guava.kotlin.collect

import com.google.common.collect.FluentIterable

public fun <T> Iterable<T>.toFluentIterable(): FluentIterable<T> = FluentIterable.from(this)

@Suppress("UnstableApiUsage")
public fun <T> Array<T>.toFluentIterable(): FluentIterable<T> = FluentIterable.from(this)

@Suppress("UnstableApiUsage")
public fun <T> emptyFluentIterable(): FluentIterable<T> = FluentIterable.of()

@Suppress("UnstableApiUsage")
public fun <T> fluentIterableOf(element: T, vararg elements: T): FluentIterable<T> =
    FluentIterable.of(element, *elements)
