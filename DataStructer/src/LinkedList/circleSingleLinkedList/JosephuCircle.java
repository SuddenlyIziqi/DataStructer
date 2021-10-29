package LinkedList.circleSingleLinkedList;

/**
 * 环形单链表
 * 约瑟夫环问题
 * 描述：对于与一个环形链表 初始化为圈有 @sum 个人，从第 @count 位开始第 @num 位出圈  获取出圈的顺序
 *
 */
public class JosephuCircle {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        //初始化
        circleSingleLinkedList.init(5);
        //遍历
        System.out.println("当前环形链表：");
        circleSingleLinkedList.show();
        circleSingleLinkedList.josephu(5,1,2);

    }

}





/**
 * 初始化环形链表
 * @sum 位链表的长度
 */
class CircleSingleLinkedList{

    //设置一个初始节点
    private CircleNode first = null;
    /**
     * 初始化环形单链表
     */
    public void init(int sum){
        if (sum<1){
            System.out.println("初始化构建 sum 不合法");
            return;
        }
        //遍历添加环
        //辅助 temp 指针用来遍历
        CircleNode temp = null;
        for (int i = 1; i <= sum; i++) {
            // new add Node
            CircleNode newNode = new CircleNode(i);
            if(i==1){
                first=newNode;
                first.next=first;
                temp=first;
            }else {
                temp.next=newNode;
                newNode.next=first;
                temp=temp.next;
            }

        }
    }
    /**
     * 遍历
     */
    public void show(){
        if (first==null){
            System.out.println("环形链表为空！");
            return;
        }
        //辅助 temp 指针用来遍历
        CircleNode temp = first;
        while (true){
            System.out.println("当前node："+temp.no);

            if(temp.next==first){
                return;
            }
            temp=temp.next;
        }
    }

    /**
     *
     * @param sum  总人数
     * @param count   第几位开始
     * @param num   间隔报数 从自己开始为1 那么也就是 移动 num-1为
     *
     * @first 为链表头 他并不代表就是 1 需要根据 @count 来确定 需要对其进行初始化
     */
    public void josephu(int sum,int count,int num){
        // 校验数据有效性

        // 添加辅助指针 temp 让他始终指向 当前出圈后的对象的前一位（相当于一直指向队尾） 这样子对象出圈后就可以用它直接连接出拳对象的下一个对象，让链表重新成环
        CircleNode temp = first;

        // 初始化 temp 位置 往后遍历直到 temp.next==first 保持始终以 first 为链表头的时候  temp为链表尾
        while (true){
            //当辅助指针指向first时 说明循环到自身 也就结束了
            if(temp.next==first){
                break;
            }
            temp=temp.next;
        }
        // 先初始化 first 和 temp的位置
        // 即：报数前 移动到 count-1 的位置
        // 这里用循环来代表 count-1次移位
        for (int i = 0; i < count-1; i++) {
            first= first.next;
            temp=temp.next;
        }


        // 当小孩开始报数后
        // 用大循环操作出圈，直到最后一个节点
        while (true){
            if (temp==first){
                //说明此时圈中只有一个节点
                break;
            }

            // 在大循环中，temp 和 first 每次移动 num - 1 位
            for (int i = 0; i < num-1; i++) {
                first=first.next;
                temp=temp.next;
            }

            //此时 first指向的就是此次大循环需要出圈的节点
            System.out.println("需要出圈的节点为："+first.no);
            //让其出圈
            first=first.next;
            temp.next=first;
        }
        System.out.println("最后出圈的节点为："+first.no);


    }
}

class CircleNode{
    public int no;
    public CircleNode next;

    public CircleNode() {
    }

    public CircleNode(int no ){
        this.no = no;
    }
}