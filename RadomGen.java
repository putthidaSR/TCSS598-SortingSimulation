import java.util.*;

class RandomGen{
  private int num = 0;
  private int range = 0;
  Random rand;

  RandomGen(int num, int range){
    this.num = num;
    this.range = range;
    rand = new Random();
  }

  public int[] rand_genarate(){
    int[] arr = new int[num];
    for(int i = 0; i < num; i++){
      arr[i] = this.rand.nextInt(range);
    }
    return arr;
  }

}