void mergeSort(int A[], int low, int high) 
{
    // 1. base condition
    if (low >= high) return;

    // 2. divide
    int mid = (low + high) / 2;

    // 3. conquer
    mergeSort(A, low, mid);
    mergeSort(A, mid + 1, high);

    // 4. combine
    int* B = new int[high + 1];
    int i = low, j = mid + 1, k = low;
    for (; k <= high; ++k) 
    {
        if (j > high) B[k] = A[i++];
        else if (i > mid) B[k] = A[j++];
        else if (A[i] <= A[j]) B[k] = A[i++];
        else if (A[i] > A[j])B[k] = A[j++];
    }

    // 5. copy
    for (i = low; i <= high; ++i) A[i] = B[i];
    delete[] B;
}
