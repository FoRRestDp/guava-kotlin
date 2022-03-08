package com.github.forrestdp.guava.kotlin.collect

import com.google.common.collect.ComparisonChain

public inline fun buildComparisonChain(builderAction: ComparisonChain.() -> Unit): Int =
    ComparisonChain.start()
        .apply(builderAction)
        .result()
