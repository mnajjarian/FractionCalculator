/*The Fraction class is an object that holds information about a fraction (numerator and denominator). 
 *It will have several constructors and both private and public methods implementing the behavior of a 
 *fraction. The FractionCalculator class is a class that will allow the user to enter in fractions and 
 *operations, calculating and displaying the result. It will run until the user tells it to quit. When 
 *this program is complete, you won’t have to second guess your fraction arithmetic ever again!*/

/**
 *
 * @author Mahdi Najjarian
 */
public final class Fraction {
    //two private instance variables to hold the numerator and denominator as ints

    private int n;
    private int d;

    public Fraction(int n, int d) { //a two parameter constructor that initializes the numerator and denominator
        this.n = n;
        this.d = d;
        toLowestTerms();
        //throw an IllegalArgumentException if the denominator is zero
        if (this.d == 0) {
            throw new IllegalArgumentException();
            //If the user enters a negative denominator bump the negative sign to the numerator
        } else if (this.d < 0) {
            this.d = this.d * (-1);
            this.n = this.n * (-1);
        }
    }

    public Fraction(int n) {
        this(n, 1);
    }

    public Fraction() {
        this(0, 1);
    }

    public int getNumerator() {
        return this.n;
    }

    public int getDenominator() {
        return this.d;
    }

    public Fraction add(Fraction other) {
        int numer = (n * other.getDenominator()) + (other.getNumerator() * d);
        int dener = d * other.getDenominator();
        return new Fraction(numer, dener);
    }

    public Fraction subtract(Fraction other) {
        int numer = (n * other.d) - (other.n * d);
        int dener = d * other.d;
        return new Fraction(numer, dener);
    }

    public Fraction multiply(Fraction other) {
        int numer = n * other.n;
        int dener = d * other.d;
        return new Fraction(numer, dener);
    }

    public Fraction divide(Fraction other) {
        int numer = n * other.getDenominator();
        int dener = d * other.n;
        return new Fraction(numer, dener);
    }
    //converts the current fraction to the lowest terms

    public void toLowestTerms() {
        int gcd = gcd(n, d);
        n /= gcd;
        d /= gcd;
    }

    public static int gcd(int n, int d) { //takes in two ints and determines the greatest common divisor of the two ints
        if (n % d == 0) {
            return d;
        }
        return gcd(d, n % d);
    }

    @Override
    public boolean equals(Object obj) {
        Fraction other = (Fraction) obj;
        return (other.n == n) && (other.d == d);
    }

    @Override
    public String toString() {
        return this.n + "/" + this.d;

    }
}
