package com.company;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    public static CharSequence numbers = "0123456789";
    public static CharSequence lower_case = "abcdefghijklmnopqrstuvwxyz";
    public static CharSequence upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static CharSequence special_characters = "!@#$%^&*()-+";
    /*
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING password
     */
    public static boolean containsNumbers(String password){
        for(int i = 0; i != numbers.length(); i++){
            if(password.contains(numbers.subSequence(i, i + 1))) return true;
        }
        return false;
    }

    public static boolean containsLowercase(String password){
        for(int i = 0; i != lower_case.length(); i++){
            if(password.contains(lower_case.subSequence(i, i + 1))) return true;
        }
        return false;
    }

    public static boolean containsUppercase(String password){
        for(int i = 0; i != upper_case.length(); i++){
            if(password.contains(upper_case.subSequence(i, i + 1))) return true;
        }
        return false;
    }

    public static boolean containsSpecial(String password){
        for(int i = 0; i != special_characters.length(); i++){
            if(password.contains(special_characters.subSequence(i, i + 1))) return true;
        }
        return false;
    }

    public static int minimumNumber(int n, String password) {

        // Return the minimum number of characters to make the password strong
        int num = 0;
        if(!containsNumbers(password)) num++;
        if(!containsLowercase(password)) num++;
        if(!containsUppercase(password)) num++;
        if(!containsSpecial(password)) num++;

        return Math.max(num, 6 - n);
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result.minimumNumber(n, password);

        System.out.println(String.valueOf(answer));
        bufferedReader.close();
    }
}