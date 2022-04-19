package com.github.forrestdp.guava.kotlin.base

import com.google.common.base.Strings

public fun String.padStart(minLength: Int, padChar: Char): String = 
     Strings.padStart(this, minLength, padChar)

public fun String.padEnd(minLength: Int, padChar: Char): String = 
     Strings.padEnd(this, minLength, padChar)

public infix fun String.repeat(count: Int): String =
    Strings.repeat(this, count)

public fun CharSequence.commonPrefixWith(other: CharSequence): String =
    Strings.commonPrefix(this, other)

public fun CharSequence.commonSuffixWith(other: CharSequence): String =
    Strings.commonSuffix(this, other)
