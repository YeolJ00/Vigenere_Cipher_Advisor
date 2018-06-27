/*
Substitute Cipher*************************************************************************
import java.awt.*;
import java.util.Scanner;
public class Main {
    static Scanner sc= new Scanner(System.in);
    public static void main(String[] args) {
        String text=sc.nextLine();
        String [] key= new String [26];
        int select;
        while(true){
            System.out.printf("\nMenu\n1.Get Frequency\n2.Show Text\n3.Change Key\n4.Get Frequency of Digram\n5.Exit\n");
            select=sc.nextInt();
            switch(select){
                case 1:
                    getFreq(text);
                    break;
                case 2:
                    showText(text, key);
                    break;
                case 3:
                    changeKey(key);
                    break;
                case 4:
                    getdigram(text);
                    break;
                case 5:
                    return;
            }
        }
    }
    static void getFreq(String arr){
        int len=arr.length();
        double [] freq=new double[26];
        for(int i=0;i<len;i++){
            freq[arr.charAt(i)-'A']++;
        }
        for(int i=0;i<26;i++){
            freq[i]=freq[i]/len;
            System.out.printf("%c = %.2f\n",(char)(i+'A'),freq[i]*100);
        }
    }
    static void showText(String arr, String [] key){
        System.out.println(arr);
        for(int i=0;i<arr.length();i++){
            if(key[arr.charAt(i)-'A']==null){
                System.out.print("-");
            }else{
                System.out.print(key[arr.charAt(i)-'A']);
            }
        }
    }
    static void changeKey(String key[]){
        System.out.println("Enter \"A\" to \"b\"");
        char a=sc.next().charAt(0);
        String b=sc.next();
        key[a-'A']=b;
    }
    static void getdigram(String arr){
        String [] dig=new String[arr.length()-1];
        int[] ndig= new int [arr.length()];
        String temp;
        int t;
        for(int i=0;i<arr.length()-1;i++){
            try {
                temp = arr.substring(i, i + 2);
            }catch(ArrayIndexOutOfBoundsException e){
                temp= arr.substring(i);
            }
            for(int j=0;j<arr.length()-1;j++){//같은게 있으면 일단 숫자 ++
                try {
                    if (temp.equals(dig[j])) {
                        ndig[j]++;
                        temp = null;
                    }
                }catch(NullPointerException e){
                    continue;
                }
            }
            if(temp != null){//같은게 없을때
                for(int j=0;j<arr.length()-1;j++){
                    if(dig[j]==null){
                        dig[j]=temp;
                        ndig[j]++;
                        break;
                    }
                }
            }
        }
        for(int i=0;i<arr.length();i++){
            for(int j=0;j<arr.length()-1-i;j++){
                if(ndig[j]<ndig[j+1]){
                    t=ndig[j+1];
                    ndig[j+1]=ndig[j];
                    ndig[j]=t;
                    temp=dig[j];
                    dig[j]=dig[j+1];
                    dig[j+1]=temp;
                }
            }
        }
        for(int i=0;i<arr.length()-1;i++){
            if(dig[i]==null)
                continue;
            System.out.printf("%s = %d\n",dig[i],ndig[i]);
        }
    }
}*//*
import java.util.Scanner;
public class Main{
    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        String text=sc.nextLine();
        while(true){
            System.out.print("Enter key length: ");
            int len=sc.nextInt();
            if(len==-1)
                return;
            String[] sub= new String[len];
            int []key=new int[len];
            for(int i=0;i<text.length();i++){//분할.
                if(sub[i%len]==null){
                    sub[i%len]=String.valueOf(text.charAt(i));
                }
                sub[i%len]=sub[i%len]+text.charAt(i);
            }
            for(int i=0;i<len;i++){
                System.out.println(sub[i]);
            }
            System.out.printf("Enter %d keys",len);
            for(int i=0; i<len;i++){
                key[i]=sc.nextInt();
            }
            for(int i=0;i<len;i++){
                for(int j=0;j<sub[i].length();j++){
                    if(key[i]==99)//모를 때는 99
                        System.out.print("-");
                    else{
                        System.out.printf("%c",(sub[i].charAt(j)-'A'-key[i])<0?(sub[i].charAt(j)-'A'-key[i])+26+'A':(sub[i].charAt(j)-'A'-key[i])+'A');
                    }
                }
                System.out.println();
            }
        }
    }
}*/