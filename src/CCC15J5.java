import java.io.*;
public class CCC15J5 {
    static int[][] dp = new int[251][251];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pie =  Integer.parseInt(br.readLine());
        int people = Integer.parseInt(br.readLine());
        System.out.print(r(pie - people, people));
    }
    static int r(int pie, int people) {
        if (pie <0) return 0;
        if (pie == 0 || people == 1) return 1;
        if (dp[pie][people] > 0) return dp[pie][people];
        return dp[pie][people] = r(pie, people - 1) + r(pie - people, people);
    }
}
