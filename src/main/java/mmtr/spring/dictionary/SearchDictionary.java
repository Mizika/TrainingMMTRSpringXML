package mmtr.spring.dictionary;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SearchDictionary {
    private static String path;
    public static String getPath() { return path; }
    public void setPath(String path) { SearchDictionary.path = path; }

    public static void searchFiles(){
        System.out.println("Найденные словари:");
        List<String> listDic = new ArrayList<>();
        File dic = new File(getPath());
        int i = 1;
        if(dic.isDirectory()){
            for(File item : dic.listFiles()){
                String result = i++ + ". " + item.getName();
                listDic.add(result);
            }
        }else {
            System.out.println("Не найдена папка со словарями!");
        }
        System.out.println(listDic);
    }


}
