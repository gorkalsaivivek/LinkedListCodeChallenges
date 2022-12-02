//package src;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
//import static src.Stack.nextLargeNumber;
//
//public class Stack {
//
//    Queue queue1;
//    Queue queue2;
//    int size;
//
//    public Stack() {
//       queue1= new LinkedList<>();
//       queue2= new LinkedList<>();
//       size=0;
//    }
//
//
//
//    /*----------------- Public Functions of Stack -----------------*/
//
//
//    public int getSize() {
//        return size;
//    }
//
//    public boolean isEmpty() {
//        return size==0;
//    }
//
//    public void push(int element) {
//
//        queue1.add(element);
//
//        size=queue1.size();
//
//    }
//
//    public int pop() {
//        int lastElement=-1;
//        while(!queue1.isEmpty()){
//            lastElement= (int) queue1.peek();
//            queue2.add(queue1.poll());
//        }
//
//        while(!queue2.isEmpty()){
//            if((int)queue2.peek()== lastElement){
//                queue2.poll();
//            }
//            else {
//                queue1.add(queue2.poll());
//            }
//
//        }
//        size=queue1.size();
//        return lastElement;
//    }
//
//    public int top() {
//        int lastElement=-1;
//        while(!queue1.isEmpty()){
//            lastElement= (int) queue1.peek();
//            queue2.add(queue1.poll());
//        }
//
//        while(!queue2.isEmpty()){
//            queue1.add(queue2.poll());
//        }
//        size=queue1.size();
//
//        return lastElement;
//
//    }
//
//    public static void reverseQueue(Queue<Integer> input) {
//        Queue<Integer> queue2= new LinkedList<>();
//        java.util.Stack stack=new java.util.Stack();
//        while(!input.isEmpty()){
//            stack.add(input.poll());
//        }
//
//        while(!stack.isEmpty()){
//            input.add((Integer) stack.pop());
//        }
//
//    }
//
//    public static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {
//        java.util.Stack stack=new java.util.Stack();
//        Queue<Integer> queue2= new LinkedList<>();
//        int count=0;
//        while(count<k){
//            stack.push(input.poll());
//            count++;
//        }
//        while(!input.isEmpty()){
//            queue2.add(input.poll());
//        }
//
//        while(!stack.isEmpty()) {
//            input.add((Integer) stack.pop());
//        }
//        while(!queue2.isEmpty()) {
//            input.add(queue2.poll());
//        }
//        return input;
//    }
//
//    public static LinkedListNode<Integer> nextLargeNumber(LinkedListNode<Integer> head) {
//        java.util.Stack<Integer> stack = new java.util.Stack<>();
//        java.util.Stack<Integer> resultStack = new java.util.Stack<>();
//        LinkedListNode<Integer> temp = head;
//        int lastElement = 0;
//        boolean isLastElementNine = false;
//        boolean isOneAdded =false;
//        while (temp != null) {
//            stack.push(temp.data);
//            if (temp.next == null) {
//                if (temp.data != 9) {
//                    temp.data = temp.data + 1;
//                    isLastElementNine = false;
//                } else {
//                    isLastElementNine = true;
//                }
//
//            }
//            temp = temp.next;
//        }
//
//        if(isLastElementNine) {
//            LinkedListNode<Integer> newTemp = null;
//            while(!stack.isEmpty()) {
//                if(isLastElementNine && (stack.peek()==9)) {
//                    resultStack.push(0);
//                    isLastElementNine=false;
//                    stack.pop();
//                }
//                else if (stack.peek()==9 && !isOneAdded) {
//                    resultStack.push(0);
//                    stack.pop();
//                }
//                else if (stack.peek()!=9 && !isOneAdded) {
//                    resultStack.push(stack.pop()+1);
//                    isOneAdded=true;
//                }
//                else {
//                }
//
//
//            }
//            if(!isOneAdded){
//                newTemp=new LinkedListNode<>(1);
//                newTemp.next=head;
//            }
//            LinkedListNode<Integer> latestTemp = head;
//            while(latestTemp!=null){
//                latestTemp.data=resultStack.pop();
//                latestTemp=latestTemp.next;
//            }
//            return newTemp;
//        }
//
//
//return head;
//    }
//
//    public static void deleteAlternateNodes(LinkedListNode<Integer> head) {
//        LinkedListNode<Integer> temp=head;
//        LinkedListNode<Integer> curr=head;
//        int count=1;
//        while(temp!=null){
//            if(count%2==0){
//                curr.next=temp.next;
//            }
//            else {
//                curr=temp;
//            }
//
//            temp=temp.next;
//            count++;
//        }
//
//    }
//
//}
//class LinkedListNode<T> {
//    T data;
//    LinkedListNode<T> next;
//
//    public LinkedListNode(T data) {
//        this.data = data;
//    }
//}
//
//class Starter {
//    public static void main(String[] args) {
////        Stack stack=new Stack();
////        stack.push(13);
////        stack.push(47);
////      //  stack.push(30);
////        stack.top();
////        stack.getSize();
//
//        LinkedListNode<Integer> node1=new LinkedListNode<>(9);
//        LinkedListNode<Integer> node2=new LinkedListNode<>(9);
//        LinkedListNode<Integer> node3=new LinkedListNode<>(9);
//        node1.next=node2;
//        node2.next=node3;
//        node3.next=null;
//        nextLargeNumber(node1);
//
//
//
//    }
//}
//
//
//class Solution {
//
//    public static void intersections(int[] arr1, int[] arr2)
//    {
//        boolean visited[]=new boolean[arr2.length];
//        for(int i=0;i<arr1.length;i++)
//        {
//            int temp=arr1[i];
//            for( int j=0;j<arr2.length;j++)
//            {
//                if(visited[j]==false)
//                {
//                    if (temp==arr2[j])
//                    {
//                        visited[j]=true;
//                        System.out.println(temp);
//                        break;
//                    }
//                }
//            }
//        }
//    }
//
//}
