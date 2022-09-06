package AlgoStudy.Week5;

import java.util.Scanner;

public class BJ20061 {
    static int n;
    static int[][][] arr = new int[2][10][5];
    static int score;

    public static void addBlock(int idx, int type, int x, int y){
        if(type == 1){
            for(int i = 0; i < 6; i++){
                if(arr[idx][i][y] == 0 && arr[idx][i + 1][y] == 1){
                    arr[idx][i][y] = 1;
                    break;
                }
            }
        }
        else if(type == 2){
            for(int i = 0; i < 6; i++){
                if(arr[idx][i][y] == 0 && arr[idx][i][y + 1] == 0 && (arr[idx][i + 1][y] != 0 || arr[idx][i + 1][y + 1] != 0)){
                    arr[idx][i][y] = 1;
                    arr[idx][i][y + 1] = 1;
                    break;
                }
            }
        }
        else{
            for(int i = 1; i < 6; i++){
                if(arr[idx][i][y] == 0 && arr[idx][i + 1][y] == 1){
                    arr[idx][i][y] = 1;
                    arr[idx][i - 1][y] = 1;
                    break;
                }
            }
        }
    }

    public static void drop(int idx){
        boolean empty;
        int prv;

        prv = -1;
        for(int i = 5; i >= 0; i--){
            empty = true;
            for(int j = 0; j < 4; j++){
                if(arr[idx][i][j] != 0) empty = false;
            }

            if(empty) {
                if(prv == -1) prv = i;
                continue;
            }

            if(prv == -1) continue;

            for(int j = 0; j < 4; j++){
                arr[idx][prv][j] = arr[idx][i][j];
                arr[idx][i][j] = 0;
            }
            prv--;
        }
    }

    public static void getScore(int idx){
        boolean full;

        for(int i = 0; i < 6; i++){
            full = true;
            for(int j = 0; j < 4; j++){
                if(arr[idx][i][j] != 1) full = false;
            }

            if(!full) continue;

            for(int j = 0; j < 4; j++) arr[idx][i][j] = 0;
            score++;
        }

        drop(idx);
    }

    public static void remove(int idx){
        int cnt;
        boolean empty;

        cnt = 0;
        for(int i = 0; i < 2; i++){
            empty = true;
            for(int j = 0; j < 4; j++){
                if(arr[idx][i][j] != 0) empty = false;
            }

            if(!empty) cnt++;
        }

        for(int i = 5; i > 5 - cnt; i--){
            for(int j = 0; j < 4; j++){
                arr[idx][i][j] = 0;
            }
        }

        drop(idx);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, c;
        int cnt;

        for(int j = 0; j < 4; j++){
            arr[0][6][j] = 1;
            arr[1][6][j] = 1;
        }

        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();

            addBlock(0, a, b, c);
            getScore(0);
            remove(0);

            if(a == 1) addBlock(1, 1, c, b);
            else if(a == 2) addBlock(1, 3, c, b);
            else addBlock(1, 2, c, b);
            getScore(1);
            remove(1);
        }

        cnt = 0;
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 6; j++){
                for(int k = 0; k < 4; k++){
                    cnt += arr[i][j][k];
                }
            }
        }

        System.out.println(score);
        System.out.print(cnt);
    }
}