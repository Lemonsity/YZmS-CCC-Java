import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// Test
// Test2
public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] test = "A1+A5+t6".split("\\+");
        for (String v : test)
            System.out.print(v + "\n");
    }
}

