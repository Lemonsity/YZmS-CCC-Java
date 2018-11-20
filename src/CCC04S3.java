import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class CCC04S3 {
    public static HashMap<String, String> table = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        for (int row = 65 ; row < 75; row++){
            for (int column = 1; column <= 9; column++){
                String key = String.valueOf((char)row) + String.valueOf(column);
                table.put(key, sc.next());
            }
        }
        for (char row = 'A' ; row <= 'J'; row++){
            for (int column = 1; column <= 9; column++){
                String key = String.valueOf(row) + String.valueOf(column);
                String sumString = calculate(key);
                int sumInt = 0;
                String sumFinal = "";
                String[] adders = sumString.split(" ");
                for (String adder : adders){
                    if (adder.equalsIgnoreCase("*")) {
                        sumFinal = "*";
                    }
                    else{
                        sumInt += Integer.parseInt(adder);
                    }
                }
                if (sumFinal.equalsIgnoreCase("*"))
                    sumFinal = String.valueOf(sumInt);
                table.put(key, sumFinal);
            }
        }
    }
    public static String calculate(String key){
        String sum = "";
        if (integer(table.get(key)))
            sum = table.get(key);
        else {
            String[] adders = table.get(key).split("\\+");
            for (String adder : adders){
                if (adder.equalsIgnoreCase(key))
                    sum += "* ";
                else
                    sum += calculate(adder);
            }
        }
        return sum;
    }
    public static boolean integer(String value){
        boolean check = false;
        try{
            Integer.parseInt(value);
            check = true;
        } catch (NumberFormatException ex){
        }
        return check;
    }
}
