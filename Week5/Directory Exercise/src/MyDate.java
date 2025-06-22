import java.util.Calendar;

public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate() {
        MyDate newDate = new MyDate();
    }

    public MyDate(long elapsedTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(elapsedTime);
        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.get(Calendar.MONTH);
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
    }

    // Getters
    public int getYear() {
        return year;
    }
    public int getMonth() {
        return month;
    }
    public int getDay() {
        return day;
    }

    public String toString() {
        return month + "/" + day + "/" + year;
    }
}
