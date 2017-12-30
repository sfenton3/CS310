import java.util.*;

public class q2{
  public static void main(String[] args){
    String abr = "abracadabra";
    String arr[] = storeIt(abr);
    
    
   /* System.out.println("Rotations");
    System.out.println("------------");
    for(int i=0; i<arr.length;i++)
      System.out.println(arr[i]);
    System.out.println();*/
    
    
    
    arr = compare(arr);
    System.out.println("Lexographical order        First column           Last Column      ");
    for(int i=0; i<arr.length;i++)
      System.out.println(arr[i] + "                 "  + arr[i].substring(0, 1) + "                              "+ arr[i].substring(arr[i].length()-1));
    
    
  }
  
  public static String[] storeIt(String abr){
    String temp;
    String temp2;
    String arr[] = new String[11];
    arr[0] = abr;
    
    for(int i = 1; i < abr.length(); i++){
      temp = abr.substring(abr.length() - 1);//last char
      temp2 = abr.substring(0,abr.length() - 1);
      abr = temp + temp2;
      arr[i] = abr;
    
  }
    return arr;
  
}
  
  public static String[] compare(String[] arr){
    String temp;
    
    for(int i=0;i<arr.length;i++){
      for(int j=i + 1;j<arr.length;j++){
        if(arr[i].compareTo(arr[j]) > 0)
        {
          temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
          
      }
    }
    
    return arr;
    
    
    
    
}
}
  