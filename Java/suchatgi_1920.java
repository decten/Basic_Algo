import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class suchatgi_1920 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        
        int m = Integer.parseInt(br.readLine());
        int[] compare = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            compare[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<m; i++){
            System.out.println(binarySearch(input, compare[i]));
        }
    }
    public static int binarySearch(int[] input, int compare){
        int start = 0;
        int end = input.length-1;		
        int mid;
        while(start <= end) {
            mid =  (start + end) / 2;
            if(input[mid] == compare) return 1;
            else if(input[mid] < compare) {
                start = mid + 1;			
            }			
            else if(input[mid] > compare) {				
                end = mid - 1;			
            }		
        }
        return 0;
    }
}
