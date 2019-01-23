import java.io.*;
/**********************************************************************
 * Project Name: CCC05S5
 *
 * Author: YZmS Lemonsity
 *
 * Date: December 9, 2018
 *
 * Purpose: Solving 2005 CCC S5
 *
 ***********************************************************************
 *  Status: On hold
 *
 *  Currently the problem is done in binary tree
 *  Unfortunately the solution is too slow.
 *  There is also another flaw: There cannot be repeating score
 *
 *  Friends introduced me to binary indexed tree, which they say works better
 */
public class CCC05S5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int amount = Integer.parseInt(br.readLine());
        Tree t = new Tree();
        long sum = 0;
        for (int i = 0; i < amount;  i++) {
            sum += t.add(Integer.parseInt(br.readLine())) + 1;
        }
        double fin = Math.round(((double)(sum) / amount) * 100.0) / 100.0;
        System.out.printf("%.2f", fin);
    }
}


class Node {
    Node left, right;
    int value;
    int rank;
    public Node(int value){
        this.value = value;
        left = null;
        right = null;
        rank = 0;
    }
}

class Tree {
    Node root;
    public Tree() {
        root = null;
    }
    public int add(int value) {
        int rank = 0;
        if (root == null) {
            root = new Node(value);
        }
        else {
            Node n = root;
            while (true) {
                if (value < n.value) { // if the new value is smaller than the node comparing rn
                    rank += n.rank + 1;
                    if (n.left == null) {
                        n.left = new Node(value);
                        return rank;
                    }
                    else
                        n = n.left;
                } else { // if the new value is larger than the node comparing rn
                    n.rank++;
                    if (n.right == null) {
                        n.right = new Node(value);
                        return rank;
                    }
                    else
                        n = n.right;
                }
            }
        }
        return rank;
    }
}