#include <iostream>
#include <vector>

using namespace std;

int main()
{
    vector<int> v;
    vector<char> result;
    int n, cmp = 0;
    int current = 1; 

    cin >> n;

    for(int i=0; i<n; i++){
        cin >> cmp;

        while(current<=cmp){
            v.push_back(current);
            result.push_back('+');
            current++;
        }
             
        if(v.back()==cmp){
            v.pop_back();
            result.push_back('-');
        }

    }
            
    if(v.empty()){
        for(int i=0; i<result.size(); i++){
            cout << result.at(i) << '\n';
        }
    }else cout << "NO";

    return 0;
}