package dictionary;

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

    /** Test.
     *
     * @param args
     */
    public static void main(String[] args) {
        dictionaryBasic();
    }
}
