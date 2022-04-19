package com.github.forrestdp.guava.kotlin.collect

import com.google.common.collect.ImmutableMultiset
import kotlin.experimental.ExperimentalTypeInference

public fun <E : Any> emptyImmutableMultiset(): ImmutableMultiset<E> = ImmutableMultiset.of()

public fun <E : Any> immutableMultisetOf(element: E): ImmutableMultiset<E> = ImmutableMultiset.of(element)

public fun <E : Any> immutableMultisetOf(e1: E, e2: E): ImmutableMultiset<E> = ImmutableMultiset.of(e1, e2)

public fun <E : Any> immutableMultisetOf(e1: E, e2: E, e3: E): ImmutableMultiset<E> = ImmutableMultiset.of(e1, e2, e3)

public fun <E : Any> immutableMultisetOf(e1: E, e2: E, e3: E, e4: E): ImmutableMultiset<E> =
    ImmutableMultiset.of(e1, e2, e3, e4)

public fun <E : Any> immutableMultisetOf(e1: E, e2: E, e3: E, e4: E, e5: E): ImmutableMultiset<E> =
    ImmutableMultiset.of(e1, e2, e3, e4, e5)

public fun <E : Any> immutableMultisetOf(e1: E, e2: E, e3: E, e4: E, e5: E, e6: E, vararg others: E): ImmutableMultiset<E> =
    ImmutableMultiset.of(e1, e2, e3, e4, e5, e6, *others)

@OptIn(ExperimentalTypeInference::class)
public inline fun <E : Any> buildImmutableMultiset(
    @BuilderInference builderAction: ImmutableMultiset.Builder<E>.() -> Unit,
): ImmutableMultiset<E> = ImmutableMultiset.Builder<E>().apply(builderAction).build()

public fun <T : Any> Iterable<T>.toImmutableMultiset(): ImmutableMultiset<T> = ImmutableMultiset.copyOf(this)

public fun <T : Any> Array<out T>.toImmutableMultiset(): ImmutableMultiset<T> = ImmutableMultiset.copyOf(this)

public fun <T : Any> Sequence<T>.toImmutableMultiset(): ImmutableMultiset<T> = buildImmutableMultiset {
    for (item in this@toImmutableMultiset) {
        add(item)
    }
}

public fun ByteArray.toImmutableMultiset(): ImmutableMultiset<Byte> = toList().toImmutableMultiset()

public fun CharArray.toImmutableMultiset(): ImmutableMultiset<Char> = toList().toImmutableMultiset()

public fun ShortArray.toImmutableMultiset(): ImmutableMultiset<Short> = toList().toImmutableMultiset()

public fun IntArray.toImmutableMultiset(): ImmutableMultiset<Int> = toList().toImmutableMultiset()

public fun LongArray.toImmutableMultiset(): ImmutableMultiset<Long> = toList().toImmutableMultiset()

public fun FloatArray.toImmutableMultiset(): ImmutableMultiset<Float> = toList().toImmutableMultiset()

public fun DoubleArray.toImmutableMultiset(): ImmutableMultiset<Double> = toList().toImmutableMultiset()

public fun BooleanArray.toImmutableMultiset(): ImmutableMultiset<Boolean> = toList().toImmutableMultiset()
