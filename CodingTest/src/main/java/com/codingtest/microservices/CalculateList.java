/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codingtest.microservices;

import java.util.Arrays;

/**
 *
 * @author Rishabh
 */
public class CalculateList {
    public static int[] slice(int[] array, int startIndex, int endIndex)   
    {   
        // Get the slice of the Array   
        int[] slicedArray = Arrays.copyOfRange(array, startIndex, endIndex);   
        // return the slice   
        return slicedArray;   
    }   
    int Count(int present_weights[], int size, int hood_capacity)
        {
            int [][]table = new int[size + 1][hood_capacity + 1];

            // Loop to initialize the array
            // as infinite in the row 0
            for(int i = 1; i <= hood_capacity; i++)
            {
            table[0][i] = Integer.MAX_VALUE - 1;
            }

            // Loop to find the solution
            // by pre-computation for the
            // sequence
            for(int i = 1; i <= size; i++)
            {
            for(int j = 1; j <= hood_capacity; j++)
            {
                if (present_weights[i - 1] > j)
                {
                    table[i][j] = table[i - 1][j];
                }
                else
                {

                    // Minimum possible for the
                    // previous minimum value
                    // of the sequence
                    table[i][j] = Math.min(table[i - 1][j],
                                    table[i][j - present_weights[i - 1]] + 1);
                }
            }
            }
            return table[size][hood_capacity];
        }
    int[] FindMin(int arr[],int n){
        int temp[] = {};
        if(arr.length == 0){
            
            return temp;
        }
        int min[] = null;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==n){
                return temp;
            }
            int next[] = FindMin(slice(arr, i+1, arr.length+1), n-arr[i]);
            if(next.length != 0){
                if(min == null || next.length < min.length){
                    min[0] = arr[i];
                    for(int j=0;j<next.length;j++){
                        min[j+1] = next[j];
                    }
                }
            }
        }
        return temp;
    }
}
