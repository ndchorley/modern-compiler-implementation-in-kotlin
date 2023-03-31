package com.compiler

fun interpret(statement: Statement): String =
    when (statement) {
        is PrintStatement -> interpret(statement.expressions).output
        else -> TODO()
    }

data class State(val output: String)

private fun interpret(expressionList: ExpressionList): State =
    when (expressionList) {
        is LastExpressionList -> {
            val output = interpret(expressionList.expression).plus("\n")
            State(output)
        }
        is PairExpressionList -> {
            val output =
                interpret(expressionList.head)
                    .plus(" ")
                    .plus(interpret(expressionList.tail).output)

            State(output)
        }
    }

private fun interpret(expression: Expression): String =
    when (expression) {
        is Number -> expression.value.toString()
        else -> TODO()
    }
