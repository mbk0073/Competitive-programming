#include<iostream>
#include<string>
#include<algorithm>
#include <algorithm>
using namespace std;

long long  input[3];
int main()
{
    cout << "Run";
    while(cin>>input[0]>>input[1]>>input[2])
    {
        long long  n=input[0]+input[1]+input[2];
        sort(input,input+3);
        if(input[2]==0)
            cout<<"0\n";
        else if(input[1]==0)
        {
            if(input[2]==1)
                cout<<"0\n";
            else
                    cout<< (2*(n-2)+1)<<"\n";
        }
        else if(input[0]==0)
        {
            if(input[1]==1)
            {
                if(input[2]==1)
                    cout<<"1\n";
                else
                  cout<<(n-3)*3+3<<endl;
            }
            else
                cout<<4*(n-4)+6<<endl;
        }
        else
        {
            if(input[0]>=2)
            {
                cout<<(n-6)*6+15<<endl;
            }
            else if(input[0]==1)
            {
                if(input[1]==1)
                {
                    if(input[2]==1)
                    {
                        cout<<2+(1*1LL)<<endl;
                    }
                    else
                    {
                        cout<<6+(input[2]-2)*4<<endl;
                    }
                }
                else
                {
                   cout<<10+5*(n-5)<<endl;
                }
            }
        }
    }
    cout<<"Dont run";
    return 0;
}