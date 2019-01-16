import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arraySize = Integer.parseInt(br.readLine());
        int[] array = new int[arraySize + 1];
        array[0] = 0;
        String[] temp = br.readLine().split(" ");
        for (int i = 1; i <= arraySize; i++) {
            array[i] = array[i - 1] + Integer.parseInt(temp[i - 1]);
        }
        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            System.out.print(array[b] - array[a - 1] + "\n");
        }
    }
}
