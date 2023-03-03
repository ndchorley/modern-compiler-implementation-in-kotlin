package com.compiler

fun maxArgs(statement: Statement): Int =
    when (statement) {
        is PrintStatement -> statement.expressions.size()
        else -> TODO()
    }
