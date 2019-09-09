import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/***********************************************************************
 * Project Name: CCC01S3
 *
 * Author: YZmS Lemonsity
 *
 * Date: Sept 9, 2019
 *
 * Purpose: Solving 2001 CCC S3
 *
 ***********************************************************************
 *  Status: Completed, with BFS, easier to understand
 *
 *  Below contain original way, Dijkstra algorithm
 *
 */

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] matrix = new boolean[26][26]; // relationship matrix, row is from, column is to, so matrix[from][to]
        String input = br.readLine();
        ArrayList<String> roads = new ArrayList<>();
        ArrayList<String> answerRoads = new ArrayList<>();
        while (!input.equals("**")) { // when have more roads
            // add road into matrix
            char a = input.charAt(0);
            char b = input.charAt(1);
            matrix[a - 'A'][b - 'A'] = true;
            matrix[b - 'A'][a - 'A'] = true;
            roads.add(input);
            input = br.readLine();
        }
        for (String s : roads) { // go through all the possible roads
            // remove the road
            char a = s.charAt(0);
            char b = s.charAt(1);
            matrix[a - 'A'][b - 'A'] = false;
            matrix[b - 'A'][a - 'A'] = false;
            // BFS (Breast First Search)
            boolean reached = false; // B have not been reached yet
            Queue<Character> queue = new LinkedList<>(); // queue for BFS
            boolean[] gone = new boolean[26]; // the points been to
            gone[0] = true; // start on A, so A is marked as gone
            queue.add('A');
            while (!queue.isEmpty()) { // when there are still possible points to go
                char from = queue.remove(); // take a point out of the queue
                gone[from - 'A'] = true; // mark the point as gone
                if (from == 'B') { // if the point is B, then there is no need to check more points
                    reached = true;
                    break;
                }
                for (int to = 0; to < 26; to++) { // go through each point (call this point point P)
                    if (matrix[from - 'A'][to] && !gone[to]) {
                        // check if there is a road between the point we are on and point P
                        // point P also cannot be gone yet
                        queue.add((char)(to + 'A')); // if point meet criteria, add to queue
                    }
                }
            }
            if (!reached) { // if B was never reached
                answerRoads.add(s); // add the road to the answer
            }
            // add the road back, graph is back to normal
            a = s.charAt(0);
            b = s.charAt(1);
            matrix[a - 'A'][b - 'A'] = true;
            matrix[b - 'A'][a - 'A'] = true;
        }
        // print answer
        for (String s : answerRoads)
            System.out.print(s + "\n");
        System.out.printf("There are %d disconnecting roads.\n", answerRoads.size());
    }
}

/*

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
                if (map[from][i]) { // if the vertex is a neighbor of the vertex with the shortest distance
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

 */
