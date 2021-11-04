package jp.co.umenetts;

public class YearMonth {
    public final int year;
    public final int month;

    public YearMonth(String input) {
        String year = input.substring(0,4);
        String month = input.substring(4, 6);
        this.year = Integer.parseInt(year);
        this.month = Integer.parseInt(month);
    }
}
