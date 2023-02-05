package com.hust.cli;

import com.hust.historical.History;
import com.hust.historical.model.Dynasty;
import com.hust.historical.model.Figure;
import com.hust.historical.model.Human;
import com.hust.historical.model.Monarch;

import java.util.Scanner;

public class App {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String BOLD_TEXT = "\033[0;1m";

    private History history;

    public void mainMenu() {
        System.out.println("\n\n\n" + BOLD_TEXT + ANSI_BLUE + "OPTIONS: " + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "[1]. " + ANSI_RESET + "Xem triều đại");
        System.out.println(ANSI_YELLOW + "[2]. " + ANSI_RESET + "Xem nhân vật lịch sử");
        System.out.println(ANSI_YELLOW + "[3]. " + ANSI_RESET + "Xem sự kiện lịch sử");
        System.out.println(ANSI_YELLOW + "[4]. " + ANSI_RESET + "Xem di tích lịch sử");
        System.out.println(ANSI_YELLOW + "[5]. " + ANSI_RESET + "Xem các lễ hội văn hoá");
        System.out.println(ANSI_YELLOW + "[0]. " + ANSI_RESET + "Exit!");
    }

    public void dynastyMenu() {
        Table table = new Table("Dynasty.json");
        System.out.println("\n\n\n" + BOLD_TEXT + ANSI_BLUE + "Các triều đại Việt Nam: " + ANSI_RESET);
        System.out.println(BOLD_TEXT + ANSI_BLUE + "OPTIONS : " + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "[1]. " + ANSI_RESET + "Tải thêm");
        System.out.println(ANSI_YELLOW + "[2]. " + ANSI_RESET + "Tìm kiếm");
        System.out.println(ANSI_YELLOW + "[3]. " + ANSI_RESET + "Trở lại menu chính");
        System.out.print(ANSI_CYAN + "Chọn: " + ANSI_RESET);
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        while (choice < 1 || choice > 3) {
            System.out.println(ANSI_RED + "Chọn sai rồi, chọn lại đi" + ANSI_RESET);
            System.out.print(ANSI_CYAN + "Chọn: " + ANSI_RESET);
            choice = in.nextInt();
        }
        switch (choice) {
            case 1 -> {
                System.out.println(ANSI_YELLOW + "Available soon! ¯\\_(ツ)_/¯ ..." + ANSI_RESET);
            }
            case 2 -> {
                System.out.print(ANSI_CYAN + "Nhập tên triều đại: " + ANSI_RESET);
                in.nextLine();
                String name = in.nextLine();
                Dynasty res = history.findDynasty(name);
                if (res != null) {
                    System.out.println(res.toString());
                } else {
                    System.out.println(ANSI_RED + "Không tìm thấy" + ANSI_RESET);
                }
            }
            case 3 -> mainMenu();
            default -> System.out.println(ANSI_RED + "Chọn sai rồi, chọn lại đi" + ANSI_RESET);
        }
    }

