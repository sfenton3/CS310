import java.util.Arrays;

public class HashTableQuad{
  
  private int maxSize = 1031; 
  private String[] key = new String[maxSize];
  private int[] value = new int[maxSize];
  private int currentPrime = 0;
  private int size = 0;
  
  //Intentionally left blank
  public HashTableQuad(){ 
  }
  
  //internal method to help resize array
  private HashTableQuad(int cap){
    maxSize = cap;
    key = new String[maxSize];
    value = new int[maxSize];
    
  }
  //internal method to obtain hash value
  private long hashNum(String keyString){
    return Math.abs(keyString.hashCode()) % maxSize;}
  
  //internal method to resize array
  private void doubleSize(){
    int[] primes = {2063,4127,8263,16529,33071};
    maxSize = primes[currentPrime];
    HashTableQuad temp = new HashTableQuad(maxSize);
    
    for(int i=0;i<key.length;i++){
      if(key[i] != null){
        temp.put(key[i],value[i]);
      }
    }
    //copy back into original arrays  
    key = Arrays.copyOf(temp.key, maxSize);
    value = Arrays.copyOf(temp.value, maxSize);
    currentPrime++;
  }
  
  //return true or false for key string..Find using hash method
  public boolean containsKey(String keystring){
    int k = (int) hashNum(keystring);
    int i = 1;
    while(key[k] != null){
      if(key[k].equals(keystring))
        return true;
      k =(k + i * i) % maxSize;
      i++;
    }
    return false;
  }
  
  //return value associated with key. Find using hash method
  public int get(String keystring){
    int k = (int) hashNum(keystring);
    int i = 1;
    while(key[k] != null){
     if(key[k].equals(keystring))
       return value[k];
     k = (k + i * i) % maxSize;
     i++;
    }
    return 0;
  }

  //Add string and value to ht, rehash if collision
  public void put(String keyString, int valString){
    if(size >= .5*maxSize)
      doubleSize();
    
    int k = (int)hashNum(keyString);
    int i = k, h = 0;
    
    while(true){
      i = (i + (h * h)) % maxSize;
      if(key[i] == null){
        key[i] = keyString;
        value[i] = valString;
        size++;
        return;
      }
      if(key[i].equals(keyString)){
        value[i] += valString;
        return;
      }
      h++;
           
  }
  }
  
  //Get current word count  
  public int getWords(){
    return size;
  }
  
  //print key-val pair in order
  public String sort(){
    int current, max = 0, index = 0;
    
    for(int i=0;i<value.length;i++){
      if(value[i] == 0)
        continue;
      current = value[i];
      if(current > max){
        max = current;
        index = i;
      }
      if(current == max){
        if(key[i].compareTo(key[index]) > 0)
          ;
        else{
          max = current;
          index = i;}
      }
      }
      String maxFreq =(key[index] + "    " + value[index]);
      key[index] = null;
      value[index] = 0;
      return maxFreq;
    }
  
  //test case
  public static void main(String[] args){
    System.out.println("that".compareTo("this"));
  }
}



       
          
    
  

  

  
  
 