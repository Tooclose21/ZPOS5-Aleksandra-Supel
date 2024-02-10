package list7;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ComplexNumber complexNumber = new ComplexNumber(3, 2);
        System.out.println(complexNumber);
        Map<Double, ComplexNumber> result = ComplexNumber.readComplexData("./src/main/resources/data.dat");
        ComplexNumber.writeComplexData("./src/main/resources/data_out.txt", result);

        Subject af = new Subject("af", 2, 2);
        System.out.println(af);

        af.toJson("./src/main/resources/json.json");
        Subject fromJson = Subject.fromJson("./src/main/resources/json.json");
        System.out.println(fromJson);

    }
}
