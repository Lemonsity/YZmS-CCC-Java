import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws IOException {
        String[] array = "Test+THY".split("\\+");
        for (String v : array)
            System.out.print(v + "\n");
    }
}
