package d210217;

import java.util.*;

// 정점과 거리를 저장하는 클래스 정의
class Pair implements Comparable<Pair> {
    int edge, dist;

    public Pair(int edge, int dist){
        this.edge = edge;
        this.dist = dist;
    }

    // 거리 기준으로 비교하도록 compareTo() 메서드 작성
    @Override
    public int compareTo(Pair o) {
        return dist - o.dist;
    }
}
public class B1753_pq {

    static final int INF = 100_000_000; // 무한을 의미
    // INF가 11일 때는 틀림
    static int [] distance; // 최단 거리 저장 리스트
    static int V, E, K; // 정점의 개수, 간선의 개수, 시작 정점의 번호
    static ArrayList<Pair> [] graph; // 그래프 정보 저장 ArrayList 배열

    static void dijkstra(int start){
        // 우선순위 큐
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(start, 0));
        distance[start] = 0;

        while(!q.isEmpty()){
            Pair nowPair = q.poll();
            int nowEdge = nowPair.edge;
            int nowDist = nowPair.dist;
            if(nowDist>distance[nowEdge]) continue;
            for(Pair nextPair : graph[nowEdge]){
                int cost = nowDist+ nextPair.dist;
                if(distance[nextPair.edge] > cost){
                    distance[nextPair.edge] = cost;
                    q.add(new Pair(nextPair.edge, cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        K = sc.nextInt();

        distance = new int [V+1];
        Arrays.fill(distance, INF); // 무한으로 초기화

        graph = new ArrayList[V+1];
        for(int i=0; i<V+1; i++){
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 입력받기
        for(int i=0; i<E; i++){
            // u에서 v로 가는 가중치 w인 간선
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u].add(new Pair(v, w));
        }
        sc.close();

        // 다익스트라 알고리즘 수행
        dijkstra(K);

        // 각 정점의 최단 거리 출력
        for(int i=1; i<V+1; i++){
            if(distance[i]==INF) System.out.println("INF");
            else System.out.println(distance[i]);
        }
    }

}
