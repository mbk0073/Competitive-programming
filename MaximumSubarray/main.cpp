#include<iostream>
#include <cstdlib>
#include <string>
#include <climits>
using namespace std;

int maxSubArraySum(int *a, int size)
{
    int globalsum = a[0];
    int localsum = a[0];
  //  long long maxsum=a[0];


    for (int i = 1; i < size; i++)
    {   /*	curr_max = max(a[i], curr_max+a[i]);
            cout<<curr_max<<endl;8
            max_so_far = max(max_so_far, curr_max);*/

        localsum=max(a[i],a[i]+localsum);
       // maxsum=max(maxsum, a[i]+maxsum);
        globalsum=max(localsum, globalsum);

    }
    return globalsum;
  //  if(globalsum<0)maxsum=globalsum;
   // cout<<globalsum<<" "<<maxsum<<"\n";
}

/* Driver program to test maxSubArraySum */
int maxe(int *a, int n){
    int maxl=-1000000;
    for(int i=0; i<n; ++i){
        if(a[i]>maxl)maxl=a[i];
    }
    return maxl;
}
int main()
{
    int t, N;

    cin>>t;
    for(int i=0; i<t; ++i){
        int msum=0;
        bool flag=false;
        cin>>N;
        int *a=new int[N];
        for(int j=0; j<N; ++j){
            cin>>a[j];
            if(a[j]>0){
                flag=true;
                msum+=a[j];
            }

        }
        int gsum=maxSubArraySum(a, N);

        if(!flag){
            msum=maxe(a,N);
        }
        cout<<gsum<<" "<<msum<<"\n";

    }

    return 0;
}
