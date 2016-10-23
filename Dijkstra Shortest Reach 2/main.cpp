#include <iostream>
#include <stdio.h>
using namespace std;

#include <conio.h>
#define INFINITY 99999999

struct Node{
    int cost;
    int value;
    int from;
}a[7];

void min_heapify(int *b, int i, int n){
    int j, temp;
    temp=b[i];
    j=2*i;
    while(j<=n){
        if(j<n && b[j+1]<b[j])++j;

    }
}

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}