
```
public void dfs(int[][] grid, int i, int j, boolean[] used) {
    if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) { // 超出边界
        return;
    }

    if (visited[i][j]) { // 已遍历过 (i, j)
        return
    }

    visited[i][j] = true;
    dfs(grid, i-1, j); // 上 
    dfs(grid, i+1, j); // 下
    dfs(grid, i, j-1); // 左
    dfs(grid, i, j+1); // 右
    visited[i][j] = false;
}
```



```
private int[] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

public void dfs(int[][] grid, int i, int j, boolean[] used) {
    if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) { // 超出边界
        return;
    }

    if (visited[i][j]) { // 已遍历过 (i, j)
        return
    }

    visited[i][j] = true;
    for (int[] d : directions) {
        int nextI = i + d[0];
        int nextJ = j + d[1];
        dfs(grid, nextI, nextJ);
    }
    visited[i][j] = false;
}
```



