import java.io.*;
import java.util.TreeSet;

public class CCC15S3  {
    public static TreeSet<Integer> set = new TreeSet<Integer>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int gateAmount = Integer.parseInt(br.readLine());
        for (int i = 1; i <= gateAmount; i++){
            set.add(i);
        }
        int planeAmount = Integer.parseInt(br.readLine());
        int amountLanded = 0;
        for (int i = 1; i <= planeAmount; i++){
            int gateWant = Integer.parseInt(br.readLine());
            Integer check = set.lower(gateWant + 1);
            if (check == null)
                break;
            amountLanded++;
            set.remove(check);
        }
        System.out.print(amountLanded);
    }
}
