import java.io.*;
public class MockCCC19S1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        double sum = 0;
        for (int i = 0; i < a; i++) {
            sum += Integer.parseInt(br.readLine());
        }
        sum = sum * 1.0 / a;
        System.out.printf("%.1f\n", sum);
    }
}
