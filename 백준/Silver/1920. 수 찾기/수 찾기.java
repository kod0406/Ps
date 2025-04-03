import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


class Search {
    public int Find_num(int arr[], int first, int last, int find) {
        if (last >= first) {
            int mid = first + (last - first) / 2;
            if (find < arr[mid]) {
                return Find_num(arr, first, mid - 1, find);
            } else if (find > arr[mid]) {
                return Find_num(arr, mid + 1, last, find);
            } else {
                return 1;
            }
        } else {
            return 0;
        }
    }
}

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int a_1 [] = new int[a];
        for(int i=0;i<a;i++){
            a_1[i] = Integer.parseInt(st.nextToken());
        }
        int b = Integer.parseInt(br.readLine());
        int b_1 [] = new int[b];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<b;i++){
            b_1[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(a_1);
        Search search = new Search();
        for(int i=0;i<b;i++){
            int result = search.Find_num(a_1, 0, a - 1, b_1[i]);
            bw.write(Integer.toString(result));
            bw.newLine();
        }
        bw.flush();
    }
}