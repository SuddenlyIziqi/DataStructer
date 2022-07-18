package Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LuckyNum {
    public static void main(String[] args) {
        int[][] matrix ={
                {3,7,8},
                {9,11,13},
                {15,16,17}};
        List<Integer> integers = luckyNumbers(matrix);
        System.out.println("integers = " + integers);
    }

    public static List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int[] minArr = new int[row];
        int[] maxArr = new int[col];
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<row;i++){
            minArr[i]=matrix[i][0];
            for(int j = 0 ;j<col;j++){
                minArr[i] = Math.min(matrix[i][j],minArr[i]);
                maxArr[j] = Math.max(matrix[i][j],maxArr[j]);
            }
            set.add(minArr[i]);
        }
        for(int i =0;i<col;i++){
            if(set.contains(maxArr[i])) {
                result.add(maxArr[i]);
                break;
            }
        }
        return result;

    }
}
