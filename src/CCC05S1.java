import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CCC05S1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int amount = Integer.parseInt(br.readLine());
        for (int i = 0; i < amount; i++) {
            String input = br.readLine();
            int[] finalOutput = new int[10];
            int counter = 0;
            int index = 0;
            while (counter < 10) {
                if (input.charAt(index) != '-') {
                    int temp = (int) input.charAt(index);
                    if (temp >= 48 && temp <= 57) {
                        finalOutput[counter] = temp - 48;
                    } else {
                        finalOutput[counter] = letter(temp);
                    }
                    counter++;
                }
                index++;
            }
            for (int j = 0; j < 10; j++){
                System.out.print(finalOutput[j]);
                if (j == 2 || j == 5)
                    System.out.print('-');
            }
            System.out.print("\n");
        }
    }

    public static int letter(int value) {
        if (value >= 65 && value <= 67)
            return 2;
        else if (value >= 68 && value <= 70)
            return 3;
        else if (value >= 71 && value <= 73)
            return 4;
        else if (value >= 74 && value <= 76)
            return 5;
        else if (value >= 77 && value <= 79)
            return 6;
        else if (value >= 80 && value <= 82)
            return 7;
        else if (value >= 83 && value <= 85)
            return 8;
        return 9;
    }
}
