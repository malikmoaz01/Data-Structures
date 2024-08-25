import java.util.*;

public class KnightMoves {

    // A class to represent a cell on the chessboard
    static class Cell {
        int x, y, dist;

        public Cell(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    // Possible moves of a knight
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    // Check if the position is inside the chessboard
    static boolean isInside(int x, int y, int N) {
        return (x >= 1 && x <= N && y >= 1 && y <= N);
    }

    public static int minStepsToReachTarget(int knightPos[], int targetPos[], int N) {
        // Queue for BFS
        Queue<Cell> q = new LinkedList<>();

        // Push starting position of knight with 0 distance
        q.add(new Cell(knightPos[0], knightPos[1], 0));

        // Initialize visited array
        boolean visited[][] = new boolean[N + 1][N + 1];
        visited[knightPos[0]][knightPos[1]] = true;

        // BFS loop
        while (!q.isEmpty()) {
            Cell t = q.poll();

            // If current cell is equal to target cell, return its distance
            if (t.x == targetPos[0] && t.y == targetPos[1])
                return t.dist;

            // Iterate through all possible moves of the knight
            for (int i = 0; i < 8; i++) {
                int x = t.x + dx[i];
                int y = t.y + dy[i];

                // If the new position is inside the board and not visited yet
                if (isInside(x, y, N) && !visited[x][y]) {
                    visited[x][y] = true;
                    q.add(new Cell(x, y, t.dist + 1));
                }
            }
        }
        return -1; // If the target is not reachable
    }

    public static void main(String[] args) {
        int N = 6;
        int knightPos[] = {4, 5};
        int targetPos[] = {1, 1};
        System.out.println(minStepsToReachTarget(knightPos, targetPos, N));
    }
}

/*

If a knight is on a position (x, y), it can move to any of the following positions (as long as they are within the bounds of the chessboard):

(x + 2, y + 1)
(x + 2, y - 1)
(x - 2, y + 1)
(x - 2, y - 1)
(x + 1, y + 2)
(x + 1, y - 2)
(x - 1, y + 2)
(x - 1, y - 2)


1. Pehle, Cell class banti hai jo chessboard ki aik position ko represent karti hai. Iske andar x aur y coordinates hote hain aur knight ke us position tak pohanchne ke liye kitni moves lagi, yeh distance (dist) ke zariye track kiya jata hai.

2. dx aur dy arrays knight ke 8 possible moves ko define karte hain jo woh kisi bhi position se kar sakta hai.

3. isInside function check karta hai ke koi position (x, y) chessboard ke boundaries ke andar hai ya nahi.

4. minStepsToReachTarget function Breadth-First Search (BFS) ka use karke minimum steps calculate karta hai jo knight ko target tak pohanchne ke liye lagenge.
   - Yeh knight ki starting position ko queue mein add karta hai aur us position se 0 distance ke sath start karta hai.
   - Phir function knight ke saare possible moves check karta hai, agar koi valid move hai to us position ko queue mein daal diya jata hai aur visited array mein mark kar diya jata hai.
   - BFS loop tab tak chalta hai jab tak target position na mil jaye ya queue khatam na ho jaye.

5. Main method board ka size, knight ki initial position aur target position set karta hai, phir yeh function ko call karta hai minimum steps nikalne ke liye.
*/
