package LinkedList.doubleLinkedList;



public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleNode n1 = new DoubleNode(1, "张1", null, null);
        DoubleNode n2 = new DoubleNode(2, "张2", null, null);
        DoubleNode n3 = new DoubleNode(3, "张3", null, null);
        DoubleNode n4 = new DoubleNode(4, "张4", null, null);
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addRear(n1);
        doubleLinkedList.addRear(n2);
        doubleLinkedList.addRear(n3);
        doubleLinkedList.addRear(n4);
        doubleLinkedList.showList();
        System.out.println("更新后的：");
        doubleLinkedList.update(new DoubleNode(1, "张小2", null, null));
        doubleLinkedList.showList();
        System.out.println("删除后：");
        doubleLinkedList.delete(2);
        doubleLinkedList.showList();
    }
}

class DoubleLinkedList{
    //初始化头节点
    private DoubleNode head = new DoubleNode(0,"",null,null);

    public DoubleNode getHead() {
        return head;
    }

    /**
     * 添加
     * 尾插法
     */

    public void addRear(DoubleNode node){
        DoubleNode temp = head;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    /**
     * 修改
     * 按id修改
     * 需要辅助节点进行遍历
     *
     */

    public void update(DoubleNode node){
        if(head.next==null){
            System.out.println("链表为空！");
            return;
        }

        DoubleNode temp = head;
        while (temp.next!=null){
            if(temp.id==node.id){
                temp.name = node.name;
                return;
            }
            temp=temp.next;

        }
        System.out.println("未找到对于节点"+node.id);
    }


    /**
     *  删除
     *  注意 当遍历到最后一个节点时，也要判断最后一个节点 此时最后一个几点情况与前面不同 因为 @temp.next==null   so @temp.next.pre will throw NollPointException,we need to handle rearNode specially
     */
    public void delete(int i){
        if(head.next==null){
            System.out.println("链表为空！");
            return;
        }

        DoubleNode temp = head;
        while (temp.next!=null){
            if(temp.id==i){
                temp.next.pre=temp.pre;
                temp.pre.next=temp.next;
                return;
            }
            temp=temp.next;

        }
        if(temp.id==i){
            temp.pre.next=null;
        }else {
            System.out.println("未找到需要删除的节点"+i);
        }

    }


    /**
     * 展示链表
     */
    public void showList(){
        if (head.next==null) {
            System.out.println("链表为空");
            return;
        }
        //临时遍历用于遍历
        DoubleNode temp = head.next;

        //遍历链表 查找尾结点
        while (temp!=null){
            //如果没有找到尾结点 继续遍历 temp后移
            System.out.println("temp = " + temp);
            temp = temp.next;
        }
        return;
    }


}

/**
 *  链表的本质就是一个一个节点组成的
 */
class DoubleNode{
    public int id;
    public  String name;
    public DoubleNode pre;
    public DoubleNode next;

    public DoubleNode() {
    }

    public DoubleNode(int id, String name, DoubleNode pre, DoubleNode next) {
        this.id = id;
        this.name = name;
        this.pre = pre;
        this.next = next;
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}