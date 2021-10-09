import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class DictionaryManagement {
    /**
     * kiểm tra xem string có rỗng.
     */
    public static boolean empty( final String s ) {
        return s == null || s.trim().isEmpty();
    }

    /**
     * hàm nhập từ commandline.
     */
    public static void insertFromCommandline() {
        Scanner input = new Scanner(System.in);
        Word newWord = new Word();
        newWord.setWord_target(input.nextLine());
        newWord.setWord_explain(input.nextLine());
        Dictionary.list.add(newWord);
    };

    /**
     * hàm nhập từ file.
     */
    public static void insertFromFile() throws FileNotFoundException {
        File text = new File("D:\\LTHDT\\DictionaryDevelopment\\src\\dictionary\\dictionary.txt");
        Scanner file = new Scanner(text);
        String a = file.nextLine();
        String target;
        while(file.hasNextLine()) {
            if (!empty(a)) {
                target = a;
            }
            else {
                target = file.nextLine();
            }
            if (empty(target)) continue;
            String explain = "";
            Word newWord = new Word();

            if(target.charAt(0) == '@') {
                target = target.substring(1);
                newWord.setWord_target(target);
                a = file.nextLine();
                if (empty(a)) continue;

                while (a.charAt(0) != '@') {
                    explain = explain + a + '\n';
                    if (!file.hasNextLine()) break;
                    a = file.nextLine();
                    if (empty(a)) break;
                }
                newWord.setWord_explain(explain);
            }
            if (!empty(newWord.getWord_explain()) && !empty(newWord.getWord_target())) {
                Dictionary.list.add(newWord);
            }
        }
    }

    /**
     * tìm kiếm từ.
     */
    public static void dictionaryLookup() {
        Scanner input = new Scanner(System.in);
        String target = input.nextLine();
        for (int i = 0; i < Dictionary.list.size(); i++) {
            if (Dictionary.list.get(i).getWord_target().equals(target)) {
                System.out.println(Dictionary.list.get(i).getWord_target());
                System.out.println(Dictionary.list.get(i).getWord_explain());
            }
        }
    }

    /**
     * kiểm tra kết quả.
     */
    public static void main(String[] args) throws FileNotFoundException {
        DictionaryManagement.insertFromFile();
        //System.out.println(Dictionary.list.get(0).getWord_target());
        //System.out.println(Dictionary.list.get(0).getWord_explain());
        //DictionaryManagement.insertFromCommandline();
        DictionaryManagement.dictionaryLookup();
        ///System.out.println(Dictionary.list.get(Dictionary.list.size() - 1).getWord_target());
        //System.out.println(Dictionary.list.get(Dictionary.list.size() - 1).getWord_explain());
    }
}
