import java.util.Scanner;
/**
 * A program to convert a binary string to decimal value with custom exception handling
 */

public class BinaryStringConverterWithCustomException {
        public static void main (String[] args) {
            Scanner sc = new Scanner(System.in);

            do {
                System.out.println("Enter the String you would like to convert: ");
                String userInput = sc.nextLine();

                try {
                    double result = thisToThat(userInput);
                    System.out.println("Your converted value is: " + result);
                    break;
                } catch (BinaryFormatException e) {
                    System.out.println("Not a binary number");
                }
            } while (true);

            sc.close();
        }

        public static double thisToThat (String inp) throws BinaryFormatException{
            for (char c: inp.toCharArray()) {
                if (c != '0' && c != '1') {
                    throw new BinaryFormatException("Not a binary number");
                }
            }
            return Double.parseDouble(inp);
        }
    }
