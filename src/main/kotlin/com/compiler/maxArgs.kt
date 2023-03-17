package com.compiler

fun maxArgs(statement: Statement): Int =
    when (statement) {
        is PrintStatement -> {
            when (val statementThenExpression = statement.expressions.statementThenExpressions().firstOrNull()) {
                null -> statement.expressions.size()
                else -> maxOf(
                    statement.expressions.size(),
                    maxArgs(statementThenExpression.statement)
                )
            }
        }

        is AssignmentStatement -> 0
        is CompoundStatement -> maxOf(maxArgs(statement.statement1), maxArgs(statement.statement2))
    }

private fun ExpressionList.statementThenExpressions(): List<StatementThenExpression> {
    return when (this) {
        is LastExpressionList ->
            when (expression) {
                is StatementThenExpression -> listOf(expression)
                else -> listOf()
            }

        is PairExpressionList ->
            when (head) {
                is StatementThenExpression -> listOf(head)
                else -> tail.statementThenExpressions()
            }
    }
}
