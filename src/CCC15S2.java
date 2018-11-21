import java.io.*;
/**********************************************************************
 * Project Name: CCC15S2
 *
 * Author: YZmS Lemonsity
 *
 * Date: Nov 16, 2018
 *
 * Purpose: Solving 2014 CCC S4
 *
 ***********************************************************************
 *  Status: Completed
 *
 */
public class CCC15S2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        int jerseyNum = Integer.parseInt(br.readLine()); // amount of jerseys
        int playerNum = Integer.parseInt(br.readLine()); // amount of players
        String[] sizes = new String[jerseyNum]; // An array of jersey sizes
        for (int i = 0; i < jerseyNum; i++) {
            sizes[i] = br.readLine(); // store all the jersey sizes in an array
        }
        int count = 0; // amount of playing going to be satisfied
        for (int player = 0; player < playerNum; player++) { // for each player input
            String[] temp = br.readLine().split(" ");
            String size = temp[0]; // the size the player want
            int num = Integer.parseInt(temp[1]); // the number the player wants
            if (!sizes[num - 1].equals("T")) { // if the number player want isn't taken
                if (sizes[num - 1].equals("S")
                        && size.equals("S") ) { // if the jersey is small, and the player wants small
                    sizes[num - 1] = "T";
                    count++; // add one to satisfied
                }
                else if (sizes[num - 1].equals("M")
                        && (size.equals("S")
                        || size.equals("M"))) { // if the jersey is medium, and the player wants small / medium
                    sizes[num - 1] = "T";
                    count++; // add one to satisfied
                }
                else if (sizes[num - 1].equals("L")
                        && (size.equals("S")
                        || size.equals("M")
                        || size.equals("L"))) { // if the jersey is large, and the player wants small / medium / large
                    sizes[num - 1] = "T";
                    count++; // add one to satisfied
                }
            }
        }
        System.out.println(count); // the amount of player satisfied
    }
}