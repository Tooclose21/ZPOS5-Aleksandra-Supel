import lista4.ComplexNumber;
import lista4.InvalidRepresentationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ComplexNumberTest {

    ComplexNumber positiveNum = new ComplexNumber(1, 2);
    ComplexNumber positiveSecondNum = new ComplexNumber(3, 4);
    ComplexNumber negativeNum = new ComplexNumber(-1, -2);
    ComplexNumber negativeSecondNum = new ComplexNumber(-3, -4);
    private final double epsilon = 1e-3;

    @Test
    public void testPositiveAddition() {
        assertEquals(positiveNum.add(positiveSecondNum), new ComplexNumber(4, 6));
    }

    @Test
    public void testNegativeAddition() {
        assertEquals(negativeNum.add(negativeSecondNum), new ComplexNumber(-4, -6));
    }

    @Test
    public void testMixedAddition() {
        assertEquals(positiveNum.add(negativeNum), new ComplexNumber(0, 0));
    }

    @Test
    public void testPositiveSub() {
        assertEquals(positiveNum.subtract(positiveSecondNum), new ComplexNumber(-2, -2));
    }

    @Test
    public void testNegativeSub() {
        assertEquals(negativeNum.subtract(negativeSecondNum), new ComplexNumber(2, 2));
    }

    @Test
    public void testMixedSub() {
        assertEquals(positiveNum.subtract(negativeNum), new ComplexNumber(2, 4));
    }

    @Test
    public void testPositiveMul() {
        assertEquals(positiveNum.multiply(2), new ComplexNumber(2, 4));
    }

    @Test
    public void testNegativeMul() {
        assertEquals(negativeNum.multiply(2), new ComplexNumber(-2, -4));
    }

    @Test
    public void testPositiveDiv() {
        assertEquals(positiveNum.divide(positiveSecondNum), new ComplexNumber(0.44, 0.08));
    }

    @Test
    public void testNegativeDiv() {
        assertEquals(negativeNum.divide(negativeSecondNum), new ComplexNumber(0.44, 0.08));
    }

    @Test
    public void testMixedDiv() {
        assertEquals(negativeNum.divide(positiveNum), new ComplexNumber(-1, 0));
    }

    @Test
    public void testPositivePowerReal() {
        assertEquals(positiveNum.power(2).getX(), new ComplexNumber(-3, 4).getX(), epsilon);
    }

    @Test
    public void testPositivePowerImaginary() {
        assertEquals(positiveNum.power(2).getY(), new ComplexNumber(-3, 4).getY(), epsilon);
    }

     @Test
    public void testNegativePowerReal() {
        assertEquals(negativeNum.power(2).getX(), new ComplexNumber(-3, 4).getX(), epsilon);
    }

    @Test
    public void testNegativePowerImaginary() {
        assertEquals(negativeNum.power(2).getY(), new ComplexNumber(-3, 4).getY(), epsilon);
    }

    @Test
    public void testToString() {
        assertEquals(positiveNum.toString(), String.format("%f + %fj", 1.0, 2.0));
    }

    @Test
    public void testToExpForm() {
        assertEquals(positiveNum.exponentialForm(), String.format("%fe^i%f", 2.236068, 1.107149));
    }

    @Test
    public void testEqualsTrue() {
        assertTrue(positiveNum.equals(new ComplexNumber(1, 2)));
    }

    @Test
    public void testEqualsFalse() {
        assertFalse(positiveNum.equals(new ComplexNumber(-1, -2)));
    }

    @Test
    public void testEqualsIdentity() {
        assertTrue(positiveNum.equals(positiveNum));
    }

    @Test
    public void testLength() {
        assertEquals(positiveNum.length(), 2.23606, epsilon);
    }

    @Test
    public void testArg() {
        assertEquals(positiveNum.angle(), 1.107, epsilon);
    }

    @Test
    public void testDivZero() {
        assertThrows(ArithmeticException.class, () -> positiveNum.divide(new ComplexNumber(0, 0)));
    }

    @Test
    public void testParseCorrect() {
        assertEquals(ComplexNumber.parseStringToComplexNumber("-2.9 + -3.2j"), new ComplexNumber(-2.9, -3.2));
    }

    @Test
    public void testParseInvalidInput() {
        assertThrows(InvalidRepresentationException.class, () -> ComplexNumber.parseStringToComplexNumber("bla bla"));
    }
}
