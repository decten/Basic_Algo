import java.util.*;
import java.io.*;
public class ClassroomAssign_11000 {
    //2번의 정렬: 시작 시간으로 먼저 정렬한 후 종료 시간 빠른 걸 가져옴
    static int N;
    static ArrayList <int[]> rooms = new ArrayList<>();
    static int ans;
    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        for (int i = 0; i < N; i++) {
            int start = scan.nextInt(), end = scan.nextInt();
            rooms.add(new int[] {start, end});
        }
        Collections.sort(rooms, (a,b)->{
           return a[0]==b[0] ? a[1]-b[1] : a[0]-b[0];
        });
    }
    static void solve(){
        //종료 시간 저장
        PriorityQueue<Integer> lectures = new PriorityQueue<>();
        //시작 시간이 가장 빠른 것의 종료 시간을 가져옴
        lectures.add(rooms.get(0)[1]);

        //도착 시간 비교하는 자료구조와 기존 배열 가지는 자료구조를 따로 생성해야 함
        for (int i = 1; i < rooms.size(); i++) {
            int[] lec = rooms.get(i);

            //이전 종료 시간이 지금 시작 시간 보다 늦게 끝나는 경우
            if (lec[0] < lectures.peek()){
                //새로운 도착 시간을 넣기만 함
                lectures.add(lec[1]);
            }else{
                //지금 도착 시간 소진하고 새로운 도착 시간 넣음
                lectures.poll();
                lectures.add(lec[1]);
            }
        }
        System.out.println(lectures.size());

    }
    public static void main(String[] args){
        input();
        solve();
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st==null||!st.hasMoreElements()){
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
