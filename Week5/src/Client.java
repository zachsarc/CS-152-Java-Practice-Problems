public class Client {
    public static void main(String[] args) {
        // Instance methods
        MyInteger testInt = new MyInteger(2);
        boolean testIntEven = testInt.isEven();
        System.out.println(testIntEven);
        boolean testIntOdd = testInt.isOdd();
        System.out.println(testIntOdd);
        boolean testIntPrime = testInt.isPrime();
        System.out.println(testIntPrime);

        // Static method tests
        System.out.println(MyInteger.isEven(4));
        System.out.println(MyInteger.isOdd(4));
        System.out.println(MyInteger.isPrime(4));

        // Static overloaded method tests
        MyInteger myNum = new MyInteger(15);
        System.out.println(MyInteger.isEven(myNum));
        System.out.println(MyInteger.isOdd(myNum));
        System.out.println(MyInteger.isPrime(myNum));

        // Instance method test for equals
        MyInteger equalInt = new MyInteger(4);
        System.out.println(equalInt.equals(4));

        // Overloaded method test for equals
        MyInteger ovrEqualInt = new MyInteger(10);
        System.out.println(ovrEqualInt.equals(testInt));

        // Test for static parseInt(char[] y) method
        try {
            char[] chars = new char[]{'2', '5', '2', '4'};
            int resultParsedChar = MyInteger.parseInt(chars);
            System.out.println("Parsed int on char result: " + resultParsedChar);

            // Test for static parseInt(String s) method
            String str = "16534234";
            int resultParsedString = MyInteger.parseInt(str);
            System.out.println("Parsed int on string result: " + resultParsedString);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input, Please use numeric characters");
        }
    }
}
