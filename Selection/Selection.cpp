#include <iostream>
using namespace std;

//Main Algorithm
void SelectionSort(int iArray[], int size)
{
    for (int i = 0; i < size; i++)
    {          
        int temp = size - 1;
        for (int j = 0 + i; j < size; j++)
        {
            if (iArray[j] <= iArray[temp])
            {
                temp = j;
            }
        }
        swap(iArray[i], iArray[temp]);
    }
}

int main()
{
    int iArray[10] = { 1,5,9,3,2,4,7,8,6,0 };
    SelectionSort(iArray, sizeof(iArray) / sizeof(int));

    for (int i = 0; i < 10; i++)
    {
        cout << iArray[i];
    }
}
