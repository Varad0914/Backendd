
public class Backtracking {

    public static void main(String[] args) {

        int[][] maze = {
            {1, 1},
            {1, 1}
        };

        boolean[][] visited = new boolean[2][2];

        findPaths(0, 0, "", maze, visited);
    }

    static void findPaths(int x, int y, String path,
                          int[][] maze, boolean[][] visited) {

        int n = maze.length;

        // Base conditions
        if (x < 0 || y < 0 || x >= n || y >= n ||
            visited[x][y] || maze[x][y] == 0) {
            return;
        }

        // Destination reached
        if (x == n - 1 && y == n - 1) {
            System.out.println(path);
            return;
        }

        // Mark current cell as visited
        visited[x][y] = true;

        // Explore all four directions
        findPaths(x - 1, y, path + "U", maze, visited); 
        findPaths(x + 1, y, path + "D", maze, visited); 
        findPaths(x, y - 1, path + "L", maze, visited); 
        findPaths(x, y + 1, path + "R", maze, visited); 

        // Backtracking
        visited[x][y] = false;
    }
}
