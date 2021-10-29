package Stack.LinkedListStack;

/**
 * 单链表实现栈
 */
public class LinkedListStackDemo {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        SingleLinkedListStcack singleLinkedListStcack = new SingleLinkedListStcack();
        singleLinkedListStcack.push(n1);
        singleLinkedListStcack.push(n2);
        singleLinkedListStcack.push(n3);
        singleLinkedListStcack.show();
        singleLinkedListStcack.pop();
        singleLinkedListStcack.show();
        singleLinkedListStcack.pop();
        singleLinkedListStcack.show();
        singleLinkedListStcack.pop();
        singleLinkedListStcack.show();
    }


}
class SingleLinkedListStcack{
    public Node top =new Node(-1);
    /**
        栈为空
     */
    public boolean isEmpty(){
        return top.id==(-1);
    }

    /**
     * 入栈
     * @param node
     */
    public void push(Node node){
        node.next=top;
        top =node;
        System.out.println("此次入栈："+node);

    }

    /**
     * 出栈
     */
    public Node pop(){
        if (isEmpty()) {
            System.out.println("栈为空！");
            return null;
        }
        Node value =top;
        top=top.next;
        System.out.println("此次出栈："+value);
        return value;
    }
    public void show(){
        System.out.println("单链表栈：");
        System.out.println("----");
        Node temp = top;
        while (temp.id!=-1){
            System.out.println(temp);
            temp = temp.next;
        }
        System.out.println("----");
    }



}
class Node{
    public int id;
    public Node next;

    public Node() {
    }

    public Node(int id) {
        this.id = id;
    }

    public Node(int id, Node node) {
        this.id = id;
        this.next = node;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                '}';
    }
}