package ch01;

import java.io.*;

class Main{
    public static void main(String args[])throws IOException{
        int a= -100;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(a));
        bw.flush();
        }
}