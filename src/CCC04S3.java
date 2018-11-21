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
    public static Map<String, String> map = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (char character = 'A'; character <= 'J'; character++){
            String[] temp = br.readLine().split(" ");
            for (int i = 1; i <= 9; i++){
                map.put(String.valueOf(character) + String.valueOf(i), temp[i - 1]);
            }
        }
        for (char character = 'A'; character <= 'J'; character++){
            for (int i = 1; i <= 9; i++){
                if (!isInteger(map.get(String.valueOf(character) + String.valueOf(i)))){

                }
            }
        }
    }
    public static boolean isInteger(String value){
        boolean check = false;
        try{
            Integer.parseInt(value);
            check = true;
        } catch (Exception e){

        }
        return check;
    }
}
