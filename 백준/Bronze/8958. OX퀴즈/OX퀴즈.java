import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			int rst = 0;
			int streak = 1;
			String input = br.readLine();
			for(int j=0;j<input.length();j++) {
				if(input.charAt(j) == 'O') {
					rst += streak++;
				}
				else {
					streak = 1;
				}
			}
			bw.write(String.valueOf(rst)+"\n");
		}
		bw.flush();
	}
}
