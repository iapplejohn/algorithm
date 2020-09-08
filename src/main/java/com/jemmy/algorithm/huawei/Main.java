package com.jemmy.algorithm.huawei;

import java.util.*;
public class Main{
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        String str="";
        StringBuffer sb;
        while(in.hasNext()){
            str = in.nextLine();
            sb = new StringBuffer();
            for(int i =0;i<=25;i++){
                char ch = (char)('a' + i);
                for(int j=0;j< str.length();j++){
                    if (str.charAt(j) == ch || str.charAt(j) == ch - 32) {
                        sb.append(str.charAt(j));
                    }
                }
            }
            for(int i =0;i<str.length();i++){
                char m=str.charAt(i);
                if ((m >= 'a' && m <= 'z') || (m >= 'A' && m <= 'Z')) {
                    continue;
                } else {
                    sb.insert(i, m);
                }
            }
            System.out.println(sb.toString());
        }
    }
}