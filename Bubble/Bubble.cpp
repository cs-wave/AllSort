#include <iostream>
using namespace std;

void Swap(int& a, int& b)
{
    int temp = a;
    a = b;
    b = temp;
}

//Main Algorithm
void BubbleSort(int iArray[], int size)
{
    for (int i = 0; i < size - 1; i++)
    {
        for (int j = 0; j < size - i - 1; j++)
        {
            if (iArray[j] > iArray[j + 1])
            {
                Swap(iArray[j], iArray[j + 1]);
            }
        }
    }
}

int main()
{
    int iArray[10] = { 1,5,9,3,2,4,7,8,6,0 };
    BubbleSort(iArray, sizeof(iArray) / sizeof(int));

    for (int i = 0; i < 10; i++)
    {
        cout << iArray[i];
    }
}