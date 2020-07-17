import java.io.*;
public class CCC19S2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] primes = new boolean[2000005];
        for (int i = 0; i < 2000005; i++)
            primes[i] = true;
        for (int i = 2; i < 2000005; i++) {
            if (primes[i]) {
                for (int j = i * 2; j < 2000005; j += i)
                    primes[j] = false;
            }
        }
        int Q = Integer.parseInt(br.readLine());
        for (int q = 0; q < Q; q++) {
            int toSearch = Integer.parseInt(br.readLine());
            for (int i = 2; i < 1000000; i++) {
                if (primes[i] && primes[toSearch * 2 - i]) {
                    System.out.print(i + " " + (toSearch * 2 - i) + "\n");
                    break;
                }
            }
        }
    }
}