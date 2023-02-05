package com.hust.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormatString {
    public static String removeBracket(String st) {
        String s = st.replaceAll("\\[.*?\\]", "");
        return s.replaceAll("\\(.*?\\)", "");
    }

    public static MyDate getDateInlineFromString(String input) {
        if (input.equals("?")) {
            return new MyDate();
        }
        List<String> result = new ArrayList<>();
        StringBuilder currentDigitString = new StringBuilder();
        int lastDigitCharIndex = -1;
        for (int i = 0; i < input.length(); ++i) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                currentDigitString.append(c);
                lastDigitCharIndex = i;
            } else {
                if (currentDigitString.length() > 0) {
                    result.add(currentDigitString.toString());
                    currentDigitString.setLength(0);
                }
            }
        }
        if (currentDigitString.length() > 0) {
            result.add(currentDigitString.toString());
        }
        MyDate date = new MyDate();
        if (result.size() >= 3) {
            int year = Integer.parseInt(result.get(2));
            int month = Integer.parseInt(result.get(1));
            int day = Integer.parseInt(result.get(0));
            date = new MyDate(day, month, year);
        }
        if (result.size() == 2) {
            int year = Integer.parseInt(result.get(1));
            int month = Integer.parseInt(result.get(0));
            date = new MyDate(-1, month, year);
        }
        if (result.size() == 1) {
            int year = Integer.parseInt(result.get(0));
            date = new MyDate(-1, -1, year);
        }
        boolean checkTCN = input.contains("TCN");
        if (checkTCN) date.setYear(date.getYear() * -1);
//        System.out.println(input + "\t" + date.toString() + input.substring(lastDigitCharIndex + 1));
        return date;
    }

    public static String getBirthPlaceFromString(String input) {
        if (input.equals("?")) {
            return "?";
        }
        int lastDigitCharIndex = -1;
        for (int i = 0; i < input.length(); ++i) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                lastDigitCharIndex = i;
            }
        }
        String output = input.substring(lastDigitCharIndex + 1);
        boolean checkTCN = input.contains("TCN");
        if (checkTCN) {
            // TODO: replace "TCN" in output to ""
        }
        return output;
    }

    public static MyDate getBeginDate(String input) {
        boolean ch = input.contains("–");
        if (!ch) return new MyDate();
        String[] parts = input.split("–");
        String firstPart = parts[0];
        return getDateInlineFromString(firstPart);
    }

    public static MyDate getEndDate(String input) {
        boolean ch = input.contains("–");
        if (!ch) return new MyDate();
        String[] parts = input.split("–");
        String secondPart = parts[1];
        return getDateInlineFromString(secondPart);
    }

    public static String getEventContent(String input) {
        if (input.contains("TCN")) {
            int lastIndex = input.lastIndexOf("TCN");
//            String firstPart = input.substring(0, lastIndex + 3);
            return input.substring(lastIndex + 3);
        }
        Pattern pattern = Pattern.compile("(\\d+)(?:\\s-\\s(\\d+))?\\s(.*)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            return matcher.group(3);
        } else {
            return "";
        }
    }

    public static String getEventTime(String input) {
        if (input.contains("TCN")) {
            int lastIndex = input.lastIndexOf("TCN");
            return input.substring(0, lastIndex + 3);
        }
        Pattern pattern = Pattern.compile("(\\d+)(?:\\s-\\s(\\d+))?\\s(.*)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            if (matcher.group(2) != null) {
                return matcher.group(1) + " - " + matcher.group(2);
            } else {
                return matcher.group(1);
            }
        } else {
            return "";
        }
    }

    public static List<String> getNouns(String input) {
        List<String> properNouns = new ArrayList<>();
        String[] words = input.split(" ");
        StringBuilder currentNoun = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0 && Character.isUpperCase(words[i].charAt(0))) {
                currentNoun.append(words[i]).append(" ");
                if (i == words.length - 1 || !Character.isUpperCase(words[i + 1].charAt(0))) {
                    properNouns.add(currentNoun.toString().trim());
                    currentNoun.setLength(0);
                }
            }
        }
        return properNouns;
    }
}
