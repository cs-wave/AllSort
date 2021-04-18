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
	Swap(iArray[++i], iPivot);
	QuickSort(iArray, iLow, i - 1);
	QuickSort(iArray, i + 1, iHigh);
}
