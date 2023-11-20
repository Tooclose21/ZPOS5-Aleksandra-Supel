package lista2;

public class Main {

    public static void main(String[] args) {
        ComplexNumber number1 = new ComplexNumber(5, 2);
        ComplexNumber number2 = new ComplexNumber(-5, -12);
        ComplexNumber number3 = new ComplexNumber(0, 0);

        Vector2D vector2D = new Vector2D(3, 9);

        System.out.printf("Complex number z = 5 + 2j:\nString representation: %s\nExponential form: %s\n",
                number1, number1.exponentialForm());

        System.out.printf("\nz = %s, has modulus equals %f and argument %f radians\n", number2, number2.length(), number2.angle());

        System.out.println("\nTesting instance methods");

        System.out.printf("%s + %s = %s\n", number1, number2, number1.add(number2));
        System.out.printf("%s - %s = %s\n", number1, number2, number1.subtract(number2));
        System.out.printf("%s / %s = %s\n", number1, number2, number1.divide(number2));
        System.out.printf("%s * %f = %s\n", number1, 9.6, number1.multiply(9.6));
        System.out.printf("%s^%f = %s\n", number1, 4.0, number1.power(4.0));
        try {
            number2.divide(number3);
        } catch (ArithmeticException exception) {
            System.out.println(exception);
        }

        System.out.println("\nTesting static methods");
        System.out.printf("%s + %s = %s\n", number1, number2, ComplexNumber.add(number1, number2));
        System.out.printf("%s - %s = %s\n", number1, number2, ComplexNumber.subtract(number1, number2));
        System.out.printf("%s / %s = %s\n", number1, number2, ComplexNumber.divide(number1, number2));
        System.out.printf("%s * %f = %s\n", number1, 9.6, ComplexNumber.multiply(number1, 9.6));
        System.out.printf("%s^%f = %s\n", number1, 4.0, ComplexNumber.power(number1, 4.0));
        try {
            ComplexNumber.divide(number2, number3);
        } catch (ArithmeticException exception) {
            System.out.println(exception);
        }

        System.out.println("\nTesting equals methods");

        System.out.printf("%s == %s is %b\n", number1, number2, number1.equals(number2));
        System.out.printf("%s == %s is %b\n", number1, number1, number1.equals(number1));
        System.out.printf("%s == %s is %b\n", number1, null, number1.equals(null));
        System.out.printf("%s == %s is %b\n", number1, new ComplexNumber(5, 2), number1.equals(new ComplexNumber(5, 2)));
        System.out.printf("%s == %d is %b\n", number1,  2, number1.equals(2));

        System.out.println("\nTesting getting coordinates from polar coordinates");

        System.out.printf("x, y coordinates from |z| = %f, arg(z) = %f is P(%f, %f)\n",
                Math.sqrt(2), Math.PI/4, ComplexNumber.CoordinatesFromPolar(Math.sqrt(2), Math.PI/4)[0],
                ComplexNumber.CoordinatesFromPolar(Math.sqrt(2), Math.PI/4)[1]);
        System.out.printf("x, y coordinates from |z| = %f, arg(z) = %f is P(%f, %f)\n",
                Math.sqrt(3), Math.PI/3, ComplexNumber.CoordinatesFromPolar(Math.sqrt(3), Math.PI/3)[0],
                ComplexNumber.CoordinatesFromPolar(Math.sqrt(3), Math.PI/3)[1]);

    }
}
