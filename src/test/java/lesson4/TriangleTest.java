package lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Sveta
 */
public class TriangleTest {
    private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @BeforeAll
    static void beforeAll() {
        logger.trace("trace");

    }

    @Test
    public void checkCorrectLengthTriangle() throws NotTriangleException {
        double area = TriangleArea.bySides(3, 4, 5);
        Assertions.assertEquals(6, area);
    }

    @ParameterizedTest
    @CsvSource({ "6,1,1", "4,2,2" })
    public void checkOneSideLessSumOtherTwo(int a, int b, int c) {
        Throwable throwable = Assertions.assertThrows(NotTriangleException.class, () -> TriangleArea.bySides(a, b, c));
        Assertions.assertEquals("Одна сторона должна быть меньше суммы двух других", throwable.getMessage());
    }

    @ParameterizedTest
    @CsvSource({ "0,9,9", "-1,1,1" })
    public void checklengthsOfSidesShouldBePositive(int a, int b, int c) {
        Assertions.assertThrows(NotTriangleException.class, () -> TriangleArea.bySides(a, b, c));
    }
}
