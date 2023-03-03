import com.compiler.*
import com.compiler.Number
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxArgsTest {
    @Test
    fun `it returns the number of arguments of a print statement`() {
        val statement =
            PrintStatement(
                PairExpressionList(
                    Number(5),
                    LastExpressionList(Number(6))
                )
            )

        val result = maxArgs(statement)

        assertEquals(2, result)
    }

    @Test
    fun `it returns 0 for an assignment statement`() {
        assertEquals(
            0,
            maxArgs(AssignmentStatement("a", Number(1)))
        )
    }
}
