import java.io.*;
import java.util.*;
public class CCC14S3 {
    public static Stack<Integer> mountain = new Stack<Integer>();
    public static Stack<Integer> branch = new Stack<Integer>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int runs = Integer.parseInt(br.readLine());
        for (int i = 0; i < runs; i++){
            mountain.clear();
            branch.clear();
            boolean canOrCannot = true;
            int bottom = 0;
            int carts = Integer.parseInt(br.readLine());
            for (int cart = 0; cart < carts; cart++){
                mountain.push(Integer.parseInt(br.readLine()));
            }
            while (!mountain.isEmpty()){
                if (mountain.peek() - 1 == bottom)
                    bottom = mountain.pop();
                else if (!branch.isEmpty() && branch.peek() - 1 == bottom)
                    bottom = branch.pop();
                else
                    branch.push(mountain.pop());
            }
            while (!branch.isEmpty()){
                if (branch.peek() - 1 != bottom) {
                    canOrCannot = false;
                    break;
                }
                else
                    bottom = branch.pop();
            }
            System.out.print(canOrCannot ? "Y\n" : "N\n");
        }
    }
}