package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HSAT2022_4_1 {
	public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] ary = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            ary[i] = Integer.parseInt(st.nextToken());
        }

        int cnt;
        int res = 0;

        for(int i = 0; i < N; i++){
            cnt = 0;
            for(int j = i + 1; j < N; j++){
                if(ary[j] > ary[i])
                    cnt++;
                else
                    res += cnt;
            }
        }

        System.out.println(res);
    }
}
