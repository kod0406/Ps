	package ch01;
	
	import java.io.*;
	
	class student{
	    private int grade = 6;
	    private String School = "Jejuelementary";
	    public student(){}
	    public student(String School,int grade){
	        this.School = School;
	        this.grade = grade;
	    }
	    public String toString(){
	        return grade+" grade in "+School+" School\n";
	    }
	}
	
	class Main{
	    public static void main(String args[]) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        student std1 = new student();
	        String data[] = br.readLine().split("  ");
	        String school = data[0];
	        int grade = Integer.parseInt(data[1]);
	        student std2 = new student(school, grade);
	        bw.write(std1.toString());
	        bw.write(std2.toString());
	        bw.flush();
	    }
	}