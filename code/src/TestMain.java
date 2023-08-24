import java.io.Console;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class TestMain {

    void dfs(int [][]graph,int start, boolean [] visited){
        //시작 노드를 방문 처리
        visited[start] = true;
        System.out.print(start + " ");//방문 노드 출력

        Deque<Integer> stack = new LinkedList<>();
        stack.push(start); //시작 노드를 스택에 입력

        while(!stack.isEmpty()){
            int now = stack.peek();

            boolean hasNearNode = false; // 방문하지 않은 인접 노드가 있는지 확인
            //인접한 노드를 방문하지 않았을 경우 스택에 넣고 방문처리
            Arrays.sort(graph[now]);
            for(int i: graph[now]){
                if (!visited[i]) {
                    hasNearNode = true;
                    stack.push(i);
                    visited[i] = true;
                    System.out.print(i + " ");//방문 노드 출력
                    break;
                }
            }
            //반문하지 않은 인접 노드가 없는 경우 해당 노드 꺼내기
            if(hasNearNode==false)
                stack.pop();
        }
        System.out.println();
    }

    void bfs(int [][]graph,int start, boolean [] visited){
        //시작노드
        int now = start;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(now);

        //현재 노드 방문처리.
        visited[now] = true;

        //큐가 빌떄까지 반복.
        while (!queue.isEmpty()){
            //큐에서 하나의 원소를 뽑아 출력
            int v = queue.poll();
            System.out.print(v+" ");

            Arrays.sort(graph[v]);
            for (int i:graph[v]){
                if (!visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int[][] graph = {
                {}
                ,{4, 5, 1}
                ,{1, 2}
                ,{1, 3}
                ,{1, 4}
                ,{2, 4}
                ,{3, 4}
        };

        boolean[] visited = {false, false, false, false, false, false, false, false, false};

        TestMain dfsExam = new TestMain();
        System.out.println("===DFS===");
        dfsExam.dfs(graph, 1, visited);
        System.out.println("=========");

        visited = new boolean[]{false, false, false, false, false, false, false, false, false};

        TestMain bfsExam = new TestMain();
        System.out.println("===BFS===");
        bfsExam.bfs(graph,1,visited);
        System.out.println("=========");
    }
}
