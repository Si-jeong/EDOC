package d210217;

import java.util.*;

public class B1753 {

    static final int INF = 11; // 11은 무한을 의미
    static int [] distance; // 최단 거리 저장 리스트
    static boolean [] visited; // 방문 정점 체크 리스트
    static int V, E, K; // 정점의 개수, 간선의 개수, 시작 정점의 번호
    static int [][] graph; // 그래프 정보 저장 2차원 배열

    // 인접 정점 중 가장 작은 가중치 값을 가진 정점의 인덱스를 찾는 함수
    static int get_smallest_node(){
        int min = INF;
        int idx = 0;
        for(int i=1; i<V+1; i++){
            if(distance[i] < min && !visited[i]){
                min = distance[i];
                idx = i;
            }
        }
        return idx;
    }

    static void dijkstra(int start){
        distance[start] = 0;
        visited[start] = true;

        // 시작 정점의 인접한 정점의 최단 거리 갱신
        for(int j=1; j<V+1; j++){
            if(graph[start][j]!=INF)
                distance[j]=graph[start][j];
        }
        // V-1개의 정점을 다 방문할 때까지 반복
        for(int i=1; i<V; i++){
            // 인접하고 방문하지 않은 정점 중 가장 작은 가중치 값을 가진 정점 now
            int now = get_smallest_node();
            visited[now] = true;
            // now 에 인접한 정점 중 방문하지 않은 정점들의 최단 거리 갱신
            for(int j=1; j<V+1; i++){
                if(graph[now][j]!=INF && !visited[now])
                    distance[j]=Math.min(distance[j], distance[now]+graph[now][j]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        K = sc.nextInt();
        graph = new int[V+1][V+1];

        // 간선 정보 입력받기
        for(int i=0; i<E; i++){
            // u에서 v로 가는 가중치 w인 간선
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u][v] = w;
        }
        sc.close();

        // 최단 거리 저장 리스트
        distance = new int [V+1];
//        Arrays.fill(distance, INF);
        // 무한으로 초기화
        for(int i=1; i<V+1; i++){
            distance[i] = INF;
        }
        // 방문 정점 체크 리스트
        visited = new boolean [V+1];

        // 다익스트라 알고리즘 수행
        dijkstra(K);

        // 각 정점의 최단 거리 출력
        for(int i=1; i<V+1; i++){
            if(distance[i]<INF)
                System.out.println(distance[i]);
            else
                System.out.println("INF");
        }
    }

}
