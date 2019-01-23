import java.io.*;
public class MockCCC19S4 {
    static int a;
    static int b;
    static int c;
    static int d;
    static int[] array = new int[10000000];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        a = Integer.parseInt(temp[0]);
        b = Integer.parseInt(temp[1]);
        c = Integer.parseInt(temp[2]);
        d = Integer.parseInt(temp[3]);
        int q = Integer.parseInt(temp[4]);
        for(int x=0; x < array.length; x++) {
            int val1, val2;
            if(x / a - b <= 0) val1 = 1;
            else val1 = array[x / a - b];
            if(x / c - d <= 0) val2 = 1;
            else val2 = array[x / c - d];
            array[x] = val1 + val2;
        }
        for (int i = 0; i < q; i++) {
            System.out.print(f(Integer.parseInt(br.readLine())) + "\n");
        }
    }
    public static int f(int x) {
        if (x <= 0)
            return 1;
        if (x < array.length - 1)
            return array[x];
        return f(x/a-b) + f(x/c-d);
    }
}
