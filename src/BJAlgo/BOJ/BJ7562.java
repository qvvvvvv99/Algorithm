package BJAlgo.BOJ;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BJ7562 {

    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static int n, sx, sy, ex, ey, res;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for(int T = 0; T < tc; T++){
            n = sc.nextInt();
            int[][] map = new int[n][n];
            for(int i = 0; i < n; i++)
                Arrays.fill(map[i], INF);
            res = 0;

            sx = sc.nextInt();
            sy = sc.nextInt();
            ex = sc.nextInt();
            ey = sc.nextInt();

            map[sx][sy] = 0;
            if(sx != ex || sy != ey)
                bfs(map);

            System.out.println(res);
        }

    }

    private static void bfs(int[][] map) {
        ArrayList<Point> list = new ArrayList<Point>();
        list.add(new Point(sx, sy));
        Point curr;
        int nx, ny, p;
        boolean flag = true;

        while(flag){
            curr = list.remove(0);
            p = map[curr.x][curr.y];
            for(int i = 0; i < 8; i++) {
                nx = curr.x + dx[i];
                ny = curr.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n)
                    continue;
                if(nx == ex && ny == ey) {
                    res = p+1;
                    flag = false;
                    break;
                }
                if(map[nx][ny] <= p+1)
                    continue;
                list.add(new Point(nx, ny));
                map[nx][ny] = p+1;
            }
        }
    }
}
