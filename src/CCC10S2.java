import java.io.*;
import java.util.HashMap;
/***********************************************************************
 * Project Name: CCC10S1
 *
 * Author: YZmS Lemonsity
 *
 * Date: Dec 18, 2018
 *
 * Purpose: Solving 2010 CCC S1
 *
 ***********************************************************************
 *  Status: Completed
 *
 *  We are lucky that the binary of each letter are all "prefix-free"
 *  So as soon as a match is found, we convert it to a letter
 *
 *  Prefix-free is so important because if it is not, we run into problems like 0, 00 and 000
 *  What happen when the binary is 0000? Too many possibilities are possible
 *
 *  Being prefix-free, no letter have binary that is the combination of other.
 *  So Whenever we found a matching short binary sequence, we know it could not be the prefix of a longer binary
 *  Thus we can safely transfer the sequence into the letter it represent
 *  After that letter and translated, we can safely move onto next index
 *
 *  Implementation is simple, but logic is little complicated
 */
public class CCC10S2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int amount = Integer.parseInt(br.readLine());
        HashMap<String, String> data = new HashMap<>(); // Database of the letter each binary associate with
        for (int i = 0; i < amount; i++) {
            String[] input = br.readLine().split(" ");
            data.put(input[1], input[0]); // Store the relationship
        }
        String binary = br.readLine();
        int start = 0; // The first substring start at index 0
        // The end of the substring start at 0 too
        // But because the method, we need to enter the index value + 1, thus the loop start at 1
        for (int end = 1; end <= binary.length(); end++) {
            if (data.containsKey(binary.substring(start, end))) { // If substring match a binary sequence in our database
                System.out.print(data.get(binary.substring(start, end))); // Print letter related
                start = end; // Update the starting index of substring to the index right after the end of previous substring
            }
        }
        System.out.print("\n");
    }
}
