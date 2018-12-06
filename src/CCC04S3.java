import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**********************************************************************
 * Project Name: CCC04S3
 *
 * Author: YZmS Lemonsity
 *
 * Date: Dec 5, 2018
 *
 * Purpose: Solving 2004 CCC S3
 *
 ***********************************************************************
 *  Status: Work in Progress
 *
 *  Works, but need faster algorithm
 *
 */
public class CCC04S3 {
    private static Map<String, String> table = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (char a = 'A'; a <= 'J'; a++) {
            String[] temp = br.readLine().split(" ");
            for (int i = 0; i < 9; i++) {
                table.put(a + "" + (i + 1), temp[i]);
            }
        }

    }
}
