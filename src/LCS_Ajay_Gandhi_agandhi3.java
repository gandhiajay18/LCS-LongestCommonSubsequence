import java.io.FileOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.io.IOException;
import static java.lang.System.exit;


public class  LCS_Ajay_Gandhi_agandhi3
    {    
        public String LongestCommonSubSequence(String word1, String word2)      //function to calculate the longest common subsequence
        {
            int len1,len2,n=0,m=0;
            len1 = word1.length();
            len2 = word2.length();
            //int[][] path= new int[len1+1][len2+1];
            int[][] sequence = new int[len1+1][len2+1];                         //2d array to perform LCS operation
            StringBuffer str = new StringBuffer();                         //initialize a string buffer to store the sequence
        
            
        for(int i=0;i<=len1;i++)                                                //initialize the initial sequence to 0
        {
         sequence[i][0]=0;
        }
        for(int j=0;j<=len2;j++)
        {
         sequence[0][j]=0;
        }
            
        for (int i = len1 - 1; i >= 0; i--)                                     //algorithm to find the longest common sub sequence
        {
            for (int j = len2 - 1; j >= 0; j--)
            {
                if (word1.charAt(i) == word2.charAt(j))
                { sequence[i][j] = sequence[i + 1][j + 1] + 1;                  
                    //path[i][j]=1;
                }
                else if(sequence[i][j+1]>=sequence[i+1][j])
                {
                    sequence[i][j] = sequence[i][j+1];
                    //path[i][j]=2;
                }
                else
                {
                    sequence[i][j]=sequence[i+1][j];
                    //path[i][j]=3;
                }
            }
        }


        do                                                                  //loop to recover the actual subsequence
        {
            //if (word1[m]==word2[n])
            if (word1.charAt(m) == word2.charAt(n))                         //if common character
            {
                 str.append(word2.charAt(n));                               //add the character to the sequence
                //str = str+word1[m];                         
                m++;n++;
            }
            else if (sequence[m+1][n] >= sequence[m][n+1]) 
                m++;
            else if (sequence[m+1][n] <= sequence[m][n+1])
                n++;
        }while(m < len1 && n < len2);                                       //terminating condition
        return str.toString();                                         //return the result
    }

    public static void main(String[] args) throws IOException
    {    
        Scanner in = new Scanner(new File("input5.txt"));                   //to read the specified input file
        String outputfilename = "output.txt";                                  //to create the specified output file
        String str1;                                                        //create string to store input 
        String str2;                                                        //create string to store input
        BufferedWriter bufferedwriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputfilename), "UTF-8"));    //to create a buffered writer to write to the output file
        str1 = in.nextLine();                                               //read string1 from first line
        str2 = in.nextLine();                                               //read string2 from second line

// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       // System.out.println("\nEnter string 1");
        //String str1 = br.readLine();
        //System.out.println("\nEnter string 2");
        //String str2 = br.readLine();
        LCS_Ajay_Gandhi_agandhi3 lcs_obj = new LCS_Ajay_Gandhi_agandhi3();                                            //create an object 
        String result = lcs_obj.LongestCommonSubSequence(str1, str2);       //get resulting subsequence from the function
        if(result.length()==0)                                              //Handle No LCS condition
        {
        System.out.println(result.length());                                
        System.out.println("NULL");
        bufferedwriter.write(result.length()+"\t");                         
        bufferedwriter.newLine();                                           
        bufferedwriter.write("NULL");                                       
        bufferedwriter.close(); 
        exit(0);
        }
        System.out.println(result.length());                                //Print the length of the string
        System.out.println(result);                                         //Print the actual string
        bufferedwriter.write(result.length()+"\t");                         //Write the resulting length to the output file
        bufferedwriter.newLine();                                           
        bufferedwriter.write(result);                                       //Write the actual subsequence to the output file
        bufferedwriter.close();                                             //close the bufferedwriter to save the file
    }
}