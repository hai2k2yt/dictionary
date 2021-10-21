import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class DictionaryManagement {
    public static String path = "D:\\LTHDT\\DictionaryDevelopment\\src\\dictionary\\dictionary.txt";
    /**
     * kiểm tra xem string có rỗng.
     */
    public static boolean empty( final String s ) {
        return s == null || s.trim().isEmpty();
    }

    /**
     * hàm nhập từ commandline.
     */
    public static boolean insertFromCommandline() {
        Scanner input = new Scanner(System.in);
        Word newWord = new Word();
        String target = input.nextLine();
        for (int i = 0; i < Dictionary.list.size(); i++) {
            if (Dictionary.list.get(i).getWord_target().equals(target)) {
                return false;
            }
        }
        String explain = input.nextLine();
        newWord.setWord_target(target);
        newWord.setWord_explain(explain);
        Dictionary.list.add(newWord);
        return true;
    }

    /**
     * thêm từ vào file.
     */
    public static String dictionaryExportToFile() throws IOException {
        if(!DictionaryManagement.insertFromCommandline()) {
            return "Fail";
        }
        File f = new File(path);
        FileWriter fw = new FileWriter(f, true);
        BufferedWriter br = new BufferedWriter(fw);
        int n = Dictionary.list.size() - 1;

        br.write('\n');
        br.write('@' + Dictionary.list.get(n).getWord_target() + '\n');
        br.write(Dictionary.list.get(n).getWord_explain());
        br.close();
        fw.close();
        return "Success";
    }

    /**
     * xóa từ khỏi file.
     */
    public static String deleteWord() throws IOException {
        Scanner input = new Scanner(System.in);
        int n = DictionaryManagement.dictionaryLookup();
        if (n != 1) {
            Dictionary.list.remove(n);
            File f = new File(path);

            PrintWriter writer = new PrintWriter(f);
            writer.print("");

            FileWriter fw = new FileWriter(f, true);
            BufferedWriter br = new BufferedWriter(fw);

            br.write('@' + Dictionary.list.get(0).getWord_target() + '\n');
            br.write(Dictionary.list.get(0).getWord_explain());

            for (int i = 1; i < Dictionary.list.size(); i++) {
                br.write('\n');
                br.write('@' + Dictionary.list.get(i).getWord_target() + '\n');
                br.write(Dictionary.list.get(i).getWord_explain());
            }
            br.close();
            writer.close();
            return "Success";
        }
        return "Fail";
    }

    /**
     * hàm nhập từ file.
     */
    public static void insertFromFile() throws FileNotFoundException {
        File text = new File(path);
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
    public static int dictionaryLookup() {
        Scanner input = new Scanner(System.in);
        String target = input.nextLine();
        int a = -1;
        for (int i = 0; i < Dictionary.list.size(); i++) {
            if (Dictionary.list.get(i).getWord_target().equals(target)) {
                a = i;
                break;
            }
        }
        return a;
    }

    /**
     * kiểm tra kết quả.
     */
    public static void main(String[] args) throws IOException {
        DictionaryManagement.insertFromFile();
        //DictionaryManagement.insertFromCommandline();
        //int n = DictionaryManagement.dictionaryLookup();
        //System.out.println(DictionaryManagement.dictionaryExportToFile());
        System.out.println(DictionaryManagement.deleteWord());
    }
}
