import java.io.*;
public class CCC04J3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int adjectiveNum = Integer.parseInt(br.readLine());
        int nounNum =  Integer.parseInt(br.readLine());
        String[] adjectives = new String[adjectiveNum];
        String[] nouns = new String[nounNum];
        for (int i = 0; i < adjectiveNum; i++){
            adjectives[i] = br.readLine();
        }
        for (int i = 0; i < nounNum; i++){
            nouns[i] = br.readLine();
        }
        for (String adjective : adjectives){
            for (String noun : nouns) {
                System.out.printf("%s as %s\n", adjective, noun);
            }
        }
    }
}
