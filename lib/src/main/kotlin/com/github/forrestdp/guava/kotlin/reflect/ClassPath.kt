package com.github.forrestdp.guava.kotlin.reflect

import com.google.common.annotations.Beta
import com.google.common.reflect.ClassPath

@Suppress("UnstableApiUsage")
@Beta
public fun ClassPath(classLoader: ClassLoader): ClassPath = ClassPath.from(classLoader)
