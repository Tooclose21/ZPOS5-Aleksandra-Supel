package lista4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents complex number
 */
public class ComplexNumber extends Vector2D {

    /**
     * Initialize new ComplexNumber
     * @param x real part of complex number
     * @param y imaginary part of complex number
     */
    public ComplexNumber(double x, double y) {
        super(x, y);
    }

    /**
     * Adds another vector to complex number
     * @param secondVector vector to add
     * @return result of addition
     */
    @Override
    public ComplexNumber add(Vector2D secondVector) {
        return new ComplexNumber(x + secondVector.x, y + secondVector.y);
    }

    /**
     * Subtracts vector from complex number
     * @param secondVector vector to subtract by
     * @return result of subtraction
     */
    @Override
    public Vector2D subtract(Vector2D secondVector) {
        return new ComplexNumber(x - secondVector.x, y - secondVector.y);
    }

    /**
     * Multiply complex number by real number
     * @param a real number to multiply by
     * @return result of multiplication
     */
    @Override
    public Vector2D multiply(double a) {
        return new ComplexNumber(x * a, y * a);
    }

    /**
     * Divides two complex numbers
     * @param other denominator
     * @return result of division
     * @throws ArithmeticException when denominator is equal to 0
     */
    public ComplexNumber divide(ComplexNumber other) {
        double divisor = Math.pow(other.x, 2) + Math.pow(other.y, 2);
        if (divisor == 0) {
            throw new ArithmeticException("Dividing by zero is not permitted");
        }
        double x2 = x * other.x + y * other.y;
        double y2 = y * other.x - x * other.y;

        return new ComplexNumber(x2/divisor, y2/divisor);
    }

    /**
     * Divides two complex numbers
     * @param first nominator
     * @param second denominator
     * @return result of the division
     * @throws ArithmeticException when denominator is equal to 0
     */
    public static ComplexNumber divide(ComplexNumber first, ComplexNumber second) {
        return first.divide(second);
    }

    /**
     * Returns result of complex number to power of `a`,  operation
     * @param a exponent
     * @return result of operation
     */
    public ComplexNumber power(double a) {
        return new ComplexNumber(Math.pow(length(), a) * Math.cos(a * angle()),
                Math.pow(length(), a) * Math.sin(angle() * a));
    }

    /**
     * Returns result of number to `a` operation
     * @param number base
     * @param a exponent
     * @return result of number^a operation
     */
    public static ComplexNumber power(ComplexNumber number, double a) {
        return number.power(a);
    }

    /**
     * Returns string representation of the complex number
     * @return string representation
     */
    @Override
    public String toString() {
        return String.format("%f + %fj", x, y);
    }

    /**
     * Returns string representation of complex number in exponential form
     * @return representation of complex number in exponential form
     */
    public String exponentialForm () {
        return String.format("%fe^i%f", length(), angle());
    }

    /**
     * Checks if objects are equal
     * @param other object to compare
     * @return true if objects are equal, else false
     */
    @Override
    public boolean equals(Object other) {

        if (other == this) {
            return true;
        }

        if (other == null || other.getClass() != getClass()) {
            return false;
        }
        ComplexNumber otherNumber = (ComplexNumber) other;

        return otherNumber.x == x && otherNumber.y == y;
    }

    /**
     * Calculates hash code of an instance
     * @return hash code
     */
    @Override
    public int hashCode() {
        return (int) (43*x + 20*y - x*y / 5);
    }

    public static ComplexNumber fromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number as a + bj");
        String cnRepr = scanner.nextLine();
        scanner.close();
        return parseStringToComplexNumber(cnRepr);
    }

    public static ComplexNumber parseStringToComplexNumber(String cnRepr) {
        Pattern pattern = Pattern.compile("^-?[0-9]*\\.?[0-9]* *[+] *-?[0-9]*\\.?[0-9]*j$");
        Matcher matcher = pattern.matcher(cnRepr);
        if (!matcher.matches()) {
            throw new InvalidRepresentationException("Invalid representation of complex number!");
        }

        String[] parts = cnRepr.split("\\+");
        double real;
        double imag;
        try {
            real = Double.parseDouble(parts[0].trim());
            imag = Double.parseDouble(parts[1].trim().substring(0, parts[1].length() - 2));
        } catch (NumberFormatException e) {
            throw new NumberFormatException(e.getMessage());
        }

        return new ComplexNumber(real, imag);
    }
}
