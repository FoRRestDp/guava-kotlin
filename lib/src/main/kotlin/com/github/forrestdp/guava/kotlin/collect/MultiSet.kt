package com.github.forrestdp.guava.kotlin.collect

import com.google.common.collect.HashMultiset
import com.google.common.collect.Multiset

public fun <T : Any> emptyMultiset(): Multiset<T> = HashMultiset.create()

public fun <T : Any> multisetOf(): Multiset<T> = emptyMultiset()

public fun <T : Any> multisetOf(vararg elements: T): Multiset<T> =
    if (elements.isEmpty()) {
        emptyMultiset()
    } else {
        HashMultiset.create(elements.toList())
    }
