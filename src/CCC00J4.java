import java.io.*;
import java.util.ArrayList;

public class CCC00J4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        ArrayList<Double> streams = new ArrayList <>(); // store the amount of water each stream
        int num = Integer.parseInt(br.readLine());
        // initialize the streams
        for (int i = 0; i < num; i++)
            streams.add(Double.parseDouble(br.readLine()));
        int input = Integer.parseInt(br.readLine());
        do {
            if (input == 77)
                break;

            // notice I used a lot of -1 when calling .add() .set() .remove(), this is because arrays start at 0

            else if (input == 99) { // split
                int streamNum = Integer.parseInt(br.readLine());
                int percent = Integer.parseInt(br.readLine());
                // the left stream stays in place index wise, and the new stream is inserted behind
                // add one element behind the stream that got split
                streams.add(streamNum + 1 - 1, streams.get(streamNum - 1) * (100 - percent) / 100.0);
                // edit the stream that had been split
                streams.set(streamNum - 1, streams.get(streamNum - 1) * percent / 100.0);
            }
            else if (input == 88) { // merge
                int streamNum = Integer.parseInt(br.readLine());
                // the stream user choose is deleted, merged to the right
                streams.set(streamNum + 1 - 1, streams.get(streamNum - 1) + streams.get(streamNum)); // merge
                streams.remove(streamNum - 1); // remove
            }
            input = Integer.parseInt(br.readLine());
        } while (input != 77);
        for (Double v : streams) {
            // Double cannot cast into int directly, so transfer into double first, then round.
            double d = v + 0.5;
            System.out.print((int) d + " ");
        }
        System.out.print("\n");
    }
}
