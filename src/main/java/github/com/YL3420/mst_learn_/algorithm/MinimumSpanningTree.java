package github.com.YL3420.mst_learn_.algorithm;

import github.com.YL3420.mst_learn_.graph.MinHeap;
import github.com.YL3420.mst_learn_.graph.SpanningTree;
import github.com.YL3420.mst_learn_.graph.UndirectedGraph.GraphEdge;
import github.com.YL3420.mst_learn_.graph.UndirectedGraph.GraphVertex;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumSpanningTree {

    public SpanningTree solution;

    public MinimumSpanningTree(){
        solution = new SpanningTree(new ArrayList<>(List.of()), new ArrayList<>(List.of()));
    }

    /*
        make a new SpanningTree
     */
    public void makeGraph(ArrayList<GraphVertex> v, ArrayList<GraphEdge> e){
        solution = new SpanningTree(v, e);
        solution.visitedEdges = new ArrayList<>();
    }

    /*
        perform Prim's algorithm on the spanning tree
        incorporated edges in solution.visitedEdges and the smallest possible
        cost for the MST is solution.mstWeight
     */
    public void runPrims(GraphVertex root){
        // this assert is rlly slow so might get rid of it
        assert solution.isSpanningTree();
        assert solution.vertices.contains(root);

        solution.mstWeight = 0;

        /*
            visited set allows us to track visited nodes with contains()
            min heap allows us to sort edges by priority and construct using
            Prim's algorithm
         */
        Set<GraphVertex> visited = new HashSet<>();
        MinHeap<GraphEdge> candidateEdges = new MinHeap<>();

        /*
            mark starting node as visited and add all of its outgoing edges to the min heap
         */
        visited.add(root);
        for(GraphEdge e : root.outGoingEdges())
            candidateEdges.addOrUpdate(e, e.weight());

        while(visited.size() != solution.vertices.size()){
            GraphEdge chosenEdge = candidateEdges.extractMin();

            /*
                the edge to be incorporated into the solution can only be used
                if its destination node doesn't land on an already visited node,
                this also prevents the formation of a cyclic in our MST
             */
            while(visited.contains(chosenEdge.v1()) && visited.contains(chosenEdge.v2())){
                chosenEdge = candidateEdges.extractMin();
            }

            /*
                set destination of the shortest outgoing edge as visited
             */
            GraphVertex added = (visited.contains(chosenEdge.v1())) ? chosenEdge.v2() : chosenEdge.v1();
            visited.add(added);

            solution.mstWeight += chosenEdge.weight();
            solution.visitedEdges.add(chosenEdge);

            /*
                add all outgoing edges of the newly visited node to the min heap
                for future considerations
             */
            for(GraphEdge e : added.outGoingEdges())
                candidateEdges.addOrUpdate(e, e.weight());

        }
    }
}
