import java.io.*;
import java.util.Stack;
public class CCC15S1 {
    public static Stack<Integer> stack = new Stack<Integer>();
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(br.readLine());
        for (int j = 0; j < i; j++){
            int num = Integer.parseInt(br.readLine());
            if (num != 0)
                stack.push(num);
            else if (!stack.isEmpty())
                stack.pop();
        }
        int sum = 0;
        while(!stack.isEmpty())
            sum += stack.pop();
        System.out.print(sum);
    }
}
