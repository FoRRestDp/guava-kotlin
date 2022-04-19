package com.github.forrestdp.guava.kotlin.collect

import com.google.common.annotations.Beta
import com.google.common.collect.ImmutableList
import kotlin.experimental.ExperimentalTypeInference

public fun <T : Any> emptyImmutableList(): ImmutableList<T> = ImmutableList.of()

public fun <T : Any> immutableListOf(vararg elements: T): ImmutableList<T> =
    if (elements.isEmpty()) {
        emptyImmutableList()
    } else {
        ImmutableList.copyOf(elements.toList())
    }

@OptIn(ExperimentalTypeInference::class)
public inline fun <T : Any> buildImmutableList(
    @BuilderInference builderAction: ImmutableList.Builder<T>.() -> Unit,
): ImmutableList<T> =
    ImmutableList.builder<T>()
        .apply(builderAction)
        .build()

@Suppress("UnstableApiUsage")
@Beta
@OptIn(ExperimentalTypeInference::class)
public inline fun <T : Any> buildImmutableList(
    expectedSize: Int,
    @BuilderInference builderAction: ImmutableList.Builder<T>.() -> Unit,
): ImmutableList<T> =
    ImmutableList.builderWithExpectedSize<T>(expectedSize)
        .apply(builderAction)
        .build()

@Suppress("FunctionName")
public inline fun <T : Any> ImmutableList(size: Int, init: (index: Int) -> T): ImmutableList<T> =
    buildImmutableList {
        repeat(size) { index -> add(init(index)) }
    }

public fun <T : Any> Iterable<T>.toImmutableList(): ImmutableList<T> = ImmutableList.copyOf(this)

public fun <T : Any> Array<out T>.toImmutableList(): ImmutableList<T> = ImmutableList.copyOf(this)

public fun <T : Any> Sequence<T>.toImmutableList(): ImmutableList<T> = buildImmutableList {
    for (item in this@toImmutableList) {
        add(item)
    }
}

public fun ByteArray.toImmutableList(): ImmutableList<Byte> = toList().toImmutableList()

public fun CharArray.toImmutableList(): ImmutableList<Char> = toList().toImmutableList()

public fun ShortArray.toImmutableList(): ImmutableList<Short> = toList().toImmutableList()

public fun IntArray.toImmutableList(): ImmutableList<Int> = toList().toImmutableList()

public fun LongArray.toImmutableList(): ImmutableList<Long> = toList().toImmutableList()

public fun FloatArray.toImmutableList(): ImmutableList<Float> = toList().toImmutableList()

public fun DoubleArray.toImmutableList(): ImmutableList<Double> = toList().toImmutableList()

public fun BooleanArray.toImmutableList(): ImmutableList<Boolean> = toList().toImmutableList()
