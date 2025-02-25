public class Complex{
    float real;
    float imaginary;

    public Complex(float real, float imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex(){
        this.real = 0;
        this.imaginary = 0;
    }

    public static Complex sum(Complex c1, Complex c2){
        Complex result = new Complex();
        result.real = c1.real + c2.real;
        result.imaginary = c1.imaginary + c2.imaginary;

        return result;
    }

    public static Complex product(Complex c1, Complex c2){
        Complex result = new Complex();
        result.real = c1.real * c2.real - c1.imaginary * c2.imaginary;
        result.imaginary = c1.real * c2.imaginary + c1.imaginary * c2.real;

        return result;
    }

    @Override
    public String toString() {
        return this.real + " + " + imaginary + "i";
    }
}
