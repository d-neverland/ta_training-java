package com.epam.training.dariia_binevych.words_exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtil {
    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        if (words == null || words.length == 0 || sample == null || sample.isEmpty()) return 0;
        String trimmedSample = sample.strip();
        int count = 0;
        for (String word : words) {
            if (word.strip().equalsIgnoreCase(trimmedSample)) {
                count++;
            }
        }
        return count;
    }

    public static String[] splitWords(String text) {
        if (text == null || text.isEmpty()) return null;
        String[] parts = text.trim().split("[,.:;!?\\s]+");
        List<String> result = new ArrayList<>();
        for (String part : parts) {
            if (!part.isEmpty()) result.add(part);
        }
        return result.isEmpty() ? null : result.toArray(new String[0]);
    }

    public static String convertPath(String path, boolean toWin) {
        if (path == null || path.isEmpty()) return null;
        if (path.chars().filter(ch -> ch == '~').count() > 1) return null;
        if (path.contains("~") && !path.startsWith("~")) return null;
        if (path.indexOf("C:") > 0) return null;
        if (path.chars().filter(ch -> ch == ':').count() > 1) return null;
        if (path.contains("\\") && path.contains("/")) return null;
        if (path.contains("//") || path.contains("\\\\")) return null;
        if (path.startsWith("~\\") || path.contains("\\~")) return null;

        boolean isUnix = path.startsWith("/") || path.startsWith("~") || (!path.contains(":") && !path.contains("\\"));
        boolean isWin = path.startsWith("C:") || path.contains("\\");

        if (!isUnix && !isWin) return null;
        if ((toWin && isWin) || (!toWin && isUnix)) return path;

        if (toWin) {
            if (path.equals("/")) return "C:\\";
            if (path.equals("~")) return "C:\\User";
            if (path.startsWith("~/")) return "C:\\User\\" + path.substring(2).replace("/", "\\");
            if (path.startsWith("/")) return "C:\\" + path.substring(1).replace("/", "\\");
            return path.replace("/", "\\");
        } else {
            if (path.equals("C:\\")) return "/";
            if (path.equals("C:\\User")) return "~";
            if (path.startsWith("C:\\User\\")) return "~/" + path.substring(8).replace("\\", "/");
            if (path.startsWith("C:\\")) return "/" + path.substring(3).replace("\\", "/");
            return path.replace("\\", "/");
        }
    }

    public static String joinWords(String[] words) {
        if (words == null || words.length == 0) return null;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean first = true;
        for (String word : words) {
            if (!word.isEmpty()) {
                if (!first) sb.append(", ");
                sb.append(word);
                first = false;
            }
        }
        sb.append("]");
        return sb.length() > 2 ? sb.toString() : null;
    }

    public static void main(String[] args) {
        System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS",};
        String sample = "words   ";
        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
        System.out.println("Result: " + countResult);
        int expectedCount = 2;
        System.out.println("Must be: " + expectedCount);

        System.out.println("Test 2: splitWords");
        String text = "   ,, first, second!!!! third";
        String[] splitResult = splitWords(text);
        System.out.println("Result : " + Arrays.toString(splitResult));
        String[] expectedSplit = new String[]{"first", "second", "third"};
        System.out.println("Must be: " + Arrays.toString(expectedSplit));

        System.out.println("Test 3: convertPath");
        String unixPath = "/some/unix/path";
        String convertResult = convertPath(unixPath, true);
        System.out.println("Result: " + convertResult);
        String expectedWinPath = "C:\\some\\unix\\path";
        System.out.println("Must be: " + expectedWinPath);

        System.out.println("Test 4: joinWords");
        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
        String joinResult = joinWords(toJoin);
        System.out.println("Result: " + joinResult);
        String expectedJoin = "[go, with, the, FLOW]";
        System.out.println("Must be: " + expectedJoin);
    }
}