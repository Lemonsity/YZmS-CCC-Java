import java.io.*;

public class CCC02S3 {
    private static char[][] array;
    private static char[] steps;
    private static String state;
    private static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        array = new char[Integer.parseInt(br.readLine())][Integer.parseInt(br.readLine())];
        for (int i = 0; i < array.length; i++) {
            array[i] = br.readLine().toCharArray();
        }
        steps = new char[Integer.parseInt(br.readLine())];
        for (int i = 0; i < steps.length; i++) {
            steps[i] = br.readLine().charAt(0);
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == 'X')
                    continue;
                for (int k = 0; k < 4; k++) {
                    int coorX = j;
                    int coorY = i;
                    check = true;
                    if (k == 0)
                        state = "up";
                    else if (k == 1)
                        state = "right";
                    else if (k == 2)
                        state = "down";
                    else
                        state = "left";
                    for (int l = 0; l < steps.length; l++) {
                        if (steps[l] == 'F') {
                            if (state.equals("up")) {
                                coorY--;
                            } else if (state.equals("right")) {
                                coorX++;
                            } else if (state.equals("down")) {
                                coorY++;
                            } else if (state.equals("left")) {
                                coorX--;
                            }
                        }
                        else if (steps[l] == 'L') {
                            if (state.equals("up")) {
                                state = "left";
                            } else if (state.equals("right")) {
                                state = "up";
                            } else if (state.equals("down")) {
                                state = "right";
                            } else if (state.equals("left")) {
                                state = "down";
                            }
                        }
                        else if (steps[l] == 'R') {
                            if (state.equals("up")) {
                                state = "right";
                            } else if (state.equals("right")) {
                                state = "down";
                            } else if (state.equals("down")) {
                                state = "left";
                            } else if (state.equals("left")) {
                                state = "up";
                            }
                        }
                        if (coorX < 0 || coorY < 0 || coorY == array.length || coorX == array[0].length || array[coorY][coorX] == 'X') {
                            check = false;
                            break;
                        }
                    }
                    if (check){
                        array[coorY][coorX] = '*';
                    }
                }
            }
        }
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[0].length; j++){
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
}
