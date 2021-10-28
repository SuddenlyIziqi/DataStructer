package LinkedList.circleSingleLinkedList;

/**
 * 环形单链表
 */
public class CircleSingleLinkedListDemo {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        //初始化
        circleSingleLinkedList.init(6);
        //遍历
        System.out.println("当前环形链表：");
        circleSingleLinkedList.show();

    }

}

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