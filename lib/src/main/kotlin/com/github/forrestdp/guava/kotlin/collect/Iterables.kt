package com.github.forrestdp.guava.kotlin.collect

import com.google.common.base.Function
import com.google.common.base.Predicate
import com.google.common.collect.Iterables
import kotlin.reflect.KClass


public fun <T> Iterable<T>.elementsEqual(other: Iterable<T>): Boolean {
    return Iterables.elementsEqual(this, other)
}

public fun <T> Iterable<T>.getOnlyElement(): T {
    return Iterables.getOnlyElement(this)
}

public fun <T> Iterable<T>.getOnlyElement(defaultValue: T?): T? {
    return Iterables.getOnlyElement(this, defaultValue)
}

public fun <T : Any> Iterable<T>.toArray(type: KClass<T>): Array<T> {
    return Iterables.toArray(this, type.java)
}

public inline fun <reified T : Any> Iterable<T>.toArray(): Array<T> {
    return toArray(T::class)
}

public fun <T> Iterable<T>.frequency(element: Any?): Int {
    return Iterables.frequency(this, element)
}

public fun <T> Iterable<T>.cycle(): Iterable<T> {
    return Iterables.cycle(this)
}

public fun <T> cycleIterableOf(vararg elements: T): Iterable<T> {
    return Iterables.cycle(*elements)
}

public fun <T> Iterable<T>.concat(other: Iterable<T>): Iterable<T> {
    return Iterables.concat(this, other)
}

public fun <T> Iterable<T>.concat(other1: Iterable<T>, other2: Iterable<T>): Iterable<T> {
    return Iterables.concat(this, other1, other2)
}

public fun <T> Iterable<T>.concat(other1: Iterable<T>, other2: Iterable<T>, other3: Iterable<T>): Iterable<T> {
    return Iterables.concat(this, other1, other2, other3)
}

public fun <T> Iterable<T>.concat(vararg others: Iterable<T>): Iterable<T> {
    return Iterables.concat(this, *others)
}

public fun <T> Iterable<Iterable<T>>.concat(): Iterable<T> {
    return Iterables.concat(this)
}

public fun <T> Iterable<T>.partition(size: Int): Iterable<List<T>> {
    return Iterables.partition(this, size)
}

public fun <T> Iterable<T>.paddedPartition(size: Int): Iterable<List<T?>> {
    return Iterables.paddedPartition(this, size)
}

public fun <T> Iterable<T>.filterIterable(retainIfTrue: Predicate<T>): Iterable<T> {
    return Iterables.filter(this, retainIfTrue)
}

public fun <T : Any> Iterable<*>.filterIterable(desiredType: KClass<T>): Iterable<T> {
    return Iterables.filter(this, desiredType.java)
}

public inline fun <reified T : Any> Iterable<*>.filterIterable(): Iterable<T> {
    return this.filterIterable(T::class)
}

public fun <F, T> Iterable<F>.transform(function: Function<F, T>): Iterable<T> {
    return Iterables.transform(this, function)
}

public operator fun <T> Iterable<T>.get(position: Int): T {
    return Iterables.get(this, position)
}

public operator fun <T> Iterable<T>.get(position: Int, defaultValue: T?): T? {
    return Iterables.get(this, position, defaultValue)
}

public fun <T> Iterable<T>.getFirst(defaultValue: T?): T? {
    return Iterables.getFirst(this, defaultValue)
}

public fun <T> Iterable<T>.getLast(): T {
    return Iterables.getLast(this)
}

public fun <T> Iterable<T>.getLast(defaultValue: T?): T? {
    return Iterables.getLast(this, defaultValue)
}

public fun <T> Iterable<T>.skip(numberToSkip: Int): Iterable<T> {
    return Iterables.skip(this, numberToSkip)
}

public fun <T> Iterable<T>.limit(limitSize: Int): Iterable<T> {
    return Iterables.limit(this, limitSize)
}

public fun <T> Iterable<T>.isEmpty(): Boolean {
    return Iterables.isEmpty(this)
}

public fun <T> Iterable<T>.inNotEmpty(): Boolean {
    return !isEmpty()
}

@Suppress("UnstableApiUsage")
public fun <T> Iterable<Iterable<T>>.mergeSorted(comparator: Comparator<T>): Iterable<T>? {
    return Iterables.mergeSorted(this, comparator)
}

// MutableIterable

public fun <T> MutableIterable<T>.unmodifiableIterable(): Iterable<T> {
    return Iterables.unmodifiableIterable(this)
}

public fun <T> MutableIterable<T>.removeAll(elementsToRemove: Collection<*>): Boolean {
    return Iterables.removeAll(this, elementsToRemove)
}

public fun <T> MutableIterable<T>.retainAll(elementsToRetain: Collection<*>): Boolean {
    return Iterables.retainAll(this, elementsToRetain)
}

public fun <T> MutableIterable<T>.removeIf(predicate: Predicate<T>): Boolean {
    return Iterables.removeIf(this, predicate)
}

public fun <T> MutableCollection<T>.addAll(elementsToAdd: Iterable<T>): Boolean {
    return Iterables.addAll(this, elementsToAdd)
}

public fun <T> MutableIterable<T>.consumingIterable(): Iterable<T> {
    return Iterables.consumingIterable(this)
}
