package com.jemmy.algorithm.huawei;

import java.util.LinkedList;
import java.util.Scanner;
public class Main2{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            char[] strA = in.nextLine().toCharArray();
            int count = getCount(strA);
            System.out.println(count);
        }
        
        in.close();
    }
    /**
     * 左右拆盒子次数的最小值
     * @param strA
     * @return
     */
    public static int getCount(char[] strA){
        int left = getLeftCount(strA);
        int right = getRightCount(strA);
        return left>right?right:left;
    }
    /**
     * 右边开始拆
     * ):一次拆盒子，count++
     * (:说明这次是无效的拆盒子，所以count--
     * @param strA
     * @return
     */
    public static int getRightCount(char[] strA){
        if(strA==null||strA.length==0){
            return 0;
        }
        int count = 0;
        LinkedList<Character> stack = new LinkedList<Character>();
        for(int i=strA.length-1;i>=0;i--){
            if(strA[i]=='A'){
                return count;
            }
            if(strA[i]==')'){
                stack.push(')');
                count++;
            }else if(strA[i] == '('){
                stack.pop();
                count--;
            }
        }
        return count;
    }
    /**
     * 左边开始拆
     * (:一次拆盒子，count++
     * ):说明这次是无效的拆盒子，所以count--
     * @param strA
     * @return
     */
    public static int getLeftCount(char[] strA){
        if(strA==null||strA.length==0){
            return 0;
        }
        int count = 0;
        LinkedList<Character> stack = new LinkedList<Character>();
        for(int i=0;i<strA.length;i++){
            if(strA[i]=='A'){
                return count;
            }
            if(strA[i]=='('){
                stack.push('(');
                count++;
            }else if(strA[i] == ')'){
                stack.pop();
                count--;
            }
        }
        return count;
    }
}