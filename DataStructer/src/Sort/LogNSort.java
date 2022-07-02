package Sort;

public class LogNSort {
    //1.冒泡
//         for(int i = 0,l = arr.length;i<l;i++){
//             for(int j = 0;j<l-1;j++){
//                 if(arr[j+1]<arr[j]){
//                     arr[j+1]^=arr[j];
//                     arr[j]^=arr[j+1];
//                     arr[j+1]^=arr[j];
//                 }
//             }
//         }
    //2.选择排序
//         for(int i = 0,l = arr.length;i<l;i++){
//             for(int j = i;j<l;j++){
//                 if(arr[i]>arr[j]){
//                     arr[i]^=arr[j];
//                     arr[j]^=arr[i];
//                     arr[i]^=arr[j];
//                 }
//             }
//         }
//         int min =-1;
//         for(int i = 0,l = arr.length;i<l;i++){
//             min = i;
//             for(int j = i;j<l;j++){
//                 if(arr[j]<arr[min]){
//                     arr[min]^=arr[j];
//                     arr[j]^=arr[min];
//                     arr[min]^=arr[j];
//                 }
//             }
//         }

    //3.插入
//         for(int i = 1,l = arr.length;i<l;i++){
//            int temp = arr[i];
//          //变量j用于遍历前面的有序数组
//          int j = i;
//          while (j>0 && temp<arr[j-1]) {
//             //如果有序数组中的元素大于temp，则后移一个位置
//             arr[j] = arr[j-1];
//             j--;
//          }

//             for(;j>0;j--){
//                 if(arr[j-1]>temp){
//                     arr[j]=arr[j-1];
//                 }else{
//                     break;
//                 }
//             }
//             if(j!=i){
//                 arr[j]=temp;
//             }
//         }
}
