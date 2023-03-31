package com.compiler

fun interpret(statement: Statement): String =
    when (statement) {
        is PrintStatement -> statement.expressions.interpret()
        else -> TODO()
    }

private fun ExpressionList.interpret(): String =
    when (this) {
        is LastExpressionList -> expression.interpret().plus("\n")
        else -> TODO()
    }

private fun Expression.interpret(): String =
    when (this) {
        is Number -> this.value.toString()
        else -> TODO()
    }
