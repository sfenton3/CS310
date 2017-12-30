public class permute{
  
  public static int n;
  public static int alg;
  public static int count;
  public static char p[] = new char[27];
  public static int table[][] = 
  {{0}, {0, 1}, {0, 1, 1}, {0, 1, 2, 3},
    {0, 3, 1, 3, 1},
    {0, 3, 4, 3, 2, 3},
    {0, 5, 3, 1, 5, 3, 1},
    {0, 5, 2, 7, 2, 1, 2, 3},
    {0, 7, 1, 5, 5, 3, 3, 7, 1},
    {0, 7, 8, 1, 6, 5, 4, 9, 2, 3},
    {0, 9, 7, 5, 3, 1, 9, 7, 5, 3, 1},
    {0, 9, 6, 3, 10, 9, 4, 3, 8, 9, 2, 3}};
  
  //Permute constructor to fill table with A-Z
  public static void init(){
    p[0] = '*';
    char temp = 'A';
    for(int i=0; i<26; i++)
      p[i+1] = temp++;
    
  }
  //Use command line argument to invoke permute alg and N value
  public static void main(String[] args){  
    init();
    permute3(3);

    
  }
  //Choos which algorithm to use
  public static void permuteChoose(int alg, int n){
    if(alg == 1)
      permute1(n);
    else if(alg == 2)
      permute2(n);
    else if(alg == 3)
      permute3(n);
    else
      permute1(n);
    
  }
  //Comment out code for performance
  public static void printIt(){

    for(int i=1; i<=n; i++)
     System.out.print(p[i]);
    
    System.out.println();
    count++;
 
  }
  //Swap two chars in table
  public static void swap(int i, int j){
    char c;
    
    c = p[i];
    p[i] = p[j];
    p[j] = c; 
  }
  
  //Slower permute method, but more human readable
  public static void permute1(int n){    
    if(n == 1){
 printIt();
    }
    for(int i=1; i<=n; i++){
      swap(i, n);
      permute1(n - 1);
      swap(i, n);
    }
  }
  
  //Array out of bounds exception at n = 12
  public static void permute2(int n){
    if(n == 1){
 printIt();
 return;
    }
    for(int i=1; i<=n; i++){
      permute2(n -1);
      swap(table[n][i], n);
    }
  }
  
  //Quicker method, But output is non-intuitive to human readers
  public static void permute3(int n){
    if(n == 1){
      printIt();
      return;
    }
    for(int i=1; i<=n; i++){
      permute3(n - 1);
      //System.out.println(n);
      swap(((n & 1) == 0) ? 1 : i, n);
    }
  } 
}
