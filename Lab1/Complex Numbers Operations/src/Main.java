public class Main {

    public static void main(String[] args) {
        Complex number1 = new Complex(2, 5);
        Complex number2 = new Complex(4, -1);

        Complex sum = Complex.sum(number1, number2);
        Complex product = Complex.product(number1, number2);

        System.out.println("Sum= " + sum);
        System.out.println("Product= " + product);
    }
}

