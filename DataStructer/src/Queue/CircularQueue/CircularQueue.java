package Queue.CircularQueue;

import java.lang.annotation.Documented;
import java.util.Scanner;

/**
 *  环形队列
 *  数组模拟
 *
 *
 *
 *
 */

public class CircularQueue {
    public static void main(String[] args) {

        CircularArrayqueue queue = new CircularArrayqueue(4);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s : 显示队列" );
            System.out.println("a : 入队" );
            System.out.println("g : 出队" );
            System.out.println("h : 显示队头" );
            System.out.println("e : 推出程序" );
            key = scanner.next().charAt(0);
            switch (key){
                case 's':queue.showQueue();break;
                case 'a':
                    System.out.println(" 请输入一个数" );
                    int value =scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':queue.getQueue();break;
                case 'h':queue.head();break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
            }
        }
    }
}
/**
 *  maxSize  数组的大小比实际存储数据空间多1
 *  front = 0  指向队列的第一个数据
 *  rear = 0   指向队列最后一个数据的后一个位置，预留一个空位子用以区分空、满
 *  判断为空条件:  rear - front = 0 ： rear = front
 *  判断为满条件:  (rear+1) % maxSize = front
 *  有效数据个数:
 *              a. rear > front : rear - front
 *              b. rear < frong : rear - front + maxSize
 */
class CircularArrayqueue{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;
    public CircularArrayqueue(int arrayMaxSize){
        maxSize = arrayMaxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    //判断 队列是否为满
    public boolean isFull(){
        return (rear+1) % maxSize == front;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }
    //添加数据 入队
    public void addQueue(int n){
        if (isFull()) {
            System.out.println("队列已满!");
            return;
        }
        //加入数据
        arr[rear] = n;
        //尾部后移 要考虑取模
        rear = (rear+1)%maxSize;
    }
    //取出数据 出队
    public int getQueue(){
        if (isEmpty()) {
            System.out.println("队列为空!");
            return 0;
        }
        //取出数据
        int result = arr[front];
        front=(front+1)%maxSize;
        return result;
    }
    //获取队列有效数据个数
    public int size(){
        if (isEmpty()) {
            System.out.println("队列为空!");
            return 0;
        }
        return (rear - front + maxSize)%maxSize;
    }
    //展示队列
    public void showQueue(){
        if (isEmpty()) {
            System.out.println("队列为空!");
            return ;
        }
        for (int i = front; i <front+size() ; i++) {
            System.out.printf("arr[%d]=%d", i%maxSize,arr[i%maxSize]);
            System.out.println();
        }
    }
    //显示头元素
    public int head(){
        if (isEmpty()) {
            System.out.println("队列为空!");
            return 0;
        }
        return arr[front];
    }
}