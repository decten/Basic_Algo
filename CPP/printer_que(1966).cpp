#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct input
{
    public: 
    int rank;
    int index;
    
    input(int x, int y){
         rank=x, index=y;
     }
};

/*이 연산자 오버로딩으로는 맨 뒤로 보내는게 안 됨*/
// struct cmp{
//     bool operator()(input x, input y){
//         // 우선 순위가 같다면 인덱스 작은 값이 먼저 
//         if(x.rank == y.rank){
//             return x.index > y.index;
//         }
//         // 우선 순위 큰 것이 먼저
//         return x.rank < y.rank;
//      }
// };

int main(){
    int testCase=0,total=0,index=0;
    /*연산자 오버로딩만으로는 안 됐음*/
    queue <input> printer;
    priority_queue <int> priority;

    cin >> testCase;

    while(testCase){
        int answer=0;

        cin >> total >> index;
        
        for(int i=0; i<total; i++){     
            int rank=0;       
            cin >> rank;
            printer.push(input(rank,i));
            priority.push(rank);
        }

        while(!printer.empty()){
            int nowRank=0,nowIndex=0;
            nowRank = printer.front().rank;
            nowIndex = printer.front().index;
            printer.pop();

            /*우선순위 큐는 같은 우선순위가 나올 때 pop 하고 횟수 증가*/
            if(priority.top()==nowRank){
                priority.pop(); 
                answer++;
                if(nowIndex==index){
                   cout << answer <<'\n';
                }
            }
            else{printer.push(input(nowRank,nowIndex));}
        }

        testCase--;
    }

    return 0;
}