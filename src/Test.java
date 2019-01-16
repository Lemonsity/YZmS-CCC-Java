import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws IOException {
        int[]x = new int[10];
        for (int i = 0; i<10; i++)
            x[i] = 0;
        for (int a : x)
            a = 0;
        for (int a : x)
            System.out.print(a);
    }
}
