package com.compiler

fun interpret(statement: Statement): String =
    when (statement) {
        is PrintStatement -> interpret(statement.expressions)
        else -> TODO()
    }

private fun interpret(expressionList: ExpressionList): String =
    when (expressionList) {
        is LastExpressionList -> interpret(expressionList.expression).plus("\n")
        is PairExpressionList ->
            interpret(expressionList.head)
                .plus(" ")
                .plus(interpret(expressionList.tail))
    }

private fun interpret(expression: Expression): String =
    when (expression) {
        is Number -> expression.value.toString()
        else -> TODO()
    }
