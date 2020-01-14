package mmtr.spring.dictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;


public class SearchByKey {
    private static String path;
    private static DictionarySelection dictionarySelection;


    public SearchByKey(String path, DictionarySelection dictionarySelection) {
        this.path = path;
        this.dictionarySelection = dictionarySelection;
    }

    private static BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

    public static void readFromFileByKey() throws IOException {

        DictionaryReader read = new DictionaryReader(path, dictionarySelection);
        Map<String, String> data = read.readerFromFile();

        System.out.println("Введите ключ для поиска: ");
        String line = Console.readLine();
        System.out.println(data.getOrDefault(line, Const.NOT_FOUND));
    }
}