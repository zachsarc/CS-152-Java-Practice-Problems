import java.lang.StringBuilder;
public class StringBuilderPractice {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("Welcome");
        stringBuilder.append(" World");
        System.out.println(stringBuilder);
        stringBuilder.reverse();
        System.out.println(stringBuilder);
        stringBuilder.reverse();
        stringBuilder.insert(7, ",");
        System.out.println(stringBuilder);
        System.out.println(stringBuilder.capacity());
        System.out.println(stringBuilder.length());

    }
}
