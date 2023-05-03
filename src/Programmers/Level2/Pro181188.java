package Programmers.Level2;

import java.util.Arrays;
import java.util.Comparator;

// 요격 시스템
public class Pro181188 {
    public static void main(String[] args) {
        int[][] targets = {{4,5}, {4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};

        System.out.println(solution(targets));
    }

    static int solution(int[][] targets){
        Arrays.sort(targets, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        // check(targets);
        int answer = 1;

        int idx = 0;
        int tail = targets[0][1];
        while(idx < targets.length-1){
            idx++;
            if(tail > targets[idx][0])
                continue;
            answer++;
            tail = targets[idx][1];
        }

        return answer;
    }

    static void check(int[][] ary){
        for(int i = 0; i < ary.length; i++){
            for(int j = 0; j < 2; j++){
                System.out.print(ary[i][j] + " ");
            }
            System.out.println();
        }
    }
}
