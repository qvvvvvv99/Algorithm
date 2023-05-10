package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int idx = 1; idx <= 10; idx++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] hei = new int[n];
            for(int i = 0; i < n; i++)
                hei[i] = Integer.parseInt(st.nextToken());

            int res = 0;
            int left, right, cnt;
            for (int i = 2; i < n - 2; i++) {
                left = Math.max(hei[i-2], hei[i-1]);
                right = Math.max(hei[i+1], hei[i+2]);
                cnt = hei[i] - Math.max(left, right);
                if(cnt > 0)
                    res += cnt;
            }
            System.out.println("#"+idx+" "+res);
        }
    }
}
