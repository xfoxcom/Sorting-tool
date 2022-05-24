package sorting;

import java.util.*;

public class Main {
    public static void main(final String[] args) {
        String enter = "";
        String type = "";
        for (String arg : args) {

            if (arg.equals("byCount")) {
                type = "byCount"; break;
            } else type = "natural";
        }
        for (String arg : args) {
                if (arg.equals("long")) {
                enter = "long";
            } else
                if (arg.equals("line")) {
                    enter = "line";
                } else
                if (arg.equals("word")) {
                    enter = "word";
                }
        }
            switch (enter) {
                case "long": if (type.equals("byCount")) {
                    sortLongByCount(); break;
                } else sortLong();
                    break;
                case "line": if (type.equals("byCount")) {
                    sortLineByCount(); break;
                }
                else
                    sortLine();
                    break;
                case "word": if (type.equals("byCount")) {
                    sortWordByCount(); break;
                }
                else
                    sortWord();
                    break;
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
        enter.sort(Comparator.naturalOrder());
        for (Long aLong : enter) {
            if (Objects.equals(aLong, enter.get(0))) k++;
        }
        System.out.println("Total numbers: " + enter.size() + ".");
       // System.out.println("The greatest number: " + enter.get(0) + " (" + k + " time(s), " + k*100/enter.size() + "%).");
        System.out.print("Sorted data:");
        for (Long aLong : enter) {
            System.out.print(" " + aLong);
        }

    }
    public static void sortLongByCount() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> enter = new ArrayList<>();
        ArrayList<Pair> count = new ArrayList<>();
        Map<Integer, Integer> sort = new LinkedHashMap<>();
        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            enter.add(number);
        }
        System.out.println("Total numbers: " + enter.size() + ".");
        for (int i = 0; i < enter.size(); i++) {
           int k = 0;
           for (int j = 0; j < enter.size(); j++) {
                if (enter.get(i).equals(enter.get(j))) {
                    k++;
                }
           }
            count.add(new Pair(k, enter.get(i)));
        }
        count.sort(Comparator.comparing(Pair::getCount).thenComparing(Pair::getData));
        for (Pair pair : count) {
            sort.put(pair.data, pair.count);
        }
        for (Map.Entry<Integer, Integer> entry : sort.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time(s), " + entry.getValue()*100/enter.size() + "%");
        }
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
        enter.sort(Comparator.naturalOrder());
        System.out.println("Total lines: " + enter.size() + ".");
        System.out.println("Sorted data:");
        for (String s : enter) {
            System.out.println(" " + s);
        }
       /* System.out.println("The longest line:");
        System.out.println(longest);
        System.out.println("(" + k + " time(s), " + k*100/ enter.size() + "%).");*/
    }
    public static void sortLineByCount() {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> sort = new LinkedHashMap<>();
        ArrayList<String> enter = new ArrayList<>();
        ArrayList<Pair> count = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            enter.add(line);
        }
        System.out.println("Total lines: " + enter.size() + ".");
        for (int i = 0; i < enter.size(); i++) {
            int k = 0;
            for (int j = 0; j < enter.size(); j++) {
                if (enter.get(i).equals(enter.get(j))) {
                    k++;
                }
            }
            count.add(new Pair(k, enter.get(i)));
        }
        count.sort(Comparator.comparing(Pair::getCount).thenComparing(Pair::getWord));
        for (Pair pair : count) {
            sort.put(pair.word, pair.count);
        }
        for (Map.Entry<String, Integer> entry : sort.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time(s), " + entry.getValue()*100/enter.size() + "%");
        }
    }
    public static void sortWord() {
        Scanner scanner = new Scanner(System.in);
        int k = 0;
        ArrayList<String> enter = new ArrayList<>();
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
        enter.sort(Comparator.naturalOrder());
        System.out.println("Total words: " + enter.size() + ".");
       // System.out.println("The longest word: " + longest + " (" + k +" time(s), " + k*100/ enter.size() + "%).");
        System.out.print("Sorted data:");
        for (String s : enter) {
            System.out.print(" " + s);
        }
    }
    public static void sortWordByCount() {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> sort = new LinkedHashMap<>();
        ArrayList<Pair> count = new ArrayList<>();
        ArrayList<String> enter = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] word = line.split("\\s+");
            enter.addAll(Arrays.asList(word));
        }
        System.out.println("Total words: " + enter.size() + ".");
        for (int i = 0; i < enter.size(); i++) {
            int k = 0;
            for (int j = 0; j < enter.size(); j++) {
                if (enter.get(i).equals(enter.get(j))) {
                    k++;
                }
            }
            count.add(new Pair(k, enter.get(i)));
        }
        count.sort(Comparator.comparing(Pair::getCount).thenComparing(Pair::getWord));
        for (Pair pair : count) {
            sort.put(pair.word, pair.count);
        }
        for (Map.Entry<String, Integer> entry : sort.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time(s), " + entry.getValue()*100/enter.size() + "%");
        }
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
