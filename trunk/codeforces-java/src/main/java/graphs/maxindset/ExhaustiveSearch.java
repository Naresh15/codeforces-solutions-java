package graphs.maxindset;

import java.util.List;
import java.util.Set;

import org.testng.collections.Sets;

public class ExhaustiveSearch {

    public Set<Set<Integer>> solve(Graph graph) {
        if (graph.size() == 0) {
            Set<Integer> a = Sets.newHashSet();
            Set<Set<Integer>> res = Sets.newHashSet();
            res.add(a);
            return res;
        }
        Set<Set<Integer>> resu = Sets.newHashSet();
//        List<Integer> allVertices = graph.allVertices();

        int v = graph.randomVertex();
//        for (int v : allVertices) {
            // not taking the vertex
            Graph g1 = graph.removeVertex(v);
            Set<Set<Integer>> left = solve(g1);

            // taking the vertex
            Graph g2 = graph.removeVertexWithAdjacent(v);
            Set<Set<Integer>> right = solve(g2);

            resu.addAll(left);
            for (Set<Integer> fromR : right) {
                Set<Integer> set = Sets.newHashSet(fromR);
                set.add(v);
                resu.add(set);
            }
//        }
        return resu;
    }
}
