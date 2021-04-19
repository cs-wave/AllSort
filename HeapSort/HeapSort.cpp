void Heapify(int* iArray, int iSize, int i)
{
	int c = 2 * i + 1;
	if (c < iSize - 1 && iArray[c] < iArray[c + 1])
	{
		c++;
	}
	if (c < iSize && iArray[i] < iArray[c])
	{
		Swap(iArray[i], iArray[c]);
	}
	if (c < iSize / 2)
	{
		Heapify(iArray, iSize, c);
	}
}

void HeapSort(int iArray[], int iArraySize) 
{
	for (int i = iArraySize / 2; i >= 0; i--) {
		Heapify(iArray, iArraySize, i);
	}

	for (int i = iArraySize - 1; i >= 0; i--) {
		Swap(iArray[i], iArray[0]);
		Heapify(iArray, i, 0);
	}
}
