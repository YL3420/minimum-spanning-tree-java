package github.com.YL3420.mst_learn_.graph;

public interface Edge<VertexType> {

    //
    VertexType v1();

    //
    VertexType v2();

    //
    VertexType getOther(VertexType v);

    //
    double weight();
}
