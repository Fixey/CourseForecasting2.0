package ru.liga;

import com.github.sh0nk.matplotlib4j.Plot;
import com.github.sh0nk.matplotlib4j.PythonExecutionException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class FileReaderTest {

    @Test
    void getListLinesFromFile() throws PythonExecutionException, IOException {
        Random rand = new Random();
        List<Double> x1 = IntStream.range(0, 100).mapToObj(i -> rand.nextGaussian())
                .collect(Collectors.toList());
        List<Double> x2 = IntStream.range(0, 100).mapToObj(i -> 4.0 + rand.nextGaussian())
                .collect(Collectors.toList());

        Plot plt = Plot.create();
        plt.hist().add(x1).add(x2).bins(20).stacked(true).color("#66DD66", "#6688FF").range(3, 5);
        plt.xlim(-6, 10);
        plt.title("histogram");
        plt.legend().loc("upper right");
        plt.show();
        plt.savefig("./src/main/resources/histogram.png");
        plt.executeSilently();

    }
}
