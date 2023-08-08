package hash;

import org.hamcrest.Matchers;

import java.util.ArrayList;
import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;

public class SearcherTest {
    @org.junit.jupiter.api.Test
    public void patternSearch() {

        // given:
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(14);
        expected.add(16);

        String source = "Alibaba or Alibubab? I do not know!";
        String pattern = "b*b";

        // when:
        Searcher searcher = new Searcher();
        List<Integer> result = searcher.search(source, pattern);

        // then:
        // тест 1
        //Assertions.assertIterableEquals(expected, result);
        // тест 2
        assertThat(result, Matchers.is(expected));
    }



}
