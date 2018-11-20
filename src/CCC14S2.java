import java.io.*;
import java.util.ArrayList;

/***********************************************************************
 * Project Name: CCC14S2
 *
 * Author: YZmS Lemonsity
 *
 * Date: Nov 16, 2018
 *
 * Purpose: Solving 2014 CCC S2
 *
 ***********************************************************************
 *  Status: Completed
 *
 */
public class CCC14S2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine()); // Input for how mnay people
        ArrayList<String> one = new ArrayList<>(); // Container for first list of people
        ArrayList<String> two = new ArrayList<>(); // Container for second list of people;
        String[] one2 = br.readLine().split(" "); // Array storing order of people of first list
        String[] two2 = br.readLine().split(" "); // Array storing order of people in second list
        for(int i = 0; i < num; i++){ // Transfer two String[] to ArrayList
            one.add(one2[i]);
            two.add(two2[i]);
        }
        boolean check = true; // Assume the list is "good"
        for (int i = 0; i < num; i++){
            String first = one.get(i); // name of index i in first list
            String second = two.get(i); // name of index i in second list
            String third = two.get(one.indexOf(second)); // name in the second list that corresponding to the name of index i in second list
            if (first.equals(second) // If first and second are same, person is matched with themselves
                    || !first.equals(third)){ // If first and third are not the same, the second person is matched with two different people
                check = false; // list is bad
                break; // break out of loop to save time
            }
        }
        System.out.println(check ? "good" : "bad");
    }
}
