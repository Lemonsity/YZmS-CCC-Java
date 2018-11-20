import java.util.*;
public class CCC04S2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int playerNum = sc.nextInt();
        int rounds = sc.nextInt();
        int[/*score and rank*/][/*round*/][/*player*/] data = new int[2][rounds + 1][playerNum];
        for (int roundIndex = 0; roundIndex < rounds; roundIndex++){
            //entering data
            for (int playerIndex = 0; playerIndex < playerNum; playerIndex++){
                data[0][roundIndex][playerIndex] = sc.nextInt();
                // add the score of player to his total
                data[0][rounds][playerIndex] += data[0][roundIndex][playerIndex];
            }
            //copy the score of the round just entered into another array
            int[] temp = new int[playerNum];
            for (int i = 0; i < playerNum; i++){
                temp[i] = data[0][rounds][i];
            }
            // rank the last round
            data[1][roundIndex] = rank(temp);
        }
        int[] temp = new int[playerNum];
        for (int i = 0; i < playerNum; i++){
            temp[i] = data[0][rounds][i];
        }
        //rank the final
        data[1][rounds] = rank(temp);
        int worst = 0;
        // Go through each player
        for (int i = 0; i < playerNum; i++){
            // if the player's rank is 1
            if (data[1][rounds][i] == 1){
                // set the player's rank of first round to the worst
                worst = data[1][0][i];
                // go through each round of that player
                for (int j = 1; j < rounds; j++){
                    // if perform worse, update worst
                    if (data[1][j][i] > worst)
                        worst = data[1][j][i];
                }
                System.out.printf("Yodeller %d is the TopYodeller: score %d, worst rank %d \n", i + 1 , data[0][rounds][i], worst);
            }
        }
    }
    // Rank the whatever round that have just been entered
    public static int[] rank(int[] originalScore){
        // the temp array is the array that we sort through.
        Integer[] temp = new Integer[originalScore.length];
        for (int i = 0; i < originalScore.length; i++)
            temp[i] = originalScore[i];
        //sort the scores in descending order
        Arrays.sort(temp, Collections.reverseOrder());
        //go through the original row of the round
        for (int indexChecking = 0; indexChecking < originalScore.length; indexChecking++){
            // go through the sorted scores
            for (int indexBeingChecked = 0; indexBeingChecked < temp.length; indexBeingChecked++){
                // if match, the index of the sorted score is the ranking of that round
                if (originalScore[indexChecking] == temp[indexBeingChecked]){
                    originalScore[indexChecking] = indexBeingChecked + 1;
                    // if match, no need to check more
                    break;
                }
            }
        }
        return originalScore;
    }
}