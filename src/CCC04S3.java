import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**********************************************************************
 * Project Name: CCC04S3
 *
 * Author: YZmS Lemonsity
 *
 * Date: Nov 20, 2018
 *
 * Purpose: Solving 2004 CCC S3
 *
 ***********************************************************************
 *  Status: Work in Progress
 *
 */
public class CCC04S3 {
    public static Map<String, String> table = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] array;
        for (char i = 'A'; i <= 'J'; i++) {
            array = br.readLine().split(" ");
            for (int j = 1; j <= 9; j++) {
                table.put((String.valueOf(i) + String.valueOf(j)), array[j - 1] + "");
            }
        }
        for (char a = 'A'; a <= 'J'; a++) {
            for (int i = 1; i <= 9; i++) {
                String key = String.valueOf(a) + String.valueOf(i);
                if (isInteger(table.get(key)))
                    System.out.print(table.get(key));
                else if (table.get(key).equals("*"))
                    System.out.print(table.get(key));
                else {
                    String sum = add(table.get(key), key);
                    String[] adding = sum.split(" ");
                    int intSum = 0;
                    boolean check = true; // check if the adders contain *
                    for (int j = 0; j < adding.length; j++) {
                        if (!adding[j].equals("*"))
                            intSum += Integer.parseInt(adding[j]);
                        else {
                            check = false;
                            break;
                        }
                    }
                    if (check)
                        System.out.print(intSum);
                    else
                        System.out.print("*");
                }
                if (i != 9)
                    System.out.print(" ");
                else
                    System.out.print("\n");

            }
        }
    }
    public static String add(String value, String cell) {
        if (isInteger(value))
            return value + " ";
        if (value.equals("*") || value.equals(cell))
            return "* ";
        String[] adders = value.split("\\+");
        String sum = "";
        for (int i = 0; i < adders.length; i++) {
            sum += add(table.get(adders[i]), adders[i]);
        }
        return sum;
    }

    public static boolean isInteger(String text) {
        boolean check = false;
        try {
            Integer.parseInt(text);
            check = true;
        } catch (Exception e) {

        }
        return check;
    }
}
