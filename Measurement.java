import java.util.*;

class Measurement{
  final private int run_number = 5;
  private int[] arr= null;
  public int numofIntervals = 0;
  public HashMap<Integer, Long> time_measure, memory_measure;
  public ArrayList<int[]> size_interval;
  SortingPrecondition sort_class = null;
  

  public Measurement(int[] data, int numofIntervals, SortingPrecondition sort_class){
    this.arr = data;
    this.numofIntervals = numofIntervals;
    this.sort_class = sort_class;
    time_measure = new HashMap<Integer, Long>();
    memory_measure = new HashMap<Integer, Long>();
    size_interval = new ArrayList<int[]>();

    int interval_length = arr.length/numofIntervals;
    for(int i = 0; i < numofIntervals; i++){
      if(i == numofIntervals - 1){
        this.size_interval.add(arr);
      }else{
        this.size_interval.add(Arrays.copyOfRange(arr, 0, interval_length*(i+1)));
      }
    }

  }

  public ArrayList<int[]> get_size(){
    return this.size_interval;
  }

  public HashMap<Integer, Long> Measure_time(){
    long[] temp = new long[run_number];
    for(int i = 0; i < size_interval.size(); i++){
      int[] data = this.size_interval.get(i);
      for(int j = 0; j < run_number; j++){
        temp[j] = singe_time_usge(data);
      }
      this.time_measure.put(data.length, (Long)average(temp));
    }
    return time_measure;

  }

  public HashMap<Integer, Long> Measure_memory(){
    long[] temp = new long[run_number];
    for(int i = 0; i < this.size_interval.size(); i++){
      int[] data = this.size_interval.get(i);
      for(int j= 0; j < run_number; j++){
        temp[j] = singe_memory_usage(data);
      }
      this.memory_measure.put(data.length, (Long)average(temp));
    }
    return memory_measure;
  }

  private static long average(long[] data){
    long result = 0;
    for(int i = 0; i < data.length; i++){
      result += data[i];
    }
    return result/data.length;
  }

  private long singe_time_usge(int[] data){
    long starttime = System.nanoTime();
    this.sort_class.sort(data);
    long time_take = System.nanoTime() - starttime;
    return time_take;
  }

  private long singe_memory_usage(int[] data){
    final long MEGABITE = 1024L * 1024L;
    this.sort_class.sort(data);
    Runtime runtime = Runtime.getRuntime();
    runtime.gc();
    //long memory = (runtime.totalMemory() - runtime.freeMemory())/MEGABITE;
    long memory = (runtime.totalMemory() - runtime.freeMemory());
    return memory;
  }


}