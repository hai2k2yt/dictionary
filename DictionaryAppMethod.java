package Dictionary;

import java.util.Scanner;

public class DictionaryAppMethod {

    /**
     * tìm kiếm từ
     * chạy trên java swing
     * input: word_target
     * @return: word_explain
     */
    public static String translate(String target) {
        for (int i = 0; i < Dictionary.list.size(); i++) {
            if (Dictionary.list.get(i).getWord_target().equals(target)) {   //find exactly word
                return Dictionary.list.get(i).getWord_explain();            //return explain_word
            }
        }

        //can't find word
        return "The target word does not exist!";
    }

    /**
     * tra danh sach tu
     * chay tren java swing
     * input: word_target
     * @return: list_word
     */
    public static String search(String search) {
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

    public static void main(String[] args) {
        DictionaryManagement.insertFromFile();
        add("a b","test1");
        add("zzzzzz","test2");
    }
}
