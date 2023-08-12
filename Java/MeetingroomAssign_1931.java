import java.util.*;
import java.io.*;

public class MeetingroomAssign_1931 {
    static int N;
    //배열 형태의 List
    static List<int[]> a = new ArrayList<>();
    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        for (int i = 0; i < N; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            a.add(new int[] {x,y});
        }
        //도착 시간이 빠른 것, 늦게 시작하는 것
        Collections.sort(a,(x,y)->
        {
            return x[1] == y[1] ? y[0]-x[0] :x[1]-y[1];
        });
    }
    static void solve(){
        PriorityQueue <Integer> meeting = new PriorityQueue<>();
        meeting.add(a.get(0)[1]);

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int[] rooms = a.get(i);

            if(rooms[0] >= meeting.poll()){
                cnt++;
                meeting.add(rooms[i]);
            }

        }
        System.out.println(cnt);
    }
    public static void main(String[] args){
        input();
        solve();
    }
    static class FastReader{
        StringTokenizer st;
        BufferedReader br;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null||!st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
