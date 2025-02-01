// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//BFS
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int oldcolor=0;
        if (image.length == 0) {
            return image;
        }
        int m=image.length;
        int n= image[0].length;
        if (image[sr][sc] == color) {
            return image;
        }
        oldcolor = image[sr][sc];
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (image[sr][sc] != color ) {
                    image[sr][sc] = color;
                    q.add(new int[]{sr,sc});
                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        for (int[] dir:dirs) {
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];
                            if (nr < m && nr >=0 && nc< n && nc>=0 && image[nr][nc] == oldcolor) {
                                image[nr][nc] = color;
                                q.add(new int[] {nr, nc});
                            }
                        }

                    }

                }
            }
        }
        return image;
    }
}


//DFS
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int oldcolor=0;
        if (image.length == 0) {
            return image;
        }
        int m=image.length;
        int n= image[0].length;
        if (image[sr][sc] == color) {
            return image;
        }
        oldcolor = image[sr][sc];
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (image[sr][sc] != color ) {
                    image[sr][sc] = color;
                    dfs(sr, sc, image, dirs, m ,n, oldcolor, color);
                    //q.add(new int[]{sr,sc});
                }
            }
        }
        return image;
    }
    private void dfs(int i, int j, int[][] image, int[][] dirs, int m, int n, int oldcolor, int color) {
        for (int[] dir:dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            if (nr < m && nr >=0 && nc< n && nc>=0 && image[nr][nc] == oldcolor) {
                image[nr][nc] = color;
                //q.add(new int[] {nr, nc});
                dfs(nr, nc, image, dirs, m ,n, oldcolor, color);
            }
        }
    }
}





class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] dirs = {{-1,0}, {1, 0}, {0, -1}, {0,1}};
        int lvl=0;
        Queue<int[]> q = new LinkedList<>();
        if(mat.length == 0) {
            return mat;
        }
        int m = mat.length;
        int n = mat[0].length;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[] {i,j});
                }
            }
        }
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0;i<size;i++) {
                int[] curr = q.poll();
                for (int[] dir:dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if (nr < m && nr >=0 && nc < n && nc >=0 && mat[nr][nc] == 1) {
                        q.add(new int[] {nr, nc});
                        mat[nr][nc] = -(lvl+1);
                    }
                }
            }
            lvl++;
        }
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (mat[i][j] != 0) {
                    mat[i][j] = -mat[i][j];
                }
            }
        }

        return mat;
    }
}
