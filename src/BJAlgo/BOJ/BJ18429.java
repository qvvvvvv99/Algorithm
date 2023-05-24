package BJAlgo.BOJ;

import java.util.Scanner;

public class BJ18429 {
    static int res = 0;
    static boolean[] visited;
    static int N, K;
    static int[] ary;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        ary = new int[N];
        for(int i = 0; i < N; i++)
            ary[i] = sc.nextInt();
        visited = new boolean[N];

        dfs(0, 500, 0);

        System.out.println(res);
    }

    static void dfs(int idx, int weigth, int day){
        if(day == N){
            res++;
            return;
        }

        weigth -= K;
        for(int i = 0; i < N; i++){
            if(visited[i])
                continue;
            if(weigth+ary[i] >= 500){
                visited[i] = true;
                day++;
                weigth += ary[i];
                dfs(i, weigth, day);
                weigth -= ary[i];
                day--;
                visited[i] = false;
            }
        }
    }
}
