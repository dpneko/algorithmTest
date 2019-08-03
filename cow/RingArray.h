#include<iostream>
using namespace std;

class RingArray{
    int length;
    //指向队列第一个数据
    int start;
    //指向队列下一个空位
    int tail;
    int * data;
    //用-1初始化队列
    public: RingArray(int length){
        data = (int *)malloc(sizeof(int) * length);
        for(int i = 0;i<length;i++){
            data[i] = -1;
        }
        RingArray::length = length;
        start = 0;
        tail = 0;
    }

    public: int pop(){
        int value = data[start];
        start--;
        RingArray::print();
        return value;
    }

    public: void push(int value){
        data[tail] = value;
        tail = (tail + 1) % length;
        RingArray::print();
    }

    //index>=1, index<=length
    public: int get(int index){
        return data[(start+index-1)%length];
    }

    public: void print(){
        for(int i = start; i < tail + length; i++){
            cout<<data[i%length]<<" ";
        }
        cout<<endl;
    }
};