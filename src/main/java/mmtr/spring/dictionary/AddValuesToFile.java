package mmtr.spring.dictionary;

import java.io.*;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AddValuesToFile {

    private static String path;
    private static DictionarySelection dictionarySelection;


    public AddValuesToFile(String path, DictionarySelection dictionarySelection) {
        AddValuesToFile.path = path;
        AddValuesToFile.dictionarySelection = dictionarySelection;
    }

    private static BufferedReader readFromConsole = new BufferedReader(new InputStreamReader(System.in));
    private static Pattern number = Pattern.compile("\\d{5}");
    private static Pattern letters = Pattern.compile("\\D{4}");
    private static Matcher fileReg;
    private static String value;

    public void addToFileByKey(String filename) throws IOException {
        DictionaryReader read = new DictionaryReader(path, dictionarySelection);
        Map<String, String> data = read.readerFromFile();

        System.out.println("Введите ключ для добавления:");
        String key = readFromConsole.readLine();
        if (data.get(key) == null) {
            System.out.println("Введите значения для добавления:");
            if (filename.equals("second.txt")) {
                System.out.println("Значение может состоять только из 5 цифр!");
                value = readFromConsole.readLine();
                fileReg = number.matcher(value);
            }
            else if (filename.equals("first.txt")) {
                System.out.println("Значение может состоять только из 4 латинских букв!");
                value = readFromConsole.readLine();
                fileReg = letters.matcher(value);
            }
            if (fileReg.matches()) {
                FileWriter fstream = new FileWriter(path + "//" + dictionarySelection);
                BufferedWriter out = new BufferedWriter(fstream);
                data.put(key, value);
                System.out.println("Значение \"" + key + " " + value + "\" было добавленно!");
                for (Map.Entry entry : data.entrySet()) {
                    out.write(entry.getKey() + " " + entry.getValue() + "\n");
                }
                out.close();
            } else { System.out.println("Введено не корректное значение!"); }
        }else { System.out.println("Значение с данным ключом уже создано!"); }
    }
}
