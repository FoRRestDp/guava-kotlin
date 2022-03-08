package com.github.forrestdp.guava.kotlin.collect

import com.google.common.base.Predicate
import com.google.common.collect.ImmutableList

public fun <T : Any> ImmutableList<T>.filter(predicate: Predicate<T>): ImmutableList<T> {
    return filterIterable(predicate).toImmutableList()
}

public fun <T : Any> ImmutableList<T>.dropLast(n: Int): ImmutableList<T> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    return limit((size - n).coerceAtLeast(0)).toImmutableList()
}

public inline fun <T : Any> ImmutableList<T>.dropLastWhile(predicate: (T) -> Boolean): ImmutableList<T> {
    if (!isEmpty()) {
        val iterator = listIterator(size)
        while (iterator.hasPrevious()) {
            if (!predicate(iterator.previous())) {
                return limit(iterator.nextIndex() + 1).toImmutableList()
            }
        }
    }
    return emptyImmutableList()
}

public fun <T : Any> ImmutableList<T>.slice(indices: IntRange): ImmutableList<T> {
    if (indices.isEmpty()) return emptyImmutableList()
    return this.subList(indices.first, indices.last + 1)
}

public fun <T : Any> ImmutableList<T>.slice(): ImmutableList<T> {
    if (size == 0) return emptyImmutableList()
    val list = buildImmutableList(size) {
        for (index in indices) {
            add(get(index))
        }
    }
    return list
}

public fun <T : Any> ImmutableList<T>.takeLast(n: Int): ImmutableList<T> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    if (n == 0) return emptyImmutableList()
    val size = size
    if (n >= size) return toImmutableList()
    if (n == 1) return immutableListOf(last())
    val list = buildImmutableList(n) {
        for (index in size - n until size)
            add(this@takeLast[index])
    }
    return list
}

public inline fun <T : Any> ImmutableList<T>.takeLastWhile(predicate: (T) -> Boolean): ImmutableList<T> {
    if (isEmpty())
        return emptyImmutableList()
    val iterator = listIterator(size)
    while (iterator.hasPrevious()) {
        if (!predicate(iterator.previous())) {
            iterator.next()
            val expectedSize = size - iterator.nextIndex()
            if (expectedSize == 0) return emptyImmutableList()
            return buildImmutableList(expectedSize) {
                while (iterator.hasNext())
                    add(iterator.next())
            }
        }
    }
    return toImmutableList()
}
