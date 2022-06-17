package lesson4;

/**
 * @author Sveta
 */
public class TriangleArea {
    public static double bySides(int a, int b, int c) throws NotTriangleException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new NotTriangleException("Длины сторон должны быть положительные");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new NotTriangleException("Одна сторона должна быть меньше суммы двух других");
        }

        double p1 = (a + b + c) / 2.0;
        return Math.sqrt(p1 * (p1 - a) * (p1 - b) * (p1 - c));

    }
}
