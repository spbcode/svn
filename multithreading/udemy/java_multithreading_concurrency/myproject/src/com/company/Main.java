package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String str = "asdfg";
        String str2 = "qwer";
        String str3 = "zxcv";
        String str4 = "yuio";
        String str5 = str+str2+str3+str4;
        System.out.println(str5);
        MyStringBuilder stringBuilder = new MyStringBuilder();
        stringBuilder.append(str).append(str2).append(str3)
                .append(str4);
        System.out.println(stringBuilder.toString());
    }

    static class MyStringBuilder{

        public MyStringBuilder() {
        }
        private List<Character> stringchars=new ArrayList<Character>();
        private char[] chars = new char[0];

        public MyStringBuilder append(String value){
            char[] newchars = new char[value.length()+chars.length];
            for(int i=0;i<chars.length;i++){
                newchars[i]=chars[i];
            }
            char[] strCHar = value.toCharArray();
            int j=0;
            for(int i=chars.length;i<newchars.length;i++){
                newchars[i]=strCHar[j++];

            }
            chars=newchars;
            return this;
        }

        public String toString(){
            return new String(chars);
        }

    }
}
