import java.io.*;
public class CCC13S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] score = new int[4];
        boolean[][] games = new boolean[4][4];
        int team = Integer.parseInt(br.readLine());
        int gamesDone = Integer.parseInt(br.readLine());
        for (int i = 0; i < gamesDone; i++){
            String[] temp = br.readLine().split(" ");
            int[] teamAndScore = new int[4];
            for (int j = 0; j < 4; j++)
                teamAndScore[j] = Integer.parseInt(temp[j]);
            if (teamAndScore[2] > teamAndScore[3])
                score[teamAndScore[0] - 1] += 3;
            else if (teamAndScore[3] > teamAndScore[2])
                score[teamAndScore[1] - 1] += 3;
            else{
                score[teamAndScore[0] - 1] += 1;
                score[teamAndScore[1] - 1] += 1;
            }
            games[teamAndScore[0] - 1][teamAndScore[1] - 1] = true;
            games[teamAndScore[1] - 1][teamAndScore[0] - 1] = true;
        }
    }
}
