import java.io.*;

class Student{
	private String Name;
	private String School;
	private int age;
	Student(String Name,String School,int age){
		this.Name = Name;
		this.School = School;
		this.age = age;
	}
	public String toString() {
		return "Name : "+this.Name+"\n"+"School : "+this.School+"\n"+"Grade : "+this.age;
	}
}

class Main{
	
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    	String input[] = br.readLine().split(" ");
    	Student std = new Student(input[0],input[1],Integer.parseInt(input[2]));
    	bw.write(std.toString());
        bw.flush();
    }
}
    