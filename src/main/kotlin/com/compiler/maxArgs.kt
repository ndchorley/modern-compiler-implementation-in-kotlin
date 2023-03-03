package com.compiler

fun maxArgs(statement: Statement): Int =
    when (statement) {
        is PrintStatement -> statement.expressions.size()
        is AssignmentStatement -> 0
        is CompoundStatement -> maxOf(maxArgs(statement.statement1), maxArgs(statement.statement2))
    }
