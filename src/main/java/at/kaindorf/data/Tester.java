package at.kaindorf.data;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <h3>Created by IntelliJ IDEA.</h3><br>
 * <b>Project:</b> Streams<br>
 * <b>User:</b> Simon Schoeggler<br>
 * <b>Date:</b> 12. April 2023<br>
 * <b>Time:</b> 08:15<br>
 */

public class Tester {
    public static void main(String[] args) {
        // Create a List with Data Objects;
        // value ... random double between 1 and 10 (2 functional digits)
        // year ... random int between 2000 and 2010

        Random random = new Random();

        List<Data> dataList =
                IntStream
                        .range(0, 10)
                        .mapToObj(i -> new Data(random.nextInt(100, 1001) / 100.0, LocalDate.of(random.nextInt(2000,
                                2011), random.nextInt(1, 13), random.nextInt(1, 29))))
                        .sorted(Comparator.comparing(Data::getYear))
                        .toList();

        dataList.forEach(System.out::println);

        dataList.stream().collect(Collectors.groupingBy(data -> data.getYear().getYear())).forEach((year, data) -> {
            /*System.out.println(year + ": " + String.format("%.2f",
                    data.stream().mapToDouble(Data::getValue).average().orElse(0.0)));*/
            System.out.println(year + ": " + data.stream().mapToDouble(Data::getValue).summaryStatistics());
        });
    }
}