    public void eventMenu() {
        Table table = new Table("event.json");
        System.out.println("\n\n\n" + BOLD_TEXT + ANSI_BLUE + "Các sự kiện lịch sử Việt Nam: " + ANSI_RESET);
        System.out.println(BOLD_TEXT + ANSI_BLUE + "OPTIONS : " + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "[1]. " + ANSI_RESET + "Tải thêm");
        System.out.println(ANSI_YELLOW + "[2]. " + ANSI_RESET + "Tìm kiếm");
        System.out.println(ANSI_YELLOW + "[3]. " + ANSI_RESET + "Trở lại menu chính");
        System.out.print(ANSI_CYAN + "Chọn: " + ANSI_RESET);
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        while (choice < 1 || choice > 3) {
            System.out.println(ANSI_RED + "Chọn sai rồi, chọn lại đi" + ANSI_RESET);
            System.out.print(ANSI_CYAN + "Chọn: " + ANSI_RESET);
            choice = in.nextInt();
        }
        switch (choice) {
            case 1 -> {
                System.out.println(ANSI_YELLOW + "Available soon! ¯\\_(ツ)_/¯ ..." + ANSI_RESET);
            }
            case 2 -> {
                System.out.print(ANSI_CYAN + "Nhập tên triều đại: " + ANSI_RESET);
                in.nextLine();
                String name = in.nextLine();
                Dynasty res = history.findDynasty(name);
                if (res != null) {
                    System.out.println(res.toString());
                } else {
                    System.out.println(ANSI_RED + "Không tìm thấy" + ANSI_RESET);
                }
            }
            case 3 -> mainMenu();
            default -> System.out.println(ANSI_RED + "Chọn sai rồi, chọn lại đi" + ANSI_RESET);
        }
    }
    public void siteMenu() {
        Table table = new Table("site.json");
        System.out.println("\n\n\n" + BOLD_TEXT + ANSI_BLUE + "Các di tích lịch sử Việt Nam: " + ANSI_RESET);
        System.out.println(BOLD_TEXT + ANSI_BLUE + "OPTIONS : " + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "[1]. " + ANSI_RESET + "Tải thêm");
        System.out.println(ANSI_YELLOW + "[2]. " + ANSI_RESET + "Tìm kiếm");
        System.out.println(ANSI_YELLOW + "[3]. " + ANSI_RESET + "Trở lại menu chính");
        System.out.print(ANSI_CYAN + "Chọn: " + ANSI_RESET);
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        while (choice < 1 || choice > 3) {
            System.out.println(ANSI_RED + "Chọn sai rồi, chọn lại đi" + ANSI_RESET);
            System.out.print(ANSI_CYAN + "Chọn: " + ANSI_RESET);
            choice = in.nextInt();
        }
        switch (choice) {
            case 1 -> {
                System.out.println(ANSI_YELLOW + "Available soon! ¯\\_(ツ)_/¯ ..." + ANSI_RESET);
            }
            case 2 -> {
                System.out.print(ANSI_CYAN + "Nhập tên triều đại: " + ANSI_RESET);
                in.nextLine();
                String name = in.nextLine();
                Dynasty res = history.findDynasty(name);
                if (res != null) {
                    System.out.println(res.toString());
                } else {
                    System.out.println(ANSI_RED + "Không tìm thấy" + ANSI_RESET);
                }
            }
            case 3 -> mainMenu();
            default -> System.out.println(ANSI_RED + "Chọn sai rồi, chọn lại đi" + ANSI_RESET);
        }
    }
    public void festivalMenu() {
        Table table = new Table("festival.json");
        System.out.println("\n\n\n" + BOLD_TEXT + ANSI_BLUE + "Các lễ hội văn hoá Việt Nam: " + ANSI_RESET);
        System.out.println(BOLD_TEXT + ANSI_BLUE + "OPTIONS : " + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "[1]. " + ANSI_RESET + "Tải thêm");
        System.out.println(ANSI_YELLOW + "[2]. " + ANSI_RESET + "Tìm kiếm");
        System.out.println(ANSI_YELLOW + "[3]. " + ANSI_RESET + "Trở lại menu chính");
        System.out.print(ANSI_CYAN + "Chọn: " + ANSI_RESET);
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        while (choice < 1 || choice > 3) {
            System.out.println(ANSI_RED + "Chọn sai rồi, chọn lại đi" + ANSI_RESET);
            System.out.print(ANSI_CYAN + "Chọn: " + ANSI_RESET);
            choice = in.nextInt();
        }
        switch (choice) {
            case 1 -> {
                System.out.println(ANSI_YELLOW + "Available soon! ¯\\_(ツ)_/¯ ..." + ANSI_RESET);
            }
            case 2 -> {
                System.out.print(ANSI_CYAN + "Nhập tên triều đại: " + ANSI_RESET);
                in.nextLine();
                String name = in.nextLine();
                Dynasty res = history.findDynasty(name);
                if (res != null) {
                    System.out.println(res.toString());
                } else {
                    System.out.println(ANSI_RED + "Không tìm thấy" + ANSI_RESET);
                }
            }
            case 3 -> mainMenu();
            default -> System.out.println(ANSI_RED + "Chọn sai rồi, chọn lại đi" + ANSI_RESET);
        }
    }
    public void humanMenu() {
        System.out.println("\n\n\n" + BOLD_TEXT + ANSI_BLUE + "\"Các nhân vật lịch sử Việt Nam\"" + ANSI_RESET);
        System.out.println(BOLD_TEXT + ANSI_BLUE + "OPTIONS : " + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "[1]. " + ANSI_RESET + "Vua");
        System.out.println(ANSI_YELLOW + "[2]. " + ANSI_RESET + "Mặc định");
        System.out.print(ANSI_CYAN + "Chọn: " + ANSI_RESET);
        Scanner in = new Scanner(System.in);
        String c = in.nextLine();
        if (c.equals("1")) {
            new Table("monarch.json");
            System.out.println(BOLD_TEXT + ANSI_BLUE + "OPTIONS : " + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "[1]. " + ANSI_RESET + "Tải thêm");
            System.out.println(ANSI_YELLOW + "[2]. " + ANSI_RESET + "Tìm kiếm");
            System.out.println(ANSI_YELLOW + "[3]. " + ANSI_RESET + "Trở lại menu chính");
            System.out.print(ANSI_CYAN + "Chọn: " + ANSI_RESET);
            int choice = in.nextInt();
            while (choice < 1 || choice > 3) {
                System.out.println(ANSI_RED + "Chọn sai rồi, chọn lại đi" + ANSI_RESET);
                System.out.print(ANSI_CYAN + "Chọn: " + ANSI_RESET);
                choice = in.nextInt();
            }
            switch (choice) {
                case 1 -> {
                    System.out.println(ANSI_YELLOW + "Available soon! ¯\\_(ツ)_/¯ ..." + ANSI_RESET);
                }
                case 2 -> {
                    System.out.print(ANSI_CYAN + "Nhập tên: " + ANSI_RESET);
                    in.nextLine();
                    String name = in.nextLine();
                    Monarch res = (Monarch) history.findHuman(name);
                    if (res != null) {
                        System.out.println(res.toString());
                    } else {
                        System.out.println(ANSI_RED + "Không tìm thấy" + ANSI_RESET);
                    }
                }
                case 3 -> mainMenu();
                default -> System.out.println(ANSI_RED + "Chọn sai rồi, chọn lại đi" + ANSI_RESET);
            }
        } else {
            new Table("figure.json");
            System.out.println(BOLD_TEXT + ANSI_BLUE + "OPTIONS : " + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "[1]. " + ANSI_RESET + "Tải thêm");
            System.out.println(ANSI_YELLOW + "[2]. " + ANSI_RESET + "Tìm kiếm");
            System.out.println(ANSI_YELLOW + "[3]. " + ANSI_RESET + "Trở lại menu chính");
            System.out.print(ANSI_CYAN + "Chọn: " + ANSI_RESET);
            int choice = in.nextInt();
            while (choice < 1 || choice > 3) {
                System.out.println(ANSI_RED + "Chọn sai rồi, chọn lại đi" + ANSI_RESET);
                System.out.print(ANSI_CYAN + "Chọn: " + ANSI_RESET);
                choice = in.nextInt();
            }
            switch (choice) {
                case 1 -> {
                    System.out.println(ANSI_YELLOW + "Available soon! ¯\\_(ツ)_/¯ ..." + ANSI_RESET);
                }
                case 2 -> {
                    System.out.print(ANSI_CYAN + "Nhập tên: " + ANSI_RESET);
                    in.nextLine();
                    String name = in.nextLine();
                    Figure res = (Figure) history.findHuman(name);
                    if (res != null) {
                        System.out.println(res.toString());
                    } else {
                        System.out.println(ANSI_RED + "Không tìm thấy" + ANSI_RESET);
                    }
                }
                case 3 -> mainMenu();
                default -> System.out.println(ANSI_RED + "Chọn sai rồi, chọn lại đi" + ANSI_RESET);
            }
        }

    }

