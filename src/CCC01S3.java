import java.io.*;
import java.util.ArrayList;

public class CCC01S3 {

    public static ArrayList<String> roads = new ArrayList<String>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        while (!input.equals("**")){
            roads.add(input);
        }

    }
}