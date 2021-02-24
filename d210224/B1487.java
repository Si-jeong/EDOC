package d210224;

import java.util.*;

public class B1487 {
    static int n;
    static int[][] list;
    static int low = 1_000_001;
    static int high = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        list = new int[n][2];

        for(int i=0; i<n; i++){
            list[i][0] = sc.nextInt();
            list[i][1] = sc.nextInt();

            if (low > list[i][0]) low = list[i][0];
            if (high < list[i][0]) high = list[i][0];

        }

        int result = 0;
        int idx = 0;
        for(int i=low; i<high+1; i++){
            int profit = 0;
            for(int j=0; j<n; j++){
                if(list[j][0] >= i){
                    int temp = i - list[j][1];
                    if (temp > 0) {
                        profit += temp;
                    }
                }
            }
            if (profit > result) {
                result = profit;
                idx = i;

            }
        }
        System.out.println(idx);
    }
}
