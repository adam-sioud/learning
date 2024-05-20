package uke5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TryRegex {

  public static void main(String[] args) {
    Pattern pattern = Pattern.compile("w3schools", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher("Visit W3Schools!");
    boolean matchFound = matcher.find();
    
    if(matchFound) {
      System.out.println("Match found");
    } else {
      System.out.println("Match not found");
    }

    Pattern p2 = Pattern.compile("a.c");
    Matcher m2 = p2.matcher("abcxyazct  a1cdd");
    String s;
    while (m2.find()) {
        s = m2.group();
        System.out.println(s);
    }
  }
}

// Outputs Match found

