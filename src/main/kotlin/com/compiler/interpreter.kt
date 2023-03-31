package com.compiler

fun interpret(statement: Statement): String =
    when (statement) {
        is PrintStatement ->
            when (val expression = statement.expressions.first()) {
                is Number -> "${expression.value}\n"
                else -> TODO()
            }

        else -> TODO()
    }

private fun ExpressionList.first(): Expression =
    when (this) {
        is LastExpressionList -> this.expression
        is PairExpressionList -> TODO()
    }
