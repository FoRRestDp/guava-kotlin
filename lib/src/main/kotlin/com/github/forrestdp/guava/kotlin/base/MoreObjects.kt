package com.github.forrestdp.guava.kotlin.base

import com.google.common.base.MoreObjects

public fun Any.buildToString(builderAction: MoreObjects.ToStringHelper.() -> Unit): String =
    MoreObjects.toStringHelper(this)
        .apply(builderAction)
        .toString()
