/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursemanagementsystempar2;

/**
 *
 * @author SHINIGAMI99
 */
public final class InsertArray 
{
    public int[] reallocRW(int[] a)
    {
        int n = a.length;
        int[] b = new int[n];
        for(int i = 0; i < n; i++)
        {
            b[i] = a[i];
        }
        a = new int[++n];
        for(int i = 0; i < n - 1; i++)
        {
            a[i] = b[i];
        }
        return a;
    }
    public int[] insertArray(int[] a, int indext, int x)
    {
        int n = a.length;
        a = reallocRW(a);
        for(int i = n - 1; i >= indext; i--)
        {
            a[i + 1] = a[i];
        }
        a[indext] = x;
        n++;
        return a;
    }
}
