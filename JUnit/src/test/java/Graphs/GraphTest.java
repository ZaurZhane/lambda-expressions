package Graphs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

public class GraphTest {
    @org.junit.jupiter.api.Test
    public void classCheck() {

        // given:
        Graph graph = new Graph(6);

        // expect:
        assertThat(graph, instanceOf(Graph.class));

    }
}
