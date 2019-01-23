import java.io.*;
public class MockCCC19S2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[][] table = new int[size][size];

        for (int i = 0; i < size; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < size; j++) {
                table[i][j] = Integer.parseInt(temp[j]);
            }
        }

        int start = 0;
        int top = 0;
        boolean check = true;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (table[i][j] != start + 1) {
                    top = i;
                    check = false;
                    break;
                }
                start = table[i][j];
            }
            if (!check)
                break;
        }
        start = size * size + 1;
        int bottom = 0;
        check = true;
        for (int i = size - 1; i >= 0; i--) {
            for (int j = size - 1; j >= 0; j--) {
                if (table[i][j] != start - 1) {
                    bottom = i;
                    check = false;
                    break;
                }
                start = table[i][j];
            }
            if (!check)
                break;
        }
        System.out.print(bottom - top + 1 + "\n");
    }
}
