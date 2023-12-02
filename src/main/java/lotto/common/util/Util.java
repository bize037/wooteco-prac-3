package lotto.common.util;

import java.util.List;
import java.util.stream.Collectors;

public class Util {
    public static List<Integer> convertStringListToIntegerList(List<String> stringList) {
        return stringList.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
