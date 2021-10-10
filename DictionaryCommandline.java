import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

public class DictionaryCommandline {
    /** show all word.
     *
     */
    public static void showAllWord() {
        int dem = 1;
        System.out.println("No" + "         " + "|English" + "          |Vietnamese");
        for (Word word : Dictionary.list) {
            System.out.println(dem + "          |" + word.getWord_target() + "              |" + word.getWord_explain());
            dem++;
        }
    }

    /** dictionaryBasic.
     *
     */
    public static void dictionaryBasic() {
        DictionaryManagement.insertFromCommandline();
        showAllWord();
    }

    /** dictionaryAdvanced.
     *
     */
    public static void dictionaryAdvanced() throws FileNotFoundException {
        DictionaryManagement.insertFromFile();
        showAllWord();
        DictionaryManagement.dictionaryLookup();
    }

    /** dictionarySearcher.
     *
     */
    public static void dictionarySearcher() {
        Scanner input = new Scanner(System.in);
        String target = input.nextLine();
        for (Word word : Dictionary.list) {
            if (word.getWord_target().length() < target.length()) {
                continue;
            }
            boolean flag = true;
            char x;
            for (int i = 0; i < target.length(); i++) {
                x = word.getWord_target().charAt(i);
                if (target.charAt(i) != x) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(word.getWord_target());
                System.out.println(word.getWord_explain());
            }
        }
    }

    /** Test.
     *
     * @param args
     */
    public static void main(String[] args) {
        DictionaryManagement.insertFromFile();
        dictionarySearcher();
    }
}
