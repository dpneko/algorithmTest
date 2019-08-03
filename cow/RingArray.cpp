// #include<iostream>
// #include"RingArray.h"
// using namespace std;

// class RingArray{
//     int length;
//     //指向队列第一个数据
//     int start;
//     //指向队列下一个空位
//     int tail;
//     int * data;
//     public: RingArray(int length){
//         data = (int *)malloc(sizeof(int) * length);
//         RingArray::length = length;
//         start = 0;
//         tail = 0;
//     }

//     public: int pop(){
//         int value = data[start];
//         start--;
//         return value;
//     }

//     public: int push(int value){
//         int headValue = data[start];
//         data[tail] = value;
//         tail = (tail + 1) % length;
//         return headValue;
//     }

//     public: void print(){
//         for()
//     }
// }