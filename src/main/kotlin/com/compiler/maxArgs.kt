package com.compiler

fun maxArgs(statement: Statement): Int =
    when (statement) {
        is PrintStatement ->
            when (val statementThenExpression = statement.expressions.aStatementThenExpression()) {
                null -> statement.expressions.size()
                else -> maxOf(
                    statement.expressions.size(),
                    maxArgs(statementThenExpression.statement)
                )
            }
        is AssignmentStatement -> 0
        is CompoundStatement -> maxOf(maxArgs(statement.statement1), maxArgs(statement.statement2))
    }

private fun ExpressionList.aStatementThenExpression(): StatementThenExpression? {
    return when (this) {
        is LastExpressionList ->
            when (expression) {
                is StatementThenExpression -> expression
                else -> null
            }

        is PairExpressionList ->
            when (head) {
                is StatementThenExpression -> head
                else -> tail.aStatementThenExpression()
            }
    }
}