    public void appInfo() {
        System.out.print(ANSI_YELLOW + "Triều đại: " + ANSI_RESET + history.getDynasties().size() + "\t");
        int numHuman = 0;
        int numMonarch = 0;
        for (int i = 0; i < history.getDynasties().size(); i++) {
            numHuman += history.getDynasties().get(i).getHumanArrayList().size();
            for (int j = 0; j < history.getDynasties().get(i).getHumanArrayList().size(); j++) {
                if (history.getDynasties().get(i).getHumanArrayList().get(j) instanceof Monarch) {
                    numMonarch++;
                }
            }
        }
        int numEvent = 0;
        for (int i = 0; i < history.getDynasties().size(); i++) {
            numEvent += history.getDynasties().get(i).getEvents().size();
        }
        System.out.print(ANSI_PURPLE + "Nhân vật lịch sử: " + ANSI_RESET + numHuman + ANSI_RED + " (Vua: " + ANSI_RESET + numMonarch + ANSI_RED + ")" + ANSI_RESET + "\t");
        System.out.print(ANSI_BLUE + "Di tích lịch sử: " + ANSI_RESET + history.getSites().size() + "\t");
        System.out.print(ANSI_GREEN + "Lễ hội văn hoá: " + ANSI_RESET + history.getFestivals().size() + "\t");
        System.out.print(ANSI_CYAN + "Sự kiện lịch sử: " + ANSI_RESET + numEvent + "\t");
    }

