import java.util.Random;

public class ModNumSolver {
  static final int TIMES_RUN=20;
  static int[] counter;
  public static void main(String[] args) {
    counter  = new int[5];
    
    for(int x=0;x<TIMES_RUN;x++){
      Random rn = new Random();
      int i = Math.abs(rn.nextInt() % 5);
      counter[i]+=1;
      i+=1;
      if(i>5)
        System.out.println("Meh");
      else
        System.out.println("Num: " + i);
    }
    
    System.out.println();
    
    for(int x=0;x<5;x++){
      System.out.println((x+1)+" came up: "+counter[x]);
    }
  }
}