import com.compiler.*
import com.compiler.Number
import com.compiler.Operator.PLUS
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxArgsTest {
    @Test
    fun `it returns 0 for an assignment statement`() {
        assertEquals(
            0,
            maxArgs(AssignmentStatement("a", Number(1)))
        )
    }

    @Test
    fun `it returns the number of arguments of a print statement`() {
        val statement =
            PrintStatement(
                PairExpressionList(
                    Number(5),
                    PairExpressionList(
                        Number(6),
                        LastExpressionList(Number(3))
                    )
                )
            )

        assertEquals(
            3,
            maxArgs(statement)
        )
    }

    @Test
    fun `it returns the maximum number of arguments of two print statements`() {
        val statement =
            CompoundStatement(
                PrintStatement(LastExpressionList(Number(1))),
                PrintStatement(
                    PairExpressionList(
                        Number(2),
                        LastExpressionList(Number(3))
                    )
                )
            )

        assertEquals(
            2,
            maxArgs(statement)
        )
    }

    @Test
    fun `it returns the maximum number of arguments of a print statement nested inside another`() {
        val statement =
            PrintStatement(
                LastExpressionList(
                    StatementThenExpression(
                        PrintStatement(
                            PairExpressionList(
                                Number(1),
                                LastExpressionList(Number(2))
                            )
                        ),
                        OperatorExpression(Number(4), PLUS, Number(10))
                    )
                )
            )

        assertEquals(
            2,
            maxArgs(statement)
        )
    }

    @Test
    fun `it returns the maximum number of arguments when a print statement contains several nested print statements`() {
        val statement =
            PrintStatement(
                PairExpressionList(
                    StatementThenExpression(
                        PrintStatement(LastExpressionList(Number(1))),
                        Number(2)
                    ),
                    LastExpressionList(
                        StatementThenExpression(
                            PrintStatement(
                                PairExpressionList(
                                    Number(4),
                                    PairExpressionList(
                                        Number(5),
                                        LastExpressionList(Number(6))
                                    )
                                )
                            ),
                            Number(6)
                        )
                    )
                )
            )

        assertEquals(
            3,
            maxArgs(statement)
        )
    }
}
