package wholeMagicThere;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SortIntegers {
    public static void main(String[] args) {
        if (args.length > 10 || args.length == 0) throw new IllegalArgumentException();

        ArrayList<Integer> integers = Arrays.stream(args).map(Integer::valueOf).sorted(Comparator.naturalOrder()).collect(Collectors.toCollection(ArrayList::new));
        System.out.print(integers);
    }
}
