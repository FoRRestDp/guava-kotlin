package com.github.forrestdp.guava.kotlin.collect

import com.google.common.collect.HashMultiset
import com.google.common.collect.ImmutableMultiset
import com.google.common.collect.Multiset

public fun <E : Any> mutableMultisetOf(): Multiset<E> = HashMultiset.create()

public fun <E : Any> mutableMultisetOf(vararg elements: E): Multiset<E> = HashMultiset.create(elements.toList())

@Suppress("FunctionName")
public fun <E : Any> MutableMultiset(distinctElements: Int): Multiset<E> = HashMultiset.create(distinctElements)

public fun <E : Any> ImmutableMultiset<E>.toMutableMultiset(): Multiset<E> = HashMultiset.create(this)
