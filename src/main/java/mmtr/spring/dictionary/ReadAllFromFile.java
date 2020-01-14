package mmtr.spring.dictionary;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadAllFromFile {
    private static String path;
    private static DictionarySelection dictionarySelection;

    public void setPath(String path) {
        ReadAllFromFile.path = path;
    }
    public static String getPath() {
        return path;
    }

    public void setDictionarySelection(DictionarySelection dictionarySelection) {
        this.dictionarySelection = dictionarySelection;
    }

    public static DictionarySelection getDictionarySelection() {
        return dictionarySelection;
    }


    public static List<String> readAllFromFile() {
        File file = new File(getPath() + "\\"+ getDictionarySelection());
        List<String> listResult = new ArrayList<>();
        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()) {
                listResult.add(sc.nextLine());
            }
        }catch (Exception err){
            err.printStackTrace();
        }
        return listResult;
    }
}
