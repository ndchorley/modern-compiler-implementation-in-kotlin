package com.compiler

fun interpret(statement: Statement): String =
    when (statement) {
        is PrintStatement -> interpret(statement.expressions).output
        else -> TODO()
    }

private data class State(val output: String)

private fun interpret(expressionList: ExpressionList): State =
    when (expressionList) {
        is LastExpressionList -> {
            val newState = interpret(expressionList.expression)

            newState.copy(output = newState.output.plus("\n"))
        }

        is PairExpressionList -> {
            val newState = interpret(expressionList.head)

            val newOutput =
                newState.output
                    .plus(" ")
                    .plus(interpret(expressionList.tail).output)

            newState.copy(output = newOutput)
        }
    }

private fun interpret(expression: Expression): State =
    when (expression) {
        is Number -> State(expression.value.toString())
        else -> TODO()
    }
