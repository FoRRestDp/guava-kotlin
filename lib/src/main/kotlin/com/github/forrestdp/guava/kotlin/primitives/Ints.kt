package com.github.forrestdp.guava.kotlin.primitives

import com.google.common.primitives.Ints

public fun Long.checkedToInt(): Int = Ints.checkedCast(this)

public fun Long.saturatedToInt(): Int = Ints.saturatedCast(this)

public fun Int.toByteArray(): ByteArray = Ints.toByteArray(this)

public fun Int.Companion.fromByteArray(bytes: ByteArray): Int = Ints.fromByteArray(bytes)

public fun Int.Companion.fromBytes(b1: Byte, b2: Byte, b3: Byte, b4: Byte): Int = Ints.fromBytes(b1, b2, b3, b4)
