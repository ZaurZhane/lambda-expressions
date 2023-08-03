package Hash;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;


import java.util.ArrayList;
        import java.util.List;

public class Test3 {
    @org.junit.jupiter.api.Test
    public void testConcat_validArgument_success() {

        // given:
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(14);
        expected.add(16);

        String source = "Alibaba or Alibubab? I do not know!";
        String pattern = "b*b";

        List<Integer> result = search(source, pattern);

        Assertions.assertIterableEquals(expected, result);


    }

    public static List<Integer> search(String source, String pattern) {

        List<Integer> found = new ArrayList<>();

        if (source.length() < pattern.length()) {

            System.out.print("Такой подстроки точно нет!");

            return found;

        }

        int patternHash = 0;
        int asterikPosition = 0;

        for (int i = 0; i < pattern.length(); i++) {

            char c = pattern.charAt(i);

            if (c != '*') {
                patternHash = patternHash + (int) c;

            } else {
                asterikPosition = i;
            }

        }

        int windowHash = 0;
        int oldPosition = 0;

        for (int start = 0; start < source.length() - pattern.length() + 1; start++) {

            if (start == 0) {

                for (int i = 0; i < pattern.length(); i++) {
                    windowHash = windowHash + (int) source.charAt(i);
                }

                windowHash -= source.charAt(start + asterikPosition);

            } else {

                windowHash -= source.charAt(start - 1);
                windowHash += source.charAt(start + pattern.length() - 1);
                windowHash += source.charAt(oldPosition);
                windowHash -= source.charAt(start + asterikPosition);

            }

            oldPosition = start + asterikPosition;

            if (windowHash == patternHash) {

                boolean valid = true;

                for (int i = 0; i < pattern.length(); i++) {

                    if (pattern.charAt(i) != '*' && source.charAt(start + i) != pattern.charAt(i)) {
                        valid = false;
                        break;
                    }

                }

                if (valid) {
                    found.add(start);
                }
            }
        }
        return found;
    }

}
