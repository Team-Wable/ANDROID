package com.teamwable.network

fun String?.isJsonObject(): Boolean = this?.startsWith("{") == true && this.endsWith("}")
fun String?.isJsonArray(): Boolean = this?.startsWith("[") == true && this.endsWith("]")