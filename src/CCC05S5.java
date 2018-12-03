import java.io.*;

public class CCC05S5 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        CCC05S5 C = new CCC05S5();
        Node root;
        int amount = Integer.parseInt(br.readLine());
        int[] rankings = new int[amount];
        rankings[0] = 1;
        root = new Node(Integer.parseInt(br.readLine()));
        for (int i = 1; i < amount; i++) {
            int value = Integer.parseInt(br.readLine());
            C.add(root, value);
            rankings[i] = C.findRanking(root, value, 1);
        }
        double sum = 0;
        for (int i = 0; i < amount; i++) {
            sum += rankings[i];
        }
        double fin = Math.round((sum * 1.00) / (amount * 1.00) * 100.00) / 100.00;
        System.out.printf("%.2f", fin);
    }

    public static class Node{
        Node left;
        Node right;
        int value;
        int toLeft;
        int toRight;
        public Node(int value) {
            this.left = null;
            this.right = null;
            this.value = value;
            this.toLeft = 0;
            this.toRight = 0;
        }
    }
    public Node add(Node node, int value) {
        if (node == null)
            return new Node(value);
        if (value < node.value) {
            node.left = add(node.left, value);
            node.toLeft += 1;
        }
        else if (value >= node.value) {
            node.right = add(node.right, value);
            node.toRight += 1;
        }
        return node;
    }
    public int findRanking(Node node, int value, int ranking) {
        if (value == node.value)
            return ranking;
        if (value < node.value){
            return findRanking(node.left, value, ranking + node.toRight + 1);
        }
        return findRanking(node.right, value, ranking);
    }
}

