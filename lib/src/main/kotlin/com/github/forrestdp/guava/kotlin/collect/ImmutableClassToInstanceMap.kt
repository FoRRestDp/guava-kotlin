package com.github.forrestdp.guava.kotlin.collect

import com.google.common.collect.ImmutableClassToInstanceMap
import kotlin.experimental.ExperimentalTypeInference
import kotlin.reflect.KClass

public fun <T : Any> emptyImmutableClassToInstanceMap(): ImmutableClassToInstanceMap<T> =
    ImmutableClassToInstanceMap.of()

public fun <B : Any, T : B> immutableClassToInstanceMapOf(type: KClass<T>, value: T): ImmutableClassToInstanceMap<T> =
    ImmutableClassToInstanceMap.of(type.java, value)

public inline fun <reified T : Any> immutableClassToInstanceMapOf(value: T): ImmutableClassToInstanceMap<T> =
    immutableClassToInstanceMapOf(T::class, value)

@OptIn(ExperimentalTypeInference::class)
public inline fun <B : Any> buildImmutableClassToInstanceMap(
    @BuilderInference builderAction: ImmutableClassToInstanceMap.Builder<B>.() -> Unit,
): ImmutableClassToInstanceMap<B> = ImmutableClassToInstanceMap.builder<B>().apply(builderAction).build()

public fun <B : Any, S : B> Map<Class<S>, S>.toImmutableClassToInstanceMap(): ImmutableClassToInstanceMap<B> =
    ImmutableClassToInstanceMap.copyOf(this)

@JvmName("toImmutableClassToInstanceMapKt")
public fun <B : Any, S : B> Map<KClass<S>, S>.toImmutableClassToInstanceMap(): ImmutableClassToInstanceMap<B> =
    this.mapKeys { (k, _) -> k.java }.toImmutableClassToInstanceMap()
