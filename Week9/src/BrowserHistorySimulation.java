public class BrowserHistorySimulation {
    public static void main(String[] args) {
        BrowserMain b1 = new BrowserMain();
        b1.visit("https://www.google.com");
        b1.visit("https://www.formula1.com");
        b1.visit("https://www.ccsu.edu");
        b1.visit("https://www.f1tv.formula1.com");

        // Printing
        System.out.println("Current page is: " + b1.getCurrentPage());
        b1.back();
        System.out.println("One page back is: " + b1.getCurrentPage());
        b1.forward();
        System.out.println("One page forward is: " + b1.getCurrentPage());
        b1.back();
        b1.back();
        System.out.println("Two pages back is: " + b1.getCurrentPage());
        b1.back();
        System.out.println("One page back is: " + b1.getCurrentPage());
    }
}