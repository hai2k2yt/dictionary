package Dictionary;

import java.util.Scanner;

public class DictionaryAppMethod {
    /**
     * tìm kiếm từ
     * chạy trên java swing
     */

    public static String dictionaryLookup(String target) {
        for (int i = 0; i < Dictionary.list.size(); i++) {
            if (Dictionary.list.get(i).getWord_target().equals(target)) {
                return Dictionary.list.get(i).getWord_explain();
            }
        }
        return "The target word does not exist!";
    }

    /**
     * tra danh sach tu
     * chay tren java swing
     */
    public static String dictionarySearcher(String search) {
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
        return output;
    }
}
