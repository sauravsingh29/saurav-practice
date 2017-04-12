/**
 * Created by Saurav on 11-04-2017.
 */
public class SolidDesign {
    public static void main(String[] args) {
        AreaCalculator areaCalculator = new AreaCalculator();
        System.out.println(areaCalculator.calculate(new RectangleShape(2.5, 3.5)));
    }
}

interface Shape {

    /**
     * This is generic method to calculate area of any shape like <br>Rectangle</br>
     * <br>Square</br> etc.
     * @return {@link Double}
     */
    double calculateAre();
}

/**
 * Square class area calculator
 */
class SquareAreaCalculator implements Shape {

    private double len;

    public SquareAreaCalculator(double len) {
        this.len = len;
    }

    /**
     * This is generic method to calculate area of any shape of Square.
     * @return {@link Double}
     */
    @Override
    public double calculateAre() {
        return Math.pow(len, 2);
    }
}

/**
 * Rectangle class area calculator
 */
class RectangleShape implements Shape {

    private double height;
    private double width;

    public RectangleShape(double height, double width) {
        this.height = height;
        this.width = width;
    }

    /**
     * This is generic method to calculate area of any shape of Rectangle.
     * @return {@link Double}
     */
    @Override
    public double calculateAre() {
        return (height * width);
    }
}

class AreaCalculator {
    public double calculate(final Shape shape){
        return shape.calculateAre();
    }
}
