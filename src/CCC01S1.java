import java.io.*;
public class CCC01S1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] cards = new char[4][13];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                cards[i][j] = 'O';
            }
        }
        int on = 0;
        String list = br.readLine();
        for (int i = 0; i < list.length(); i++) {
            if (list.charAt(i) == 'C')
                on = 0;
            else if (list.charAt(i) == 'D')
                on = 1;
            else if (list.charAt(i) == 'H')
                on = 2;
            else if (list.charAt(i) == 'S')
                on = 3;
            else {
                char card = list.charAt(i);
                for (int j = 0; j < 13; j++) {
                    if (cards[on][j] == 'O') {
                        cards[on][j] = card;
                        break;
                    }
                }
            }
        }
        int totalScore = 0;
        System.out.print("Cards Dealt              Points\n");
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0:
                    System.out.print("Clubs ");
                    break;
                case 1:
                    System.out.print("Diamonds ");
                    break;
                case 2:
                    System.out.print("Hearts ");
                    break;
                case 3:
                    System.out.print("Spades ");
                    break;
            }
            int score = 0;
            int counter = 0;
            for (int j = 0; j < 13; j++) {
                if (cards[i][j] != 'O') {
                    System.out.print(cards[i][j] + " ");
                    score += score(cards[i][j]);
                    counter++;
                }
                else
                    break;
            }
            if (counter == 0)
                score += 3;
            else if (counter == 1)
                score += 2;
            else if (counter == 2)
                score += 1;
            totalScore += score;
            System.out.print("\t" + score + "\n");
        }
        System.out.print("                       Total " + totalScore + "\n");
    }
    public static int score(char character) {
        if (character == 'A')
            return 4;
        else if (character == 'K')
            return 3;
        else  if (character == 'Q')
            return 2;
        else if (character == 'J')
            return 1;
        return 0;
    }
}
