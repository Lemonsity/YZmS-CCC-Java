import java.io.*;
public class CCC05S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp2 = br.readLine().split(" ");
        int xWidth = Integer.parseInt(temp2[0]);
        int yHeight = Integer.parseInt(temp2[1]);
        int x = 0;
        int y = 0;
        int xMove;
        int yMove;
        do{
            String[] temp = br.readLine().split(" ");
            xMove = Integer.parseInt(temp[0]);
            yMove = Integer.parseInt(temp[1]);
            x += xMove;
            y += yMove;
            if (x >= xWidth)
                x = xWidth;
            else if (x <= 0)
                x = 0;
            if (y >= yHeight)
                y = yHeight;
            else if (y <= 0)
                y = 0;
            if (!(xMove == 0 && yMove == 0)){
                System.out.printf("%d %d\n", x, y);
            }
        }while (!(xMove == 0 && yMove == 0));
    }
}
