package com.github.forrestdp.guava.kotlin.base

import com.google.common.base.Preconditions

public fun checkArgument(expression: Boolean, errorMessage: String? = null): Unit =
    if (errorMessage == null)
        Preconditions.checkArgument(expression)
    else
        Preconditions.checkArgument(expression, errorMessage)

public fun checkState(expression: Boolean, errorMessage: String? = null): Unit =
    if (errorMessage == null)
        Preconditions.checkState(expression)
    else
        Preconditions.checkState(expression, errorMessage)

public fun checkElementIndex(index: Int, size: Int, desc: String? = null): Int =
    if (desc == null)
        Preconditions.checkElementIndex(index, size)
    else
        Preconditions.checkElementIndex(index, size, desc)

public fun checkPositionIndex(index: Int, size: Int, desc: String? = null): Int =
    if (desc == null)
        Preconditions.checkPositionIndex(index, size)
    else
        Preconditions.checkPositionIndex(index, size, desc)

public fun checkPositionIndexes(start: Int, end: Int, size: Int): Unit =
        Preconditions.checkPositionIndexes(start, end, size)
