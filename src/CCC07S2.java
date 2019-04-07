import java.io.*;
/***********************************************************************
 * Project Name: CCC07S2
 *
 * Author: YZmS Lemonsity
 *
 * Date: Dec 11, 2018
 *
 * Purpose: Solving 2007 CCC S2
 *
 ***********************************************************************
 *  Status: Completed
 *
 */
public class CCC07S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int boxNum = Integer.parseInt(br.readLine());
        int[][] boxes = new int[boxNum][4]; // Array storing the information of each box
        for (int i = 0; i < boxNum; i++) {
            String[] temp = br.readLine().split(" ");
            boxes[i][0] = Integer.parseInt(temp[0]); // side 1
            boxes[i][1] = Integer.parseInt(temp[1]); // side 2
            boxes[i][2] = Integer.parseInt(temp[2]); // side 3
            boxes[i][3] = boxes[i][0] * boxes[i][1] * boxes[i][2]; // volume of the box
        }
        int itemNum = Integer.parseInt(br.readLine()); // amount of items
        for (int i = 0; i < itemNum; i++) { // for each item
            String[] temp = br.readLine().split(" ");
            int x = Integer.parseInt(temp[0]); // side 1
            int y = Integer.parseInt(temp[1]); // side 2
            int z = Integer.parseInt(temp[2]); // side 3
            int volume = x * y * z; // the volume of the item
            boolean boxAvailable = false; // check if a any box will fit the item
            Integer smallestVolume = null; // the volume of the smallest box that can fit the item
            for (int j = 0; j < boxNum; j++) { // go through all the boxes
                if (boxes[j][3] >= volume) { // If the box have larger volume

                    // We go through every possible rotation of the item
                    // If all dimensions of the item are smaller / equal to the box

                    // Know this part was hard coded, since I see no reason to deal with complicated math

                    if ((x <= boxes[j][0] && y <= boxes[j][1] && z <= boxes[j][2])
                            || (x <= boxes[j][0] && z <= boxes[j][1] && y <= boxes[j][2])
                            || (y <= boxes[j][0] && x <= boxes[j][1] && z <= boxes[j][2])
                            || (y <= boxes[j][0] && z <= boxes[j][1] && x <= boxes[j][2])
                            || (z <= boxes[j][0] && y <= boxes[j][1] && x <= boxes[j][2])
                            || (z <= boxes[j][0] && x <= boxes[j][1] && y <= boxes[j][2])) {
                        if (smallestVolume == null) // If it is the first box that can fit the item
                            smallestVolume = boxes[j][3]; // smallest volume is the first volume
                        else {
                            if (boxes[j][3] < smallestVolume) // check for the smaller volume
                                smallestVolume = boxes[j][3];
                        }
                        boxAvailable = true; // a box has been found
                    }
                }
            }
            // Output
            if (!boxAvailable)
                System.out.print("Item does not fit.\n");
            else
                System.out.print(smallestVolume + "\n");
        }
    }
}
