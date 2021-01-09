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
            int[] a1 = {-1, 1};
            int[] a2 = {-2, 2};
            for (int a : a1) {
                for (int b : a2) {
                    if (0 < x + a && x + a < 9
                            && 0 < y + b && y + b < 9
                            && board[x + a][y + b] == Integer.MAX_VALUE) {
                        board[x + a][y + b] = board[x][y] + 1;
                        queue.add(new Pair(x + a, y + b));
                    }
                    if (0 < x + b && x + b < 9
                            && 0 < y + a && y + a < 9
                            && board[x + b][y + a] == Integer.MAX_VALUE) {
                        board[x + b][y + a] = board[x][y] + 1;
                        queue.add(new Pair(x + b, y + a));
                    }
                }
            }
        }

        System.out.println(board[bx][by]);
    }
}
