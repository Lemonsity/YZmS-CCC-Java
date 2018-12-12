import java.io.*;
/***********************************************************************
 * Project Name: CCC08S1
 *
 * Author: YZmS Lemonsity
 *
 * Date: Dec 12, 2018
 *
 * Purpose: Solving 2008 CCC S1
 *
 ***********************************************************************
 *  Status: Completed
 *
 */
public class CCC08S1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" "); // User input
        String city = input[0]; // set city to the first city entered
        int temperature = Integer.parseInt(input[1]); // set temperature to the first temperature entered
        while (!input[0].equals("Waterloo")) { // while the city entered isn't Waterloo
            input = br.readLine().split(" "); // enter new city and temperature
            if (Integer.parseInt(input[1]) < temperature) { // if the new city is colder
                // update city and coldest temperature
                city = input[0];
                temperature = Integer.parseInt(input[1]);
            }
        }
        // output city
        System.out.print(city + "\n");
    }
}
