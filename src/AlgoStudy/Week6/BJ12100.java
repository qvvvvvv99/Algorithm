package AlgoStudy.Week6;

import java.util.Scanner;

public class BJ12100 {
    static int n;
    static int[][] arr = new int[30][30];
    static int ans;

    public static void cpy(int[][] a, int[][] b)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                a[i][j] = b[i][j];
            }
        }
    }

    public static void rotate()
    {
        int[][] arr2 = new int[30][30];

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                arr2[i][j] = arr[n - j - 1][i];
            }
        }

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                arr[i][j] = arr2[i][j];
            }
        }
    }

    public static void drop()
    {
        int idx;

        for (int j = 0; j < n; j++)
        {
            idx = n - 1;
            for (int i = n - 1; i >= 0; i--)
            {
                if (arr[i][j] != 0)
                {
                    if (idx == i) continue;
                    else if (arr[idx][j] == 0) arr[idx][j] = arr[i][j];
                    else if (arr[idx][j] == arr[i][j])
                    {
                        arr[idx][j] *= 2;
                        idx--;
                    }
                    else
                    {
                        idx--;
                        arr[idx][j] = arr[i][j];

                        if (i == idx) continue;
                    }
                }

                arr[i][j] = 0;
            }
        }
    }

    public static void check()
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                ans = Math.max(ans, arr[i][j]);
            }
        }
    }

    public static void recur(int cur)
    {
        int[][] arr2 = new int[30][30];

        if (cur == 5)
        {
            check();
            return;
        }

        for (int i = 0; i < 4; i++)
        {
            cpy(arr2, arr);

            drop();

            recur(cur + 1);

            cpy(arr, arr2);
            rotate();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                arr[i][j] = sc.nextInt();
            }
        }

        recur(0);

        System.out.print(ans);
    }
}