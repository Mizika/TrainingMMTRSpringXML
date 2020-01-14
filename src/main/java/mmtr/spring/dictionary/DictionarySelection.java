package mmtr.spring.dictionary;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DictionarySelection {
    private static Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    public static String NameDic;
    private static int lineNumber;


    public String chooseDic() {
        System.out.println("Выберите словарь:");
        try {
            lineNumber = scanner.nextInt();
        }catch (Exception err){
            System.out.println("Введён некорректный символ!");
        }
        switch(lineNumber){
            case 1:
                System.out.println("Вы находитесь в первом словаре!");
                NameDic = "first.txt";
                break;
            case 2:
                System.out.println("Вы находитесь во втором словаре!");
                NameDic = "second.txt";
                break;
            default:
                System.exit(0);
        }
        return NameDic;
    }

    @Override
    public String toString() {
        return NameDic;
    }
}
