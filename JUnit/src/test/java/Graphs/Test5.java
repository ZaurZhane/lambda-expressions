package Graphs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

public class Test5 {
    @org.junit.jupiter.api.Test
    public void test5() {
        Graph graph = new Graph(6);
        assertThat(graph, instanceOf(Graph.class));
    }
}
