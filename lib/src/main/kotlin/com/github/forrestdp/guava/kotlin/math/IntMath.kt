package com.github.forrestdp.guava.kotlin.math

import com.google.common.annotations.Beta
import com.google.common.math.IntMath
import java.math.RoundingMode

@Suppress("UnstableApiUsage")
@Beta
public fun Int.ceilingPowerOfTwo(): Int = IntMath.ceilingPowerOfTwo(this)

@Suppress("UnstableApiUsage")
@Beta
public fun Int.floorPowerOfTwo(): Int = IntMath.floorPowerOfTwo(this)

public fun Int.isPowerOfTwo(): Boolean = IntMath.isPowerOfTwo(this)

public fun log2(x: Int, mode: RoundingMode): Int = IntMath.log2(x, mode)

public fun log10(x: Int, mode: RoundingMode): Int = IntMath.log10(x, mode)

public fun Int.pow(k: Int): Int = IntMath.pow(this, k)

public fun sqrt(x: Int, mode: RoundingMode): Int = IntMath.sqrt(x, mode)

public fun Int.divide(q: Int, mode: RoundingMode): Int = IntMath.divide(this, q, mode)

public fun gcd(a: Int, b: Int): Int = IntMath.gcd(a, b)

public infix fun Int.checkedAdd(other: Int): Int = IntMath.checkedAdd(this, other)

public infix fun Int.checkedSubtract(other: Int): Int = IntMath.checkedSubtract(this, other)

public infix fun Int.checkedMultiply(other: Int): Int = IntMath.checkedMultiply(this, other)

public fun Int.checkedPow(other: Int): Int = IntMath.checkedPow(this, other)

@Suppress("UnstableApiUsage")
@Beta
public infix fun Int.saturatedAdd(other: Int): Int = IntMath.saturatedAdd(this, other)

@Suppress("UnstableApiUsage")
@Beta
public infix fun Int.saturatedSubtract(other: Int): Int = IntMath.saturatedSubtract(this, other)

@Suppress("UnstableApiUsage")
@Beta
public infix fun Int.saturatedMultiply(other: Int): Int = IntMath.saturatedMultiply(this, other)

@Suppress("UnstableApiUsage")
@Beta
public infix fun Int.saturatedPow(other: Int): Int = IntMath.saturatedPow(this, other)

public fun Int.intFactorial(): Int = IntMath.factorial(this)

public fun binomial(n: Int, k: Int): Int = IntMath.binomial(n, k)

public fun mean(x: Int, y: Int): Int = IntMath.mean(x, y)

@Suppress("UnstableApiUsage")
@Beta
public fun Int.isPrime(): Boolean = IntMath.isPrime(this)
