import java.io.*;
/***********************************************************************
 * Project Name: CCC06S1
 *
 * Author: YZmS Lemonsity
 *
 * Date: Nov 28, 2018
 *
 * Purpose: Solving 2006 CCC S1
 *
 ***********************************************************************
 *  Status: Completed
 *
 */
public class CCC06S1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        char[] mother = br.readLine().toCharArray(); // mother's gene
        char[] father = br.readLine().toCharArray(); // father's gene
        int childrenNum = Integer.parseInt(br.readLine()); // amount of children
        for (int i = 0; i < childrenNum; i++){
            boolean check = true; // assume the children is a legitmate children.
            char[] child = br.readLine().toCharArray(); // the children's gene
            for (int index = 0; index < 5; index++){
                char[] possibilities = new char[4]; // the array that stores all possible gene produced by the given parents
                // Since char variables can be cast into int variables, we cast mother and fathers gene into int
                // Given the same letter, uppercase letters all have a smaller int value than lowercase letters
                // So, after casting into int, the gene with smaller int value is the one that is uppercase
                // We utilize Math.min
                // if both are uppercase or lowercase, then the min of the two int value is the possible outcome
                // if on is uppercase and oen is lowercase, Math.min will return the int value of the uppercase letter, which is the "dominant" one
                possibilities[0] = (char)(Math.min((int)mother[index * 2], (int)father[index * 2])); // mother 1, father 1
                possibilities[1] = (char)(Math.min((int)mother[index * 2], (int)father[index * 2 + 1])); // mother 1, father 2
                possibilities[2] = (char)(Math.min((int)mother[index * 2 + 1], (int)father[index * 2])); // mother 2, father 1
                possibilities[3] = (char)(Math.min((int)mother[index * 2 + 1], (int)father[index * 2 + 1])); // mother 2, father 2
                if (possibilities[0] != child[index]
                        && possibilities[1] != child[index]
                        && possibilities[2] != child[index]
                        && possibilities[3] != child[index]){ // if the child's gene doesn't equal to any of the possibility, it is not their child
                    check = false; // the child is not legit
                    break; // no longer need to check for the rest of gene
                }
            }
            if (check) // child is legit
                System.out.print("Possible baby.\n");
            else // child is not legit
                System.out.print("Not their baby!\n");
        }
    }
}
