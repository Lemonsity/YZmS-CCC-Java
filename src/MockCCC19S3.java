import java.io.*;
import java.util.StringTokenizer;

public class MockCCC19S3 {
    static int X;
    static int Y;
    static int xe;
    static int ye;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        int numWind = Integer.parseInt(st.nextToken());
        map = new int[X + 1][Y + 1];
        st = new StringTokenizer(br.readLine());
        int xs = Integer.parseInt(st.nextToken());
        int ys = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        xe = Integer.parseInt(st.nextToken());
        ye = Integer.parseInt(st.nextToken());
        for (int i = 0; i < numWind; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = -1;
        }
    }
    public static int shortest(int x, int y, int xs, int ys) {
        if (x > X || y > Y)
            return -1;
        double slope = (ys * 1.0) / (xs * 1.0);
        for (int i = x; i < x + xs; i++) {

        }
        return x;
    }
}
