#include <iostream>
using namespace std;

//Main Algorithm
void InsertionSort(int iArray[], int size)
{
    for (int i = 0; i < size - 1; i++)
    {          
        for (int j = i + 1; (j >= 0) && (iArray[j] < iArray[j - 1]); j--)
        {
            swap(iArray[j], iArray[j - 1]);
        }
    }
}

int main()
{
    int iArray[10] = { 1,5,9,3,2,4,7,8,6,0 };
    InsertionSort(iArray, sizeof(iArray) / sizeof(int));

    for (int i = 0; i < 10; i++)
    {
        cout << iArray[i];
    }
}
