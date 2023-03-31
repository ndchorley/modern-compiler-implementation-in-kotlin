package com.compiler

fun interpret(statement: Statement): String =
    when (statement) {
        is PrintStatement -> "1\n"
        else -> TODO()
    }
