import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CCC10J5 {

    private static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.MAX_VALUE;
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ax = Integer.parseInt(st.nextToken()), ay = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int bx = Integer.parseInt(st.nextToken()), by = Integer.parseInt(st.nextToken());
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(ax, ay));

        board[ax][ay] = 0;
        while (!queue.isEmpty()) {
            Pair coordination= queue.remove();
            int x = coordination.x, y = coordination.y;
            int[] i1 = {-1, 1}; // i1,2 for iterator1,2
            int[] i2 = {-2, 2};
            for (int c1 : i1) { // c1,2 for change1,2
                for (int c2 : i2) {
                    if (0 < x + c1 && x + c1 < 9
                            && 0 < y + c2 && y + c2 < 9
                            && board[x + c1][y + c2] == Integer.MAX_VALUE) {
                        board[x + c1][y + c2] = board[x][y] + 1;
                        queue.add(new Pair(x + c1, y + c2));
                    }
                    if (0 < x + c2 && x + c2 < 9
                            && 0 < y + c1 && y + c1 < 9
                            && board[x + c2][y + c1] == Integer.MAX_VALUE) {
                        board[x + c2][y + c1] = board[x][y] + 1;
                        queue.add(new Pair(x + c2, y + c1));
                    }
                }
            }
        }

        System.out.println(board[bx][by]);
    }
}
