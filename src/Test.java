import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// Test
// Test2
public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] temp = br.readLine().toCharArray();
        for (int i = temp.length - 1; i >= 0; i--){
            System.out.print(temp[i]);
        }
    }
}

