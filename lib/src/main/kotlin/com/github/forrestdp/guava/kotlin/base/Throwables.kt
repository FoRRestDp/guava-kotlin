package com.github.forrestdp.guava.kotlin.base

import com.google.common.base.Throwables
import kotlin.reflect.KClass

/**
 * Propagates `throwable` exactly as-is, if and only if it is an instance of
 * [RuntimeException], [Error], or [declaredType].
 */
public fun <X : Throwable> Throwable.propagateIfPossible(declaredType: KClass<X>) {
    Throwables.propagateIfPossible(this, declaredType.java)
}

/**
 * Propagates `throwable` exactly as-is, if and only if it is an instance of
 * [RuntimeException], [Error], or [X].
 */
public inline fun <reified X : Throwable> Throwable.propagateIfPossible() {
    propagateIfPossible(X::class)
}

/**
 * Propagates `throwable` exactly as-is, if and only if it is an instance of
 * [RuntimeException], [Error], [declaredType1] or [declaredType2]. In the
 * unlikely case that you have three or more declared checked exception types, you can handle them
 * all by invoking these methods repeatedly.
 */
public fun <X1 : Throwable, X2 : Throwable> Throwable.propagateBothIfPossible(
    declaredType1: Class<X1>,
    declaredType2: Class<X2>,
) {
    Throwables.propagateIfPossible(this, declaredType1, declaredType2)
}

/**
 * Propagates `throwable` exactly as-is, if and only if it is an instance of
 * [RuntimeException], [Error], [X1] or [X2]. In the
 * unlikely case that you have three or more declared checked exception types, you can handle them
 * all by invoking these methods repeatedly.
 */
public inline fun <reified X1 : Throwable, reified X2 : Throwable> Throwable.propagateBothIfPossible() {
    propagateBothIfPossible(X1::class.java, X2::class.java)
}

/**
 * Throws `throwable` if it is an instance of [declaredType].
 */
public fun <X : Exception> Throwable.throwIfInstanceOf(declaredType: Class<X>) {
    Throwables.throwIfInstanceOf(this, declaredType)
}

/**
 * Throws `throwable` if it is an instance of [X].
 */
public inline fun <reified X : Exception> Throwable.throwIfInstanceOf() {
    throwIfInstanceOf(X::class.java)
}

/**
 * Throws `throwable` if it is a [RuntimeException] or [Error].
 */
public fun Throwable.throwIfUnchecked() {
    Throwables.throwIfUnchecked(this)
}

/**
 * Returns the innermost cause of `throwable`. The first throwable in a chain provides
 * context from when the error or exception was initially detected.
 * 
 * @throws IllegalArgumentException if there is a loop in the causal chain
 */
public fun Throwable.getRootCause(): Throwable = Throwables.getRootCause(this)

/**
 * Gets a [Throwable] cause chain as a list. The first entry in the list will be
 * `throwable` followed by its cause hierarchy. Note that this is a snapshot of the cause chain and
 * will not reflect any subsequent changes to the cause chain.
 * 
 * @throws IllegalArgumentException if there is a loop in the causal chain
 */
@Suppress("UnstableApiUsage")
public fun Throwable.getCausalChain(): List<Throwable> = Throwables.getCausalChain(this)
