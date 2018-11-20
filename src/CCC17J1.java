import java.io.*;
public class CCC17J1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());
        if (num1 > 0){
            if (num2 > 0)
                System.out.println(1);
            else
                System.out.print(4);
        }
        else{
            if (num2 > 0)
                System.out.print(2);
            else
                System.out.print(3);
        }
    }
}
