import com.compiler.*
import com.compiler.Number
import org.junit.jupiter.api.Assertions
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

        Assertions.assertEquals(2, result)

    }
}
