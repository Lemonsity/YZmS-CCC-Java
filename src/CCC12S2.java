import java.io.*;
/***********************************************************************
 * Project Name: CCC12S2
 *
 * Author: YZmS Lemonsity
 *
 * Date: Nov 17, 2018
 *
 * Purpose: Solving 2012 CCC S2
 *
 ***********************************************************************
 *  Status: Completed
 *
 */
public class CCC12S2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] characters = br.readLine().split(""); // Split the input into characters.
        int total = 0;
        for (int i = 0; i < characters.length / 2; i++){ // start fromt he back of the array
            int a = Integer.parseInt(characters[characters.length - i * 2 - 2]); // obtain the arabic integer
            String r = characters[characters.length - i * 2 - 1]; // obtain the roman letter
            if (i == 0){
                total += a * transfer(r); // The last 2 character are definitely adding ot the total
            }
            else{
                // if the roman letter closer to the back have greater value, the the one before have to be subtracted
                if (transfer(r) < transfer(characters[characters.length - i * 2 + 1]))
                    total -= a * transfer(r);
                // otherwise add to total
                else
                    total += a * transfer(r);
            }
        }
        System.out.println(total);
    }
    // Turn roman into arabic
    public static int transfer(String r){
        if(r.equals("I"))
            return 1;
        else if (r.equals("V"))
            return 5;
        else if (r.equals("X"))
            return 10;
        else if (r.equals("L"))
            return 50;
        else if (r.equals("C"))
            return 100;
        else if (r.equals("D"))
            return 500;
        return 1000;
    }
}
