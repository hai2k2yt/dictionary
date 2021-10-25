package Dictionary;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DictionaryAppMethod {

    public static String root_file_name = "src/Dictionary/dictionary.txt";

    /**
     * tìm chỉ số của từ
     * input: word_target
     * @return: word_index(không tìm được return -1)
     */
    private static int find(String target) {
        for (int i = 0; i < Dictionary.list.size(); i++) {
            if (Dictionary.list.get(i).getWord_target().equals(target)) {   //find exactly word
                return i;                                                   //return explain_word
            }
        }
        return -1;                                                          //can't find word
    }

    /**
     * tìm kiếm từ
     * chạy trên java swing
     * input: word_target
     * @return: word_explain
     */
    public static String translate(String target) {
        int index = find(target);
        if(index == -1) return "The target word does not exist!";       //can't find word
        return Dictionary.list.get(index).getWord_explain();
    }

    /**
     * tra danh sach tu
     * chay tren java swing
     * input: word_target
     * @return: list_word
     */
    public static String search(String search) {
        if (search.equals("")) return "No words";
        String output = "";
        for (Word word : Dictionary.list) {
            if (word.getWord_target().length() < search.length()) {
                continue;
            }
            boolean flag = true;
            char x;
            for (int i = 0; i < search.length(); i++) {
                x = word.getWord_target().charAt(i);
                if (search.charAt(i) != x) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                output += (word.getWord_target() + '\n');
            }
        }
        if(output.equals("")) return "No words";    //if no word selected

        return output;
    }

    /**
     * them tu
     * chay tren java swing
     * input: word_target + word_explain
     * @return: status of add word(success, failed)
     */
    public static String add(String target, String explain) {
        for(int i = 0; i < Dictionary.list.size(); i++) {
            int compare = target.compareTo(Dictionary.list.get(i).getWord_target());
            if(compare == 0) {          //existed
                return "Word existed!";
            }
            else if(compare > 0) {      //bigger than word[i]
                continue;
            }
            else {                      //smaller than word[i]
                Word new_word = new Word();
                new_word.setWord_target(target);
                new_word.setWord_explain(explain);
                Dictionary.list.add(i,new_word);
                return "Add success!";
            }
        }

        //bigger than all words
        Word new_word = new Word();
        new_word.setWord_target(target);
        new_word.setWord_explain(explain);
        Dictionary.list.add(new_word);


        return "Add success!";
    }

    /**
     * xóa từ
     * input: word_target
     * @return: status of delete(success,not exist)
     */
    public static String delete(String target) {
        int index = find(target);
        if(index == -1) {
            return "The delete word does not exist!";
        }
        Dictionary.list.remove(index);
        return "Delete success!";
    }

    /**
     * chỉnh sửa từ
     * input:
     *  -target: từ cần sửa
     *  -explain: nghĩa mới của từ
     * @return: status of change(success, not exist)
     */
    public static String change(String target, String explain) {
        int index = find(target);
        if(index == -1) {       //khong tim thay tu can sua
            return "The change word does not exist!";
        }
        Dictionary.list.get(index).setWord_explain(explain);
        return "Change success!";
    }

    public static String save() {
        try {
            File f = new File(root_file_name);
            FileWriter fw = new FileWriter(f);                          //chế độ ghi file + xóa file cũ
            BufferedWriter br = new BufferedWriter(fw);

            for (int i = 0; i < Dictionary.list.size(); i++) {          //đưa dữ liệu từ dictionary vào file
                br.write('@' + Dictionary.list.get(i).getWord_target() + '\n');
                br.write(Dictionary.list.get(i).getWord_explain() + '\n');
            }
            br.close();
            fw.close();
            return "Saved success!";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Saved error!";
    }

    public static void main(String[] args) {
        DictionaryManagement.insertFromFile();
        delete("a b");
        save();
    }
}