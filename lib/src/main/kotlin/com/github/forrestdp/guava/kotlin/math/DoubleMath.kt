package com.github.forrestdp.guava.kotlin.math

import com.google.common.math.DoubleMath
import java.math.BigInteger
import java.math.RoundingMode

public fun Double.roundToInt(mode: RoundingMode): Int = DoubleMath.roundToInt(this, mode)

public fun Double.roundToLong(mode: RoundingMode): Long = DoubleMath.roundToLong(this, mode)

public fun Double.roundToBigInteger(mode: RoundingMode): BigInteger = DoubleMath.roundToBigInteger(this, mode)

public fun Double.isPowerOfTwo(): Boolean = DoubleMath.isPowerOfTwo(this)

public fun log2(x: Double): Double = DoubleMath.log2(x)

public fun log2(x: Double, mode: RoundingMode): Int = DoubleMath.log2(x, mode)

public fun Double.isMathematicalInteger(): Boolean = DoubleMath.isMathematicalInteger(this)

public fun Int.doubleFactorial(): Double = DoubleMath.factorial(this)

public fun Double.fuzzyEquals(other: Double, tolerance: Double): Boolean =
    DoubleMath.fuzzyEquals(this, other, tolerance)

public fun Double.fuzzyCompare(other: Double, tolerance: Double): Int = 
    DoubleMath.fuzzyCompare(this, other, tolerance)
