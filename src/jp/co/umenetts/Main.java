package jp.co.umenetts;

public class Main {

    public static void main(String[] args) {
        var handler = new InputHandler();
        ViewHandler.entry();

        while (true) {
            var ym = handler.readYm();
            ViewHandler.showCalendar(ym);
        }
    }
}

