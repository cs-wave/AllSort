#include <iostream>
using namespace std;

void MergeSort(int array[], int begin, int end)
{
    if (begin < end)
    {
        int left_pivot = (begin + end) / 2;
        int right_pivot = left_pivot + 1;

        if (begin != left_pivot)
        {
            MergeSort(array, begin, left_pivot);
            MergeSort(array, right_pivot, end);
        }

        int* temp = new int[end - begin + 3];
        *temp = { };
        int first_division = begin;
        int second_division = right_pivot;
        int i = 0;
        while (first_division < left_pivot + 1 && second_division < end + 1)
        {
            if (array[first_division] < array[second_division] + 1)
            {
                temp[i++] = array[first_division++];
            }
            else
            {
                temp[i++] = array[second_division++];
            }
        }
        if (first_division > left_pivot)
        {
            while (second_division < end + 1)
            {
                temp[i++] = array[second_division++];
            }
        }
        else
        {
            while (first_division < left_pivot + 1)
            {
                temp[i++] = array[first_division++];
            }
        }
        for (i = begin; i < end + 1; i++)
        {
            array[i] = temp[i - begin];
        }
        delete[] temp;
    }
}

int main(void)
{
	int iArray[10] = { 0,2,1,3,6,7,5,4,9,8 };
	MergeSort(iArray, 0, 9);
    for (int i = 0; i < 10; i++)
    {
        cout << iArray[i];
    }
}
