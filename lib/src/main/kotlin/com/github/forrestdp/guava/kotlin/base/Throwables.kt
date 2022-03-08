package com.github.forrestdp.guava.kotlin.base

import com.google.common.base.Throwables

public fun <X : Throwable> Throwable.propagateIfPossible(declaredType: Class<X>) {
    Throwables.propagateIfPossible(this, declaredType)
}

public inline fun <reified X : Throwable> Throwable.propagateIfPossible() {
    propagateIfPossible(X::class.java)
}

public fun <X1 : Throwable, X2 : Throwable> Throwable.propagateIfPossible(
    declaredType1: Class<X1>,
    declaredType2: Class<X2>,
) {
    Throwables.propagateIfPossible(this, declaredType1, declaredType2)
}

public inline fun <reified X1 : Throwable, reified X2 : Throwable> Throwable.propagateIfPossible2() {
    propagateIfPossible(X1::class.java, X2::class.java)
}

public fun <X : Exception> Throwable.throwIfInstanceOf(declaredType: Class<X>) {
    Throwables.throwIfInstanceOf(this, declaredType)
}

public inline fun <reified X : Exception> Throwable.throwIfInstanceOf() {
    throwIfInstanceOf(X::class.java)
}

public fun Throwable.throwIfUnchecked() {
    Throwables.throwIfUnchecked(this)
}

public fun Throwable.getRootCause(): Throwable = Throwables.getRootCause(this)

@Suppress("UnstableApiUsage")
public fun Throwable.getCausalChain(): List<Throwable> = Throwables.getCausalChain(this)

public fun Throwable.getStackTraceAsString(): String = Throwables.getStackTraceAsString(this)
