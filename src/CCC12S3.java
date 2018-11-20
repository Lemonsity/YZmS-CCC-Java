import java.io.*;
import java.util.*;
/***********************************************************************
 * Project Name: CCC12S3
 *
 * Author: YZmS Lemonsity
 *
 * Date: Nov 18, 2018
 *
 * Purpose: Solving 2012 CCC S3
 *
 ***********************************************************************
 *  Status: Work in progress
 *
 *  - Took in user's input
 *  - Hash Map that have the sensor number display as key, and frequency as value
 */
public class CCC12S3 {
    public static void main(String[] args) throws IOException{
        Map<Integer, Integer> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int amount = Integer.parseInt(br.readLine());
        for (int i = 1; i <= amount; i++){
            int input = Integer.parseInt(br.readLine());
            if (map.containsKey(input))
                map.put(input, map.get(input) + 1);
            else
                map.put(input, 1);
        }
        List<Integer> array = new ArrayList<>(map.values());
        Collections.sort(array);
    }
}