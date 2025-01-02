import java.io.*;
	
class Main{

	    public static void print(int n,BufferedWriter bw)throws IOException{
	        for(int i=0;i<n;i++){
	            bw.write("~!@#$^&*()_+|");
	            bw.newLine();
	        }
	        bw.flush();
	    }
	    public static void main(String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        int n = Integer.parseInt(br.readLine());
	        print(n,bw);
	    }
	}