import java.io.*;
import java.util.ArrayList;
/***********************************************************************
 * Project Name: CCC01S3
 *
 * Author: YZmS Lemonsity
 *
 * Date: Jan 15, 2019
 *
 * Purpose: Solving 2001 CCC S3
 *
 ***********************************************************************
 *  Status: Completed
 *
 */
public class CCC01S3 {

    // map to show relationship between possible vertices
    // Row # is the starting vertex
    // column # is the destination

    // 0 = A
    // 1 = B
    // 2 = C

    // [0][1] would store if there is a direct road from A to B
    // [1][0] would store if there is a direct road from B to A
    static boolean[][] map = new boolean[26][26];

    static ArrayList<String> roads = new ArrayList<>(); // road names
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        // initialize the map where there is no road
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                map[i][j] = false;
            }
        }
        do {
            input = br.readLine(); // read input
            if (input.equalsIgnoreCase("**")) // Stop input if detect "**"
                break;
            roads.add(input); // add the road to the list of road, in chronological order
            int from = (int) input.charAt(0) - 65; // point 1 in integer
            int to = (int) input. charAt(1) - 65; // point 2 in integer
            // because the roads are two-way, thus we need set both "1" to "2" & "2" to "1" to 'true'
            map[from][to] = true;
            map[to][from] = true;
        } while (!input.equals("**"));
        int counter = 0; // amount of roads that will cut of entire supply line
        for (String road : roads) { // We go through each road in chronological order

            // copy the complete map into a new array
            // this is to not refer to the same memory, and cause problem during other loops
            boolean[][] tempMap = new boolean[26][];
            for (int i = 0; i < 26; i++) {
                tempMap[i] = map[i].clone();
            }
            // The 2 vertices of the road
            int from = (int) road.charAt(0) - 65;
            int to = (int) road.charAt(1) - 65;
            // delete the road off the map
            tempMap[from][to] = false;
            tempMap[to][from] = false;
            // check if it is still possible to go from point A to B
            if (d(tempMap)) { // if no path can be found after deleting the road
                counter++; // add 1 to the counter
                System.out.print(road + "\n"); // output the name of the road that can be blown up
            }
        }
        System.out.printf("There are %d disconnecting roads.\n", counter); // output amount of roads satisfy the condition
    }
    public static boolean d(boolean[][] map) { // dijkstra algorithm
        int[] distance = new int[26]; // The distance of going from point A to each vertex, regardless if the vertex exist or not
        ArrayList<Integer> gone = new ArrayList<>(); // The vertices that we haven't gone to
        for (int i = 0; i < 26; i++) {
            distance[i] = Integer.MAX_VALUE; // set all vertices to infinitely far from point A
            gone.add(i); // add pretend we have not completed any vertex yet
        }
        distance[0] = 0; // set point A distance to 0, because we always start on A, and point A is 0 unit away from point A
        while (!gone.isEmpty()) { // when we haven't check all the
            int from = shortest(gone, distance); // find the vertex with the shortest distance that we haven't gone yet
            if (from == -1) { // Referring to the documentation in the method, from == -1 means we meet a dead end
                break; // break the loop, because we found the distance to all of the vertex that are reachable
            }
            for (int i = 0; i < 26; i++) { // for each vertex
                if (map[from][i] == true) { // if the vertex is a neighbor of the vertex with the shortest distance
                    int temp = distance[from] + 1;
                    if (temp < distance[i]) // check if there is a shorter way to reach the neighbor
                        distance[i] = temp; // replace to new distance if it is shorter
                }
            }
            gone.remove(gone.indexOf(from)); // remove the shortest vertex from the vertex where we haven't been
        }
        return distance[1] == Integer.MAX_VALUE; // if B is unreachable, it would have a distance of Integer.MAX_VALUE
    }

    public static int shortest(ArrayList<Integer> array, int[] distance) {
        int shortestNode = -1; // set the shortest vertex to -1, come in handy later
        int shortestDistance = Integer.MAX_VALUE; // set the shortest distance to MAX
        for (int node : array) { // for all the vertex we haven't been to
            if (distance[node] < shortestDistance // condition 1: if the vertex have a shorter distance than any other vertex
                    && distance[node] != Integer.MAX_VALUE) { // condition 2: and has a direct path to one of the vertex we already been to
                shortestNode = node; // set the next vertex we want to go to the vertex that satisfy the above 2 conditions
            }
        }
        // At this point, if the shortestNode is -1, that means all the vertices left do not have direct connect with any of the vertices we've been before
        return shortestNode;
    }
}
