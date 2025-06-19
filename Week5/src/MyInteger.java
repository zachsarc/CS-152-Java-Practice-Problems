public class MyInteger {
    public int value;

    // Constructor
    public MyInteger(int value) {
        this.value = value;
    }

    // Getter
    public int getMyInteger() {
        return value;
    }

    // Instance methods
    public boolean isEven() {
        return value % 2 == 0;
    }

    public boolean isOdd() {
        return value % 2 == 1;
    }

    public boolean isPrime() {
        if (value <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Static methods
    static boolean isEven(int n) {
        return n % 2 == 0;
    }

    static boolean isOdd(int n) {
        return n % 2 == 1;
    }

    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Static overloaded methods reusing same logic to keep code "DRY"
    public static boolean isEven(MyInteger myInt) {
        return isEven(myInt.getMyInteger());
    }

    static boolean isOdd(MyInteger myInt) {
        return isOdd(myInt.getMyInteger());
    }

    static boolean isPrime(MyInteger myInt) {
        return isPrime(myInt.getMyInteger());
    }

    // Instance Method for equals
    public boolean equals(int x) {
        return this.value == x;
    }

    // Overloaded method for equals
    public boolean equals(MyInteger myInt) {
        return this.value == myInt.getMyInteger();
    }

    // Static parseInt method for an array of chars with exception throw for whoever is calling the method
    public static int parseInt(char[] y) throws NumberFormatException {
        String str = String.valueOf(y);
        return Integer.parseInt(str);
    }

    // Static parseInt method for a String with exception throw for whoever is calling the method
    public static int parseInt(String s) throws NumberFormatException{
        return Integer.parseInt(s);
    }
}
