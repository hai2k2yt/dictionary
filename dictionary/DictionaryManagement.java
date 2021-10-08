package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static dictionary.Dictionary.list;

public class DictionaryManagement {

    /**
     * bỏ hàm insertFromCommandline đi vì có insertFromFile r.
     */
    public static void insertFromCommandline() {

    };
    /**
     * hàm nhập từ file.
     */
    public static void insertFromFile() throws FileNotFoundException {
        File text = new File("D:\\LTHDT\\DictionaryDevelopment\\src\\dictionary\\dictionary.txt");
        Scanner file = new Scanner(text);
        int i = 30;
        while(file.hasNextLine()) {
            String target = file.nextLine();
            if (target.equals("")) continue;
            String explain = "";
            Word newWord = new Word();

            if(target.charAt(0) == '@') {
                newWord.setWord_target(target);

                String a = file.nextLine();

                if (a.equals("")) continue;
                while (a.charAt(0) != '@') {
                    explain = explain + a + '\n';
                    a = file.nextLine();
                    if (a.equals("")) break;
                }
                newWord.setWord_explain(explain);
            }
            list.add(newWord);
        }
    }

    /**
     * kiểm tra kết quả.
     */
    public static void main(String[] args) throws FileNotFoundException {
        DictionaryManagement.insertFromFile();
        System.out.println(list.get(0).getWord_target());
        System.out.println(list.get(0).getWord_explain());
        System.out.println(list.get(1).getWord_target());
        System.out.println(list.get(1).getWord_explain());
    }
}
