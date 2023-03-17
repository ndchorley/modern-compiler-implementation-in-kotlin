package com.compiler

fun maxArgs(statement: Statement): Int =
    when (statement) {
        is AssignmentStatement -> 0

        is CompoundStatement -> maxOf(maxArgs(statement.statement1), maxArgs(statement.statement2))

        is PrintStatement -> {
            val statementThenExpressions = statement.expressions.statementThenExpressions()

            when (statementThenExpressions.isEmpty()) {
                true -> statement.expressions.size()
                false -> maxOf(
                    statement.expressions.size(),
                    *statementThenExpressions.map { maxArgs(it.statement) }.toIntArray()
                )
            }
        }
    }

private fun ExpressionList.statementThenExpressions(): List<StatementThenExpression> {
    fun loop(current: ExpressionList, resultSoFar: List<StatementThenExpression>): List<StatementThenExpression> {

        return when (current) {
            is LastExpressionList ->
                when (current.expression) {
                    is StatementThenExpression -> resultSoFar.plus(current.expression)
                    else -> resultSoFar
                }

            is PairExpressionList ->
                when (current.head) {
                    is StatementThenExpression ->
                        resultSoFar.plus(current.head).plus(current.tail.statementThenExpressions())
                    else -> current.tail.statementThenExpressions()
                }
        }
    }

    return loop(this, listOf())
}
