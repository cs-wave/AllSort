//Pivot is the rightmost value of the segmented data
#include <iostream>
using namespace std;

void QuickSort(int iArray[], int iLow, int iHigh)
{
	if (iLow >= iHigh)
	{
		return;
	}
	int i = iLow - 1, j = iLow;
	int& iPivot = iArray[iHigh];
	for (; j < iHigh; j++)
	{
		if (iArray[j] < iPivot)
		{
			swap(iArray[++i], iArray[j]);
		}
	}
	swap(iArray[++i], iPivot);
	QuickSort(iArray, iLow, i - 1);
	QuickSort(iArray, i + 1, iHigh);
}

int main()
{
	int iArray[] = { 89,408,8,4486,4648,8048,804,486,0,40048,8,40408,4086,48 };
	QuickSort(iArray, 0, 13);
	for (int i = 0; i < 14; i++)
	{
		cout << iArray[i] << ", ";
	}
}
