package github.com.YL3420.mst_learn_.graph;

public interface Vertex<EdgeType extends Edge<?>> {

    /*
        an iterable for all the outgoing edges that starts from the selected vertex
     */
    Iterable<EdgeType> outGoingEdges();
}
