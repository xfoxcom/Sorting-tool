package sorting;

import java.util.*;

public class Main {
    public static void main(final String[] args) {
        String enter = "";
        for (String arg : args) {
            if (arg.equals("-sortIntegers")) {
                enter = "sortInt"; break;
            } else
                if (arg.equals("long")) {
                enter = "long";
            }
                if (arg.equals("line")) {
                    enter = "line";
                }
                if (arg.equals("word")) {
                    enter = "word";
                }
        }
            switch (enter) {
                case "long":
                    sortLong();
                    break;
                case "line":
                    sortLine();
                    break;
                case "word":
                    sortWord();
                    break;
                case "sortInt": sortInt(); break;
            }
    }
    public static void sortLong(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Long> enter = new ArrayList<>();
        int k = 0;
        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            enter.add(number);
        }
        enter.sort(Comparator.reverseOrder());
        for (Long aLong : enter) {
            if (Objects.equals(aLong, enter.get(0))) k++;
        }
        System.out.println("Total numbers: " + enter.size() + ".");
        System.out.println("The greatest number: " + enter.get(0) + " (" + k + " time(s), " + k*100/enter.size() + "%).");
    }
    public static void sortLine() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> enter = new ArrayList<>();
        int k = 0;
        String longest = "";
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            enter.add(line);
        }
        for (String s : enter) {
            if (s.length() > longest.length()) longest = s;
        }
        for (String s : enter) {
            if (s.equals(longest)) k++;
        }
        System.out.println("Total lines: " + enter.size() + ".");
        System.out.println("The longest line:");
        System.out.println(longest);
        System.out.println("(" + k + " time(s), " + k*100/ enter.size() + "%).");
    }
    public static void sortWord() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> enter = new ArrayList<>();
        int k = 0;
        String longest = "";
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] word = line.split("\\s+");
            enter.addAll(Arrays.asList(word));
        }
        for (String s : enter) {
            if (s.length() > longest.length()) longest = s;
        }
        for (String s : enter) {
            if (s.equals(longest)) k++;
        }
        System.out.println("Total words: " + enter.size() + ".");
        System.out.println("The longest word: " + longest + " (" + k +" time(s), " + k*100/ enter.size() + "%).");
    }
    public static void sortInt() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Long> enter = new ArrayList<>();
        int k = 0;
        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            enter.add(number);
        }
        enter.sort(Comparator.naturalOrder());
        System.out.println("Total numbers: " + enter.size() + ".");
        System.out.print("Sorted data:");
        for (Long aLong : enter) {
            System.out.print(" " + aLong);
        }
    }
}
