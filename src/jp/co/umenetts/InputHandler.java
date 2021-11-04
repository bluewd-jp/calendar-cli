package jp.co.umenetts;

import java.util.Optional;
import java.util.Scanner;

public class InputHandler {
    private Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public String readline() {
        return this.scanner.nextLine();
    }

    public String readline(String text) {
        System.out.print(text);
        return this.scanner.nextLine();
    }

    public Optional<YearMonth> readYm() {
        var result = this.readline("年月を入力(YYYYMM)：");
        if (result.isBlank()) return Optional.empty();

        return Optional.of(new YearMonth(result));
    }
}
