import java.io.*;
import java.util.Arrays;

public class CCC03S4 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int times = Integer.parseInt(br.readLine());
        for (int i = 0; i < times; i++){
            String str = br.readLine();
            String[] array = new String[str.length() * (str.length() + 1) / 2];
            int arrayCounter = 0;
            for (int size = 1; size <= str.length(); size++){
                for (int index = 0; index <= str.length() - size; index++){
                    if (index != str.length() - size)
                        array[arrayCounter] = str.substring(index, index + size);
                    else
                        array[arrayCounter] = str.substring(index);
                    arrayCounter++;
                }
            }
            Arrays.sort(array);
            int counter = 1;
            String check = "";
            for (String value : array){
                if (!value.equalsIgnoreCase(check)){
                    counter++;
                }
                check = value;
            }
            System.out.print(counter + "\n");
        }
    }
}
