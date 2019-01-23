import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
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
 * testing faster algorithm
 */
public class CCC04S3 {
    private static Map<String, String> table = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // take user input
        for (char a = 'A'; a <= 'J'; a++) {
            String[] temp = br.readLine().split(" ");
            for (int i = 0; i < 9; i++) {
                table.put(a + "" + (i + 1), temp[i]);
            }
        }

        // for each cell
        for (String key : table.keySet()) {
            String value = table.get(key);
        }

    }

    public static String calculate(String cell, ArrayList cellsBeen) {
        if (isInteger(table.get(cell))) {
            return table.get(cell);
        }
        String[] requires = separateValue(table.get(cell));
        int sum = 0;
        boolean check = true;
        for (String toCell : requires) {
            if (cellsBeen.contains(toCell) || table.get(toCell).equals("*")) {
                table.put(cell, "*");
                check = false;
                break;
            }


        }
        if (check)
            return "x";
        else
            return "*";
    }

    public static String[] separateValue(String value) {
        return value.split("\\+");
    }

    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
