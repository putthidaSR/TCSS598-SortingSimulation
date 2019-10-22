import java.util.*;

class Main {
  public static void main(String[] args) {
    int numofIntervals = 20;

    RandomGen rand1=new RandomGen(5000000, 100000);
    int[] data = rand1.rand_genarate();
    System.out.println(data.length);

    Measurement test_measure = new Measurement(data, numofIntervals);
    HashMap<Integer, Long> memory_usage = test_measure.Measure_memory();
    HashMap<Integer, Long> time_usage = test_measure.Measure_time();
    System.out.println(memory_usage);
    System.out.println(time_usage);

  }
}