package com.github.forrestdp.guava.kotlin.utils

public const val NO_GETTER_MESSAGE: String = ""

public val noGetter: Nothing
    get() = throw UnsupportedOperationException(NO_GETTER_MESSAGE)
