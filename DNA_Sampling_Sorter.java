// DNA_Sampling_Sorter, 3/16/25
//
// In main: read the file name and pass the File datatype of that string to the ReadAndWrite
// In ReadAndWrite(File in,File out): Open file and PrintStream to open the DNA sample, read, recieve the result and print the data to the destination file
// In CountDNA: count DNA with a special length at the end;
// In CalcPercent: calculate the percentage to print
// In Compare: this method usage is to determine is it MATCH or NOT

import java.util.*;
import java.io.*;
public class DNA_Sampling_Sorter{
   
   public static int[] CountDNA(String dna){
      // structure: {number of A,number of B,number of C,number of D,number of all valid}
      int[] result = {0,0,0,0,0};
      //int cnt = 0;
      for(int i = 0;i<dna.length();++i){
         if(dna.charAt(i) == 'A'){
            result[0]++;
         }
         if(dna.charAt(i) == 'B'){
            result[1]++;
         }
         if(dna.charAt(i) == 'C'){
            result[2]++;
         }
         if(dna.charAt(i) == 'D'){
            result[3]++;
         }
      }
      result[4] = result[0]+ result[1]+  result[2]+  result[3];
      return result;
   }
   public static int[] CalcPercent(int[] res){
      int[] return_ans = {0,0,0,0};
      for(int i=0;i<res.length-1;++i){
         return_ans[i] = (int) Math.round((((double)res[i])/res[4])*100.0);
      }
      return return_ans;
   }
   public static String Compare(int[] a,int[] b){
      for(int i=0;i<a.length;++i){
         if(a[i] != b[i]){
            return "DIFFERENT";
         }
      }
      return "MATCH";
   }
   public static void ReadAndWrite(File input_file,File output_file){
      PrintStream output = null;
      Scanner input = null;
      try{
         output = new PrintStream(output_file);
         input = new Scanner(input_file);
         while(input.hasNext()){
            String example_index = input.nextLine();
            output.println(example_index);
            String dna_1 = input.nextLine();
            String dna_2 = input.nextLine();
            //to upper all of test to reduce the if statment
            dna_1 = dna_1.toUpperCase();
            dna_2 = dna_2.toUpperCase();
            // pharse the result to the percent by CalcPercent function
            int[] result_1 = CountDNA(dna_1);
            int[] result_2 = CountDNA(dna_2);
            int[] percent_1 = CalcPercent(result_1);
            int[] percent_2 = CalcPercent(result_2);
            
            output.printf("Before: %2d -%2d -%2d -%2d     After: %2d -%2d -%2d -%2d%n", result_1[0], result_1[1], result_1[2], result_1[3], result_2[0], result_2[1], result_2[2], result_2[3]);
            output.printf("Before: %2d%%/%2d%%/%2d%%/%2d%%    After: %2d%%/%2d%%/%2d%%/%2d%%%n", 
                          percent_1[0], percent_1[1],percent_1[2],percent_1[3], 
                           percent_2[0], percent_2[1],percent_2[2],percent_2[3]);
            output.println(" "+Compare(percent_1,percent_2));
            output.println();
         }
         input.close();
         output.close();
      }catch(Exception e){
         System.out.print(e);
         return;
      }
   }
   public static void main(String[] args){
      Scanner input = new Scanner(System.in);
      System.out.println("This program processes a file of DNA structures for various biological samples to determine if a mutation of a particular nature has occurred.");
      System.out.print("Input file name? ");
      String input_name_file = input.nextLine();
      System.out.print("Output file name? ");
      String output_name_file = input.nextLine();
      //System.out.println("In: "+input_name_file+", "+"output: "+output_name_file);
      File input_file = new File(input_name_file);
      File output_file = new File(output_name_file);
      ReadAndWrite(input_file,output_file);
   }
}
