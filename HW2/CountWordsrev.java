import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.*;

public class CountWordsrev {

  public static void main (String args[]) throws Exception{
       FileReader fr = new FileReader("hamlet.txt");        
       BufferedReader br = new BufferedReader(fr);     
       int letter = br.read();
       String[] text = new String[32684];

       //count word and store in text array
       String word = "";
       int count = 0;
       while(letter != -1){
         if((letter > 64 && letter < 91) || (letter > 96 && letter < 123))
           word += (char) letter;
         else if((letter == 32 || letter == 10 || letter == 13) && (word != "")){
           word = word.toLowerCase();
           text[count] = word;
           count++;
           word = "";
         } 
         letter = br.read();       
       } br.close();  
       
       //Store text[] into ht
       HashTableQuad ht = new HashTableQuad();
       for(int i=0; i < text.length; i++){
         if(ht.containsKey(text[i])){
           ht.put(text[i], 1);}
         if(!ht.containsKey(text[i])){
           ht.put(text[i], 1);}
       }
         
       //store ht key and freq into hamletOut
       try{
         int words = ht.getWords();
         PrintWriter writer = new PrintWriter("hamletOut.txt", "UTF-8");
         for(int i=0;i<words;i++){
           writer.println(String.format("%16s", String.format(ht.sort())));}
         writer.close();
       } catch (IOException e) {} 
}
}
