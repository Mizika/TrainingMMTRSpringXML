package mmtr.spring.dictionary;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Action implements IAction {
    Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    private int ActionNumber;

    private static String actionWithDic = "\nВозможные действия:\n"+
            "1. Чтение списка пар из файла.\n"+
            "2. Удаление записи по ключу.\n"+
            "3. Поиск записи по ключу.\n"+
            "4. Добавление записей.\n"+
            "5. Выход из приложения.\n"+
            "6. Просмотр доступных действий.\n"+
            "7. Выбрать другой словарь.\n";

    public void action() throws IOException {
        //Поиск словаря
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SearchDictionary searchDictionary = context.getBean("searchDic", SearchDictionary.class);
        searchDictionary.searchFiles();
        //Выбор словаря
        DictionarySelection dictionarySelection = context.getBean("chooseDic", DictionarySelection.class);
        String filename = dictionarySelection.chooseDic();
        System.out.println(actionWithDic);
        for (; ;) {
            try {
                ActionNumber = Integer.parseInt(scanner.nextLine());
            } catch (Exception err) {
                System.out.println("Введён некорректный символ!");
            }
            if (ActionNumber == 1) {
                //Чтение из файла
                ReadAllFromFile readAllFromFile = context.getBean("readFromFile", ReadAllFromFile.class);
                System.out.println(readAllFromFile.readAllFromFile());
                System.out.println(actionWithDic);
            }
            else if (ActionNumber == 2 ) {
                //Удаление из файла по ключу
                DeleteByKey deleteByKey = context.getBean("deleteByKey", DeleteByKey.class);
                deleteByKey.removeFromFileByKey();
                System.out.println(actionWithDic);
            }
            else if (ActionNumber == 3) {
                //Поиск по ключу
                SearchByKey searchByKey = context.getBean("searchByKey", SearchByKey.class);
                searchByKey.readFromFileByKey();
                System.out.println(actionWithDic);
            }
            else if (ActionNumber == 4) {
                //Добавление значения
                AddValuesToFile addValuesToFile = context.getBean("addByKey", AddValuesToFile.class);
                addValuesToFile.addToFileByKey(filename);
                System.out.println(actionWithDic);
            }
            else if (ActionNumber == 6) {
                System.out.println(actionWithDic);
            }
            else if (ActionNumber == 7) {
                searchDictionary.searchFiles();
                dictionarySelection.chooseDic();
                System.out.println(actionWithDic);
            }
            else if (ActionNumber == 5) {break;}
            else {System.out.println("Действие не найденно!"); }
        }
        context.close();

        }
    }
