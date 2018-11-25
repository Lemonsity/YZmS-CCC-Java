import java.io.*;
/***********************************************************************
 * Project Name: CCC05S1
 *
 * Author: YZmS Lemonsity
 *
 * Date: Nov 24, 2018
 *
 * Purpose: Solving 2005 CCC S2
 *
 ***********************************************************************
 *  Status: Completed
 *
 */
public class CCC05S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp2 = br.readLine().split(" ");
        // screen size
        int xWidth = Integer.parseInt(temp2[0]);
        int yHeight = Integer.parseInt(temp2[1]);
        // initial place
        int x = 0;
        int y = 0;
        // amount move
        int xMove;
        int yMove;
        do{
            String[] temp = br.readLine().split(" "); // take user input
            // parse input into int
            xMove = Integer.parseInt(temp[0]);
            yMove = Integer.parseInt(temp[1]);
            x += xMove; // update x
            y += yMove; // update y

            // if out of bounds, bring it back to the edge
            if (x >= xWidth)
                x = xWidth;
            else if (x <= 0)
                x = 0;
            if (y >= yHeight)
                y = yHeight;
            else if (y <= 0)
                y = 0;

            if (!(xMove == 0 && yMove == 0)){ // if user didn't move mouse, output final place
                System.out.printf("%d %d\n", x, y);
            }
        }while (!(xMove == 0 && yMove == 0)); // if user did not enter (0, 0), ask for more coordinate
    }
}
