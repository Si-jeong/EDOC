package d210217;

import java.util.*;

public class B10159 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 물건 개수
        int m = sc.nextInt(); // 물건 쌍 개수
        int [][] graph = new int [101][101]; // 2차원 리스트
        // 2차원 리스트를 (n+1) * (n+1)로 만들었을 때 틀렸다고 나왔음

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1; // a > b
        }
        sc.close();

        // a > b and b > c -> a > c
        // 플로이드 와샬
        for(int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }

        for(int i = 1; i < n + 1; i++) {
            int result = 0;
            for (int j = 1; j < n + 1; j++) {
                // i > j 가 아니고, j > i가 아닐 때
                if (graph[i][j] == 0 && graph[j][i] == 0) {
                    result++;
                }
            }
            System.out.println(result - 1); // i번째 노드를 빼줌

        }
    }
}
