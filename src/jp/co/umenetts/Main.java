package jp.co.umenetts;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> weekdays = new ArrayList<>(Arrays.asList(
                "Mon", "Tue", "Wed", "Thi", "Fri", "Sat", "Sun"));

        System.out.println("カレンダーを表示するアプリケーションです。\n" +
                "表示したい年月をYYYYMMの形式で指定してください。未指定の場合は当月のカレンダーを表示します。");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("年月を入力(YYYYMM)：");
            String input = scanner.nextLine();

            // カレンダーインスタンス取得。この時点で当日日付が設定される
            Calendar c = Calendar.getInstance();

            // もし年月の入力ができていたら設定
            if (input != null && !input.trim().equals("")) {
                // 指定の形式で値がきていない場合エラーとなるため例外処理
                try {
                    int year = Integer.parseInt(input.substring(0,4));
                    int month = Integer.parseInt(input.substring(4, 6));
                    c.set(Calendar.YEAR, year);
                    c.set(Calendar.MONTH, month - 1);
                } catch (Exception e) {
                    System.out.println("入力された値が不正です。再入力してください。");
                    continue;
                }
            }
            c.set(Calendar.DAY_OF_MONTH, 1);

            // その月の日数を取得
            int daysInMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);


            // 曜日行の出力
            for (String d : weekdays) {
                System.out.printf("%4s", d);
            }
            System.out.println(); // 改行


            // 日付出力の開始を管理する変数。これがTrueになってから、日付の数字をPrintし始める
            boolean startPrinting = false;
            // 1週のうち何回Printがおこなわれたかを管理する変数。7になったら改行して、weekCountは0にリセットする。
            int weekCount = 0;

            // 日付行の出力
            // iを”日”として扱い、その月の日数分ループする。
            for (int i = 1; i <= daysInMonth; i++) {
                // 日付の設定
                c.set(Calendar.DATE, i);

                // まだ日の出力を開始していないとき、日付を出力し始める曜日まで空白をPrintする
                if (!startPrinting) {
                    for (int j = Calendar.MONDAY; j < c.get(Calendar.DAY_OF_WEEK); j++) {
                        System.out.print("    ");
                        weekCount += 1; // その週の何列目まで進めたかがわかるよう、カウントアップ
                    }
                    startPrinting = true;
                }

                // 列数が7列目（曜日リストのサイズ）まで来たら改行。カウントは０へリセット。
                if (weekCount == weekdays.size()) {
                    weekCount = 0;
                    System.out.println(); // 改行
                }

                // 日付の出力
                System.out.printf("%4d", c.get(Calendar.DATE));
                weekCount += 1;
            }

            // 改行
            System.out.println();
        }
    }
}

