import java.util.*;

//import com.sun.org.apache.xpath.internal.functions.Function;

/*
* data1: 10000, 1000000
* data2: 1000, 100
* data3: Boarder_raw_data
* data4: Longdon
*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

class Main {
  public static void main(String[] args) {
    int numofIntervals = 20;

    RandomGen rand1=new RandomGen(1000, 100);
    //int[] data = rand1.rand_genarate();
    int[] data = readCSV("Longdon_shared_bike.csv");
    //data = Arrays.copyOfRange(data, 0, data.length/30);
    System.out.println(data.length);

    SortingPrecondition bubble = new BubbleSort(data);
    //SortingPrecondition quick = new QuickSort(data);
    //SortingPrecondition selection = new SelectionSort(data);
    //SortingPrecondition merge = new MergeSort(data);
    //SortingPrecondition insertion = new InsertionSort(data);
    SortingPrecondition[] sort_methods = new SortingPrecondition[4];
    sort_methods[0] = new QuickSort(data);
    sort_methods[1] = new SelectionSort(data);
    sort_methods[2] = new MergeSort(data);
    sort_methods[3] = new InsertionSort(data);

    HashMap<Integer, ArrayList<Long>> memory_usage = new HashMap<Integer, ArrayList<Long>>();
    HashMap<Integer, ArrayList<Long>> time_usage = new HashMap<Integer, ArrayList<Long>>();

    Measurement test_measure = new Measurement(data, numofIntervals, bubble);
    HashMap<Integer, Long> memory_temp = test_measure.Measure_memory();
    HashMap<Integer, Long> time_temp = test_measure.Measure_time();
    Set<Integer> memory_key = memory_temp.keySet();
    for(Integer key : memory_key){
      memory_usage.put(key, new ArrayList<Long>());
      time_usage.put(key, new ArrayList<Long>());
    }
    merge_map(memory_usage, memory_temp);
    merge_map(time_usage, time_temp);

    for(SortingPrecondition method : sort_methods){
      test_measure = new Measurement(data, numofIntervals, method);
      memory_temp = test_measure.Measure_memory();
      time_temp = test_measure.Measure_time();
      merge_map(memory_usage, memory_temp);
      merge_map(time_usage, time_temp);
    }

    System.out.println(memory_usage);
    System.out.println(time_usage);
    hasmap_to_csv(memory_usage, "data4_memory.csv");
    hasmap_to_csv(time_usage, "data4_time.csv");


  }

  public static int[] readCSV(String path){
    Path csv_path = Paths.get(path);
    int[] arr=null;
    try(BufferedReader br = Files.newBufferedReader(csv_path)){
      String line = br.readLine();
      String[] str_arr = line.split(",");
      arr=new int[str_arr.length];
      for(int i=0; i < str_arr.length; i++){
        String num = str_arr[i];
        num = num.substring(1);
        num = num.substring(0, num.length()-1);
        arr[i] = Integer.valueOf(num);
      }
    }catch(IOException er){
      er.printStackTrace();
    }
    return arr;
  }

  public static void merge_map(HashMap<Integer, ArrayList<Long>> usage, HashMap<Integer, Long> temp){
    for(Map.Entry item: temp.entrySet()){
      Integer key = (Integer)item.getKey();
      Long value = (Long)item.getValue();
      ArrayList<Long> usage_value = usage.get(key);
      usage_value.add(value);
    }
  }

  public static void hasmap_to_csv(HashMap<Integer, ArrayList<Long>> map, String path){
    String eol = System.getProperty("line.separator");

    try (Writer writer = new FileWriter(path)) {
      Set<Integer> Keys = map.keySet();
      Integer[] keys = Keys.toArray(new Integer[Keys.size()]);
      for(Integer key : keys){
        writer.write(key.toString());
        writer.write(",");
      }
      writer.write(eol);
      for(int j = 0; j < map.get(keys[0]).size(); j++){
        for(int i = 0; i < keys.length; i++){
          writer.write(map.get(keys[i]).get(j).toString());
          writer.write(",");
        }
        writer.write(eol);
      }
    } catch (IOException ex) {
      ex.printStackTrace(System.err);
    }
  }
}