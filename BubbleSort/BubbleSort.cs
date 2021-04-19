using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CS
{
    class Program
    {
        static void Swap(ref int a, ref int b)
        {
            int temp = a;
            a = b;
            b = temp;
        }

        static void BubbleSort(int[] iArray, int size)
        {
            for (int i = 0; i < size - 1; i++)
            {
                for (int j = 0; j < size - i - 1; j++)
                {
                    if (iArray[j] > iArray[j + 1])
                    {
                        Swap(ref iArray[j], ref iArray[j + 1]);
                    }
                }
            }
        }

        private static void Main(string[] args)
        {
            int[] iArray = { 0, 5, 43, 2, 543, 25 };
            BubbleSort(iArray, iArray.Length);
        }
    }
}
