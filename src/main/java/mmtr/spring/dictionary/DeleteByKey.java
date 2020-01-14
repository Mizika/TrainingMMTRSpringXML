package mmtr.spring.dictionary;

import java.io.*;
import java.util.Map;


public class DeleteByKey {

    private static String path;
    private static DictionarySelection dictionarySelection;


    public DeleteByKey(String path, DictionarySelection dictionarySelection) {
        this.path = path;
        this.dictionarySelection = dictionarySelection;
    }

    private static BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

    public static void removeFromFileByKey() throws IOException {
        DictionaryReader read = new DictionaryReader(path, dictionarySelection);
        Map<String, String> data = read.readerFromFile();

        System.out.println("Введите ключ для удаления: ");
        String line = Console.readLine();
        if (data.get(line) != null) {
                FileWriter fstream = new FileWriter(path+"//"+dictionarySelection);
                BufferedWriter out = new BufferedWriter(fstream);
                System.out.println("Значение \"" + data.remove(line) + "\" было удалено!");
                for (Map.Entry entry : data.entrySet()) {
                    out.write(entry.getKey() + " " + entry.getValue() + "\n");
                }
                out.close();
            }else {
                System.out.println(Const.NOT_FOUND);
            }
        }
    }
