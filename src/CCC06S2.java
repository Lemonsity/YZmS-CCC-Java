import java.io.*;
import java.util.HashMap;
import java.util.Map;
/***********************************************************************
 * Project Name: CCC06S2
 *
 * Author: YZmS Lemonsity
 *
 * Date: Nov 24, 2018
 *
 * Purpose: Solving 2006 CCC S2
 *
 ***********************************************************************
 *  Status: Completed
 *
 */
public class CCC06S2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String plain = br.readLine(); // plain text
        String cipher1 = br.readLine(); // cipher text for the first plain text
        String cipher2; // second cipher text
        Map<Character, Character> map = new HashMap<>(); // map, Key is the real text, Value is the cipher text
        Map<Character, Character> mapReverse = new HashMap<>(); // the first map, but now each available cipher is the Key, and the real text is the Value
        for (int i = 0; i < plain.length(); i++) {
            if (!map.containsKey(plain.charAt(i))) // if first map still don't have the real text at index i in keyset
                map.put(plain.charAt(i), cipher1.charAt(i)); // add the new occurring real text to the keyset, along with the cipher text that matches
        }
        for (Character key : map.keySet()){
            mapReverse.put(map.get(key), key); // Change cipher into key, and real into value
        }
        cipher2 = br.readLine();
        for (int i = 0; i < cipher2.length(); i++) { // for the second cipher text
            if (mapReverse.containsKey(cipher2.charAt(i))) // if the ciphered character appeared in the second map
                System.out.print(mapReverse.get(cipher2.charAt(i))); // print the matching real character
            else
                System.out.print("."); // print . as place holder
        }
        System.out.println(); // formatting
    }
}