    public App(History history) {
        this.history = history;
        title();
        appInfo();
        while (true) {
            mainMenu();
            System.out.print(ANSI_CYAN + "Chọn: " + ANSI_RESET);
            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();
            switch (choice) {
                case 1 -> dynastyMenu();
                case 2 -> humanMenu();
                case 3 -> eventMenu();
                case 4 -> siteMenu();
                case 5 -> festivalMenu();
                case 0 -> {
                    System.out.println(ANSI_PURPLE + "Tạm biệt!" + ANSI_RESET);
                    System.exit(0);
                }
                default -> System.out.println(ANSI_RED + "Chọn sai rồi, chọn lại đi" + ANSI_RESET);
            }
        }
    }

    private void title() {
        System.out.println(ANSI_RED + " __    __   __                __                                     ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;" + ANSI_RESET);
        System.out.println(ANSI_RED + "/  |  /  | /  |              /  |                                    ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;" + ANSI_RESET);
        System.out.println(ANSI_RED + "$$ |  $$ | $$/    _______   _$$ |_      ______     ______   __    __ ;;;;;;;;;;;;;;;;;;;;;;;lkkl;;;;;;;;;;;;;;;;;;;;;;;" + ANSI_RESET);
        System.out.println(ANSI_RED + "$$ |__$$ | /  |  /       | / $$   |    /      \\   /      \\ /  |  /  |;;;;;;;;;;;;;;;;;;;;;;:kXXk:;;;;;;;;;;;;;;;;;;;;;;" + ANSI_RESET);
        System.out.println(ANSI_RED + "$$    $$ | $$ | /$$$$$$$/  $$$$$$/    /$$$$$$  | /$$$$$$  |$$ |  $$ |;;;;;;;;;;;;;;;::cccccdKXNKxccccc::;;;;;;;;;;;;;;;" + ANSI_RESET);
        System.out.println(ANSI_RED + "$$$$$$$$ | $$ | $$      \\    $$ | __  $$ |  $$  |$$ |  $$/ $$ |  $$ |;;;;;;;;;;;;;;;:ok0K00KXXNXXK000xo:;;;;;;;;;;;;;;;" + ANSI_RESET);
        System.out.println(ANSI_RED + "$$ |  $$ | $$ |  $$$$$$  |   $$ |/  | $$ \\__$$  |$$ |      $$ \\__$$ |;;;;;;;;;;;;;;;;;:lx0XXXXNXXX0xl:;,;;;;;;;;;;;;;;;" + ANSI_RESET);
        System.out.println(ANSI_RED + "$$ |  $$ | $$ | /     $$/    $$  $$/  $$    $$/  $$ |      $$    $$ |;;;;;;;;;;;;;;;;;;;:xKXXXXXXKx;;;;;;;;;;;;;;;;;;;;" + ANSI_RESET);
        System.out.println(ANSI_RED + "$$/   $$/  $$/  $$$$$$$/      $$$$/    $$$$$$/   $$/        $$$$$$$ |;;;;;;;;;;;;;;;;;;;l0XKkxxkKX0l;;;;;;;;;;;;;;;;;;;" + ANSI_RESET);
        System.out.println(ANSI_RED + "                                                           /  \\__$$ |;;;;;;;;;;;;;;;;;;:xkdc;;,;cdkx:;;;;;;;;;;;;;;;;;;" + ANSI_RESET);
        System.out.println(ANSI_RED + "                                                           $$    $$/ ;;;;;;;;;;;;;;;;;;:c:;;;;;;;;:c:;;;;;;;;;;;;;;;;;;" + ANSI_RESET);
        System.out.println(ANSI_RED + "                                                            $$$$$$/  ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;" + ANSI_RESET);
        System.out.println(ANSI_RED + "                                                                     ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;" + ANSI_RESET);
    }
}
