import java.io.*;
/***********************************************************************
 * Project Name: CCC07J2
 *
 * Author: YZmS Lemonsity
 *
 * Date: Feb 5, 2019
 *
 * Purpose: Solving 2007 CCC J2
 *
 ***********************************************************************
 *  Status: Completed
 *
 */
public class CCC07J2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        do {
            input = br.readLine();
            System.out.print(translate(input) + "\n");
        } while (!input.equals("TTYL"));
    }
    public static String translate(String text) { // literally hashMap, but I'm too lazy to do hashMap
        if (text.equals("CU"))
            return "see you";
        else if (text.equals(":-)"))
            return "I'm happy";
        else if (text.equals(":-("))
            return "I'm unhappy";
        else if (text.equals(";-)"))
            return "wink";
        else if (text.equals("(~.~)"))
            return "sleepy";
        else if (text.equals("TA"))
            return "totally awesome";
        else if (text.equals("CCC"))
            return "Canadian Computing Competition";
        else if (text.equals("CUZ"))
            return "because";
        else if (text.equals("TY"))
            return "thank-you";
        else if (text.equals("YW"))
            return "you're welcome";
        else if (text.equals("TTYL"))
            return "talk to you later";
        return text;
    }
}
