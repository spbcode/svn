package com.micro.configserver;

public class StringSample {

    public static void main(String args[]){
//        String str = "abc";
//        System.out.println(isPalindrome(str,0,str.length()-1));

        int[] intarr = new int[] {0,1,2,2,3,0,4,2};
        int target = 2;
        int s = 0;
        while(s<intarr.length){
            if(intarr[s]==target){
                break;
            }
            s++;
        }
        int e = 0;

        while(e<intarr.length){
            if (intarr[e] != target) {
                  intarr[s++] = intarr[e];
            }
            e++;
        }
        for(int i=0;i<s;i++){
            System.out.println(intarr[i]);
        }

    }

    public static boolean isPalindrome(String str,int startidx,int endidx){


        if(str.charAt(startidx)!=str.charAt(endidx)){
            return false;
        }
        boolean flag = true;
        startidx=startidx+1; //1
        endidx=endidx-1; //1
        if(startidx <= endidx) {
            flag = flag && isPalindrome(str, startidx, endidx);
        }
        return flag;
    }


}
