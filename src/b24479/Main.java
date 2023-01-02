package b24479;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int vertexCount = scanner.nextInt();
        int edgeCount = scanner.nextInt();

        int startVertex = scanner.nextInt() - 1;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < vertexCount; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i < vertexCount; i++) {
            Collections.sort(graph.get(i));
        }

        int[] answer = new int[vertexCount];
        dfs(startVertex, graph, answer);

        for (int i : answer) {
            System.out.println(i);
        }
    }

    static int index = 1;

    private static void dfs(int v, List<List<Integer>> graph, int[] answer) {
        if (answer[v] != 0) return;
        answer[v] = index++;

        for (int vv : graph.get(v)) {
            if (answer[vv] != 0) continue;
            dfs(vv, graph, answer);
        }
    }
}
