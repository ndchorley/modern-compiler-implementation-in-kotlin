import com.compiler.*
import com.compiler.Number
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
                        LastExpressionList(Number(3)))
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
}
