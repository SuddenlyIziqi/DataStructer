package LinkedList.singleLinkedList;

import java.util.Stack;

public class SingleLindedListTest{
    public static void main(String[] args) {

        Node n1 = new Node(1, "张1", null);
        Node n2 = new Node(2, "张2", null);
        Node n3 = new Node(3, "张3", null);
        Node n4 = new Node(4, "张4", null);

        LindedList singleLindedList = new LindedList();
        singleLindedList.addRearNode(n1);
        singleLindedList.addRearNode(n2);
        singleLindedList.addRearNode(n3);
        singleLindedList.addRearNode(n4);



        singleLindedList.showList();
        System.out.println("单链表的长度为："+getLength(singleLindedList.getHead()));
//        System.out.println("倒数地K节点为："+getDescK(singleLindedList.getHead(),4));

//        reservesList(singleLindedList.getHead());
//        System.out.println("反转后的链表为为：");
        System.out.println("逆转打印的单链表：");
        printDescList(singleLindedList.getHead());
        System.out.println("原来的单链表：");
        singleLindedList.showList();

    }


    /**
     * 1.获取单链表长度  不高汉头节点
     * @return
     */
    public static int getLength(Node head){
        if(head.nextNode==null){
            return 0;
        }
        Node temp = head.nextNode;
        int length=0;
        while (temp!=null) {
            length++;
            temp = temp.nextNode;
        }
        return length;
    }
    /**
     * 2.获取单链倒数地k个节点
     * 方法一：1.遍历一次获取总长度如 @getLength、
     *        2.getLength - k+1 个节点既是所需
     *
     * 方法二：快慢指针
     * @return
     */
    public static Node getDescK(Node head,int i){
        if(head.nextNode==null){
            return null;
        }
        Node fast = head.nextNode;
        Node slow = head.nextNode;
        int index=0;
        while (fast!=null) {
            index++;
            fast = fast.nextNode;
            if(index>i){
                slow = slow.nextNode;
            }
        }
        if(index<i){
            System.out.println("outOfIndex!");
            return null;
        }
        return slow;
    }
    /**
     * 3.单链表的反转
     * 需要2个辅助指针 current 和 next  前者用来记录当前遍历对象，后者用来记录下一个对象
     * 还需要一个临时头节点@reservesHead 用来链接 反转后的数据
     * 最后把 临时头节点@reservesHead 后面的元素重新连接到 原来的 head 即可
     */

    public static void reservesList(Node head){
        if(head.nextNode==null||head.nextNode.nextNode==null){
            return;
        }
        Node current = head.nextNode;
        Node next = new Node();
        Node resverseHead = new Node();

        while (current!=null){
            //存储节点下一位 用与后续操作
            next = current.nextNode;
            //将 当前节点的下一位 指向 临时头节点的下一位 -- 连后
            current.nextNode=resverseHead.nextNode;
            //就临时节点的下一位 指向当前节点  --- 接前
            resverseHead.nextNode=current;
            //节点后移
            current=next;
        }
        head.nextNode=resverseHead.nextNode;
    }

    /**
     *  4。 逆序打印单链表
     *  可以使用3 的反转链表 但是会改变原有单链表 需要再一次反转
     *   也可以使用 stack
     */

    public static void printDescList(Node head){
        if(head.nextNode==null){
            return;
        }
        Stack<Node> stack =new Stack<>();
        //遍历单链表
        Node current = head.nextNode;


        while (current!=null){
            //节点后移
            stack.add(current);

            current=current.nextNode;
        }

        while (!stack.isEmpty()){
            Node pop = stack.pop();
            System.out.println("pop = " + pop);
        }
    }
}

