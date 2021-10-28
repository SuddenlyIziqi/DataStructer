package LinkedList.singleLinkedList;

public class SingleLindedList{
    public static void main(String[] args) {

        Node n1 = new Node(1, "张一", null);
        Node n2 = new Node(2, "张2", null);
        Node n3 = new Node(3, "张3", null);
        Node n4 = new Node(4, "张4", null);

        LindedList singleLindedList = new LindedList();
//        singleLindedList.addRearNode(n1);
//        singleLindedList.addRearNode(n2);
//        singleLindedList.addRearNode(n3);
//        singleLindedList.addRearNode(n4);

        singleLindedList.addByOrder(n1);
        singleLindedList.addByOrder(n4);
        singleLindedList.addByOrder(n3);
        singleLindedList.addByOrder(n2);
//        singleLindedList.update( new Node(1, "张5", null));
        singleLindedList.delete( 4);

        singleLindedList.showList();
    }

}

/**
 *  单链表
 *  注意：
 *  单链表做删改的时候需要找到目标节点但是需要保存目标节点的前一个节点的指向才能完成删改，因此要注意用 temp.next比较目标节点 然后可以得到此时的temp就是所需的前一个节点
 */
class LindedList {
    //初始化链表头
    private Node head = new Node(0,"",null);

    public Node getHead() {
        return head;
    }


    /**
     *  判断链表为空
     */
    public boolean isEmpty(){
        if (head.nextNode==null){
            System.out.println("链表为空");
        }
        return  head.nextNode==null;
    }

    /**
     *      添加
     *      尾结点添加
     * 需要先遍历链表到尾结点然后在将尾结点的next指向新的节点 就完成了链表的尾结点添加
     * 需要一个临时节点 temp 作为"指针"进行遍历来判断是否到尾结点
     * @param node
     */
    public void addRearNode(Node node){
        //临时遍历用于遍历
        Node temp = head;

        //遍历链表 查找尾结点
        while (true){
            //如果找到尾结点  中断退出
            if(temp.nextNode==null){
                temp.nextNode=node;
                break;
            }
            //如果没有找到尾结点 继续遍历 temp后移
            temp = temp.nextNode;
        }
    }

    /**
     *      添加
     *      按排序
     *      如果有相同排名的报错
     *  需要一个临时节点 temp 作为"指针"进行遍历
     *  这是一个单链表 所以自定义插入的时候需要获取 遍历对象的下一个对象 即：temp.next
     *  来判断：新的节点排序是否在 temp.next之前，如果是的话就插入temp的后面 temp.next之前的位置
     * @param node
     */
    public void addByOrder(Node node){
        //临时遍历用于遍历
        Node temp = head;

        //遍历链表 查找尾结点
        while (true){
            //如果没有找到 直接插在末尾
            if(temp.nextNode==null){
                temp.nextNode=node;
                return;
            }
            //如果出现相同排名则报错
            if(temp.nextNode.id==node.id){
                System.out.println("已存在相同排名的节点："+node.id);
                return;
            }else if (temp.nextNode.id>node.id){
                node.nextNode =temp.nextNode;
                temp.nextNode=node;
                return;
            }
            //无情况继续遍历
            temp = temp.nextNode;

        }
    }
    /**
     * 展示链表
     */
    public void showList(){
        if (isEmpty()) {
            System.out.println("链表为空");
            return;
        }
        //临时遍历用于遍历
        Node temp = head.nextNode;

        //遍历链表 查找尾结点
        while (temp!=null){
            //如果没有找到尾结点 继续遍历 temp后移
            System.out.println("temp = " + temp);
            temp = temp.nextNode;
        }
        return;
    }

    /**
     *  修改节点
     *  根据 @node 来修改节点
     * @param node
     */
    public void update(Node node){
        if (isEmpty()) {
            return;
        }
        //临时遍历用于遍历
        Node temp = head;
        while (temp.nextNode!=null){
            if (temp.id==node.id){
                temp.name=node.name;
                return;
            }
            temp=temp.nextNode;
        }
        System.out.println("未找到更新对象："+node.id);
        return;

    }

    /**
     * 删除节点
     * 根据 id 来删除
     * 要删除节点@node需要找到 需要找打被删除节点的前一个节点和后一个节点，然后让@node.before.next指向 @node.next 即可
     */

    public void delete(int i){
        if (isEmpty()){
            return;
        }
        //临时遍历用于遍历
        Node temp = head;
        while (temp.nextNode!=null){
            if(temp.nextNode.id==i){
                temp.nextNode=temp.nextNode.nextNode;
                return;
            }
            temp=temp.nextNode;
        }
        System.out.println("未找到需要删除的节点："+i);

    }
}

/**
 *  链表的本质就是一个一个节点组成的
 */
class Node{
    public int id;
    public  String name;
    public  Node nextNode;

    public Node() {
    }

    public Node(int id, String name, Node nextNode) {
        this.id = id;
        this.name = name;
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}