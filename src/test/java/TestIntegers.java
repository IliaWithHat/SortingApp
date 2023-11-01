import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import wholeMagicThere.SortIntegers;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TestIntegers {

    @Test
    public void testIllegalArgumentException() {
        String[] emptyArgs = new String[0];
        String[] tooManyArgs = new String[11];

        assertThrows(IllegalArgumentException.class, () -> SortIntegers.main(emptyArgs));

        assertThrows(IllegalArgumentException.class, () -> SortIntegers.main(tooManyArgs));
    }

    @ParameterizedTest
    @MethodSource("testInput")
    public void testSortAndPrint(String[] input, String exOutput) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        SortIntegers.main(input);

        System.setOut(System.out);

        assertEquals(exOutput, outputStream.toString());
    }

    private static Stream<Arguments> testInput() {
        return Stream.of(
                Arguments.of(new String[]{"2", "1"}, "[1, 2]"),
                Arguments.of(new String[]{"3", "2", "4"}, "[2, 3, 4]"),
                Arguments.of(new String[]{"5", "4", "3", "2", "1"}, "[1, 2, 3, 4, 5]"),
                Arguments.of(new String[]{"5", "3", "7", "1", "2"}, "[1, 2, 3, 5, 7]")
        );
    }

}
