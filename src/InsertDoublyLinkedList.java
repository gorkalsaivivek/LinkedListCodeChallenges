package src;

public class InsertDoublyLinkedList {

    void addNode(DoublyLinkedNode head_ref, int pos, int data)
    {
        int count=0;
        while (head_ref.next!=null){
            if(count==pos){
                head_ref.next=new DoublyLinkedNode(data);

            }
            count++;
        }
    }
}
