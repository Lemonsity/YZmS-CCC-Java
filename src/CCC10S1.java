import java.io.*;
public class CCC10S1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = null;
        String second = null;
        int firstValue = 0;
        int secondValue = 0;
        int amount = Integer.parseInt(br.readLine());
        for (int i = 0; i < amount; i++) {
            String[] input = br.readLine().split(" ");
            int R = Integer.parseInt(input[1]);
            int S = Integer.parseInt(input[2]);
            int D = Integer.parseInt(input[3]);
            if (first == null) {
                first = input[0];
                firstValue = 2 * R + 3 * S + D;
                continue;
            }
            if (2 * R + 3 * S + D > firstValue) {
                second = first;
                secondValue = firstValue;
                first = input[0];
                firstValue = 2 * R + 3 * S + D;
            }
            else if (2 * R + 3 * S + D == firstValue) {
                if (input[0].length() < first.length() || first.compareTo(input[0]) >= 0) {
                    second = first;
                    secondValue = firstValue;
                    first = input[0];
                }
                else if (first.compareTo(input[0]) < 0) {
                    if (input[0].length() < second.length() || second.compareTo(input[0]) >= 0) {
                        second = input[0];
                        secondValue = 2 * R + 3 * S + D;
                    }
                }
            }
            else if (2 * R + 3 * S + D > secondValue) {
                second = input[0];
                secondValue = 2 * R + 3 * S + D;
            }
            else if (2 * R + 3 * S + D == secondValue) {
                if (input[0].length() < first.length() || second.compareTo(input[0]) > 0) {
                    second = input[0];
                    secondValue = 2 * R + 3 * S + D;
                }
            }
        }
        if (first != null)
            System.out.print(first + "\n");
        if (second != null)
            System.out.print(second + "\n");
    }
}
