import java.io.*;
public class CCC04S1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int temp = Integer.parseInt(br.readLine());
        for (int i = 0; i < temp; i++){
            String[] array = new String[3];
            for (int j = 0; j < 3; j++){
                array[j] = br.readLine();
            }
            boolean check = true;
            for (int j = 0; j < 3; j++){
                for (int k = 0; k < 3; k++){
                    if (j != k && array[k].length() <= array[j].length()){
                        if (array[k].equalsIgnoreCase(array[j].substring(0, array[k].length()))
                                || array[k].equalsIgnoreCase(array[j].substring(array[j].length() - array[k].length()))){
                            check = false;
                        }
                    }
                }
            }
            if (!check)
                System.out.println("No");
            else
                System.out.println("Yes");
        }
    }
}
