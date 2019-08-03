/**
奶牛那个就是一个牛。三岁到七岁的时候生牛，每年生一个，然后十岁的时候就死了。然后问你N年以后有多少牛。
1，2，3，4，5，6，7，8，9，10
1，1，2，2，2，2，2，1，1，1
a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,
0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0  ,0  ,
0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0  ,0  ,
1 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0  ,0  ,
1 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0  ,0  ,
1 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0  ,0  ,
1 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0  ,0  ,
1 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0  ,0  ,
0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0  ,0  ,
0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0  ,0  ,
0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0  ,0  ,


a-3
a-2
a-1
a0
a1,
a2,
a2+a1=a3
a3+a1+a2=a4
a4+a1+a2+a3=a5
a5+a1+a2+a3+a4=a6
a6+a1+a2+a3+a4+a5=a7



设每年新出生的牛数量为n,总数量为s
n1
n2
n3
n4
n5
n6
n7
n8
n9
n10
n11=n8+n7+n6+n5+n4;
S11=S10+n11-n1;
*/

#include<iostream>
#include"RingArray.h"
using namespace std;

int solution(int year);

int main(){
    int year;
    cin>>year;
    cout<<solution(year)<<endl;
    return 0;
}

int solution(int year){
    RingArray ring(10);
    for(int i = 0;i<10;i++){
        ring.push(0);
    }
    ring.push(1);
    int S = 1;
    for(int i = 2;i<=year;i++){
        int dead = ring.get(1);
        ring.push(ring.get(8)+ring.get(7)+ring.get(6)+ring.get(5)+ring.get(4));
        S = S + ring.get(10) - dead;
        cout<<"S"<<year<<": "<<S<<endl;
    }
    return 0;
}



