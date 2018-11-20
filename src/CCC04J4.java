import java.io.*;
public class CCC04J4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String keyword = br.readLine();
        String original = br.readLine();
        char[] originalCleanup = original.toCharArray();
        for (int i = 0; i < originalCleanup.length; i++) {
            if (!Character.isLetter(originalCleanup[i]))
                originalCleanup[i] = '0';
        }
        original = "";
        for (int i = 0; i < originalCleanup.length; i++) {
            if (originalCleanup[i] != '0')
                original += originalCleanup[i];
        }
        int rows;
        if (original.length() % keyword.length() == 0)
            rows = 1 + original.length() / keyword.length();
        else
            rows = 1 + original.length() / keyword.length() + 1;
        char[][] array = new char[rows][keyword.length()];
        rows = 1;
        array[0] = keyword.toCharArray();
        while (original.length() >= keyword.length()) {
            String temp = original.substring(0, keyword.length());
            array[rows] = temp.toCharArray();
            original = original.substring(keyword.length());
            rows++;
        }
        if (original.length() > 0) {
            for (int i = 0; i < keyword.length(); i++){
                if (i + 1 <= original.length())
                    array[rows][i] = original.charAt(i);
                else
                    array[rows][i] = '0';
            }
        }
        for (int i = 1; i < array.length; i++){
            for (int j = 0; j < array[0].length; j++){
                if (array[i][j] == '0')
                    break;
                else {
                    char x = (char) (((int) array[0][j] - 65 + (int) array[i][j] - 65) % 26 + 65);
                    System.out.print(x);
                }
            }
        }
    }
}
