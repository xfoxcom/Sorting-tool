package sorting;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(final String[] args) {
        String full = "";
        String inputFileName, outputFileName;
        for (String arg : args) {
            full+=" " + arg;
        }
        String enter = "";
        String type = "";
        Pattern pattern = Pattern.compile("(-sortingType)\\s?(\\w+)?");
        Matcher sortType = pattern.matcher(full);
        Matcher dataType = Pattern.compile("(-dataType)\\s?(\\w+)?").matcher(full);
        Matcher nonType = Pattern.compile("-\\w+").matcher(full);
        Matcher toFile = Pattern.compile("(-inputFile)\\s?([\\w.]+)").matcher(full);
        Matcher outFile = Pattern.compile("(-outputFile)\\s?([\\w.]+)").matcher(full);

        if (sortType.find()) {
            try {
                if (sortType.group(2) == null) {
                    throw new noSortingType("No sorting type defined!");
                } else type = sortType.group(2);
            } catch (noSortingType e) {

            }
        }

        if (dataType.find()) {
            if (dataType.group(2) == null) {
                System.out.println("No data type defined!");
            } else
            enter = dataType.group(2);
        }
        while (nonType.find()) {
            if (!nonType.group().equals("-sortingType") & !nonType.group().equals("-dataType") & !nonType.group().equals("-inputFile") & !nonType.group().equals("-outputFile")) {
                System.out.println("\"" + nonType.group() + "\" is not a valid parameter. It will be skipped.");
            }
        }

        if (toFile.find()) {
            inputFileName = toFile.group(2);
            File infile = new File(inputFileName);
            try {
                infile.createNewFile();
            } catch (IOException e) {

            }
        }
        if (outFile.find()) {
            outputFileName = outFile.group(2);
            File outfile = new File(outputFileName);
            try {
                outfile.createNewFile();
            } catch (IOException e) {

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
        String any;
        while (scanner.hasNext()) {
            any = scanner.next();
            if (any.matches("-?\\d+")) {
                enter.add(Long.valueOf(any));
            } else System.out.println("\"" + any + "\" is not a long. It will be skipped.");

        }
        enter.sort(Comparator.naturalOrder());
        System.out.println("Total numbers: " + enter.size() + ".");
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
        String any;
        while (scanner.hasNext()) {
            any = scanner.next();
            if (any.matches("-?\\d+")) {
                enter.add(Integer.parseInt(any));
            } else System.out.println("\"" + any + "\" is not a long. It will be skipped.");
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
        String longest = "";
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            enter.add(line);
        }
        for (String s : enter) {
            if (s.length() > longest.length()) longest = s;
        }
        enter.sort(Comparator.naturalOrder());
        System.out.println("Total lines: " + enter.size() + ".");
        System.out.println("Sorted data:");
        for (String s : enter) {
            System.out.println(" " + s);
        }
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
        enter.sort(Comparator.naturalOrder());
        System.out.println("Total words: " + enter.size() + ".");
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
}
