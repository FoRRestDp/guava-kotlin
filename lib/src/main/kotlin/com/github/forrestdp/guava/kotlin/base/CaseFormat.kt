package com.github.forrestdp.guava.kotlin.base

import com.google.common.base.CaseFormat

public fun String.changeCaseFormat(from: CaseFormat, to: CaseFormat): String =
    from.to(to, this)
