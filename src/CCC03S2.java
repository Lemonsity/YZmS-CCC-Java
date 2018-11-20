import java.io.*;
public class CCC03S2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String[] array = new String[4];
        int repeat = Integer.parseInt(br.readLine());
        for (int i = 0; i < repeat; i++){
            for (int j = 0; j < 4; j++){
                array[i] = br.readLine();
            }
        }
    }
    public static String last(String line){
        String vowel = "aeiou";
        String[] words = line.split(" ");
        String lastWord = words[words.length - 1];
        return "lol";
    }
}

