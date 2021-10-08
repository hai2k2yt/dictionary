public class DictionaryCommandline {
    public static void showAllWord() {
        int dem = 1;
        System.out.println("No" + "     " + "|English" + "      |Vietnamese");
        for (Word word : Dictionary.list) {
            System.out.println(dem + "      |" + word.getWord_target() + "       |" + word.getWord_explain());
            dem++;
        }
    }
}
