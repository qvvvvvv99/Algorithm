package SDS.DAY02;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P2143 {

	static long T;
    static int N, M;
    static long[] inputA, inputB;

    public static void main(String[] args) throws Exception {
      //  System.setIn(new FileInputStream("src/DAY02/P2143/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Long.parseLong(br.readLine());

        N = Integer.parseInt(br.readLine());
        inputA = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputA[i] = Long.parseLong(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        inputB = new long[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            inputB[i] = Long.parseLong(st.nextToken());
        }

        ArrayList<Long> subA = new ArrayList<>();
        ArrayList<Long> subB = new ArrayList<>();

        //subA 구하기
        for (int i = 0; i < N; i++) {
            long sum = inputA[i];
            subA.add(sum);
            for (int j = i + 1; j < N; j++) {
                sum += inputA[j];
                subA.add(sum);
            }
        }
        //subB 구하기
        for (int i = 0; i < M; i++) {
            long sum = 0;
            for (int j = i; j < M; j++) {
                sum += inputB[j];
                subB.add(sum);
            }
        }

        //subA, subB 정렬하기
        Collections.sort(subA);
        Collections.sort(subB, Comparator.reverseOrder());

        long result = 0;
        int ptA = 0;
        int ptB = 0;
        while (true) {
            long currentA = subA.get(ptA);
            long target = T - currentA;
            //currentB == target -> subA, subB 같은 수 개수 체크 -> 답구하기. ptA+ ptB+
            if (subB.get(ptB) == target) {
                long countA = 0;
                long countB = 0;
                while (ptA < subA.size() && subA.get(ptA) == currentA){
                    countA++;
                    ptA++;
                }
                while (ptB < subB.size() && subB.get(ptB) == target){
                    countB++;
                    ptB++;
                }
                result += countA * countB;
            }
            //currentB > target -> ptB++
            else if (subB.get(ptB) > target) {
                ptB++;
            }
            //currentB < target -> ptA++
            else {
                ptA++;
            }

            //탈축 조건
            if (ptA == subA.size() || ptB == subB.size()) {
                break;
            }
        }
        System.out.println(result);
    }
}
