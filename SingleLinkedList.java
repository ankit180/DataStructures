package LinikedList;

import java.util.List;

public class SingleLinkedList {

    /***
     * Definition of singly linked list
     */
    private ListNode head;
    private static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next=null;
        }
    }

    public static void main(String[] args) throws Exception {
        /***
         * Implementing the Linked list
         */
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.head = new ListNode(1);
//        ListNode head = new ListNode(10);
        ListNode second = new ListNode(3);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);

        singleLinkedList.head.next = second;
        second.next = third;
        third.next = fourth;

//        singleLinkedList.insertNewNodeInTheBeginning(23);
//        singleLinkedList.insertNodeAtTheEnd(43);
//        singleLinkedList.insertNodeAtTheEnd(67);
//        singleLinkedList.insertNodeAtAGivenPosition(23,5);
//        singleLinkedList.insertNodeAtAGivenPosition(3,6);
//        singleLinkedList.insertNodeAtAGivenPosition(3,4);
//        singleLinkedList.deleteFirstNode();
//        singleLinkedList.deleteLastNode();
//        singleLinkedList.deleteNodeAtAGivenPosition(3);
        System.out.println("before: ");
//        singleLinkedList.display(singleLinkedList.head);
//        ListNode reversedHead = singleLinkedList.reverseList(singleLinkedList.head);
//        System.out.println("After: ");
//        singleLinkedList.display(reversedHead);
        singleLinkedList.display(singleLinkedList.head);
//        System.out.println(singleLinkedList.nthNodefromTheEnd(3).data);
        singleLinkedList.insertNodeInSortedLinkedList(5);
        singleLinkedList.removeAGivenKey(15);
        System.out.println("After: ");
//        singleLinkedList.removeDuplicates();
        singleLinkedList.display(singleLinkedList.head);
//        System.out.println(singleLinkedList.length());
    }

    /****
     * Display
     */
    public void display(ListNode head){
        ListNode current = head;
        while (current != null){
            System.out.print(current.data + "---->");
            current = current.next;
        }
        System.out.println("null");
    }

    /**
     * Length
     */
    public int length(){
        if(head== null){
            return 0;
        }
        ListNode current = head;
        int count = 0;
        while(current!= null){
            count++;
            current = current.next;
        }
        return count;
    }
    /****
     * Inset a node in the beginning
     */
    public void insertNewNodeInTheBeginning(int value){
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    /***
     * Insert a node at the end of the linked list
     */
    public void insertNodeAtTheEnd(int value){
        ListNode newNode = new ListNode(value);
        if (head == null){
            head = newNode;
        }
        ListNode current = head;
        while (null != current.next){
            current = current.next;
        }
        current.next = newNode;
    }

    /****
     * Insert Node at a given position
     */
    public void insertNodeAtAGivenPosition(int value, int position){
        ListNode newNode = new ListNode(value);
        if(position == 1){
            newNode.next = head;
            head = newNode;
        } else {
            ListNode previous = head;
            int count = 1;
            while (count < position-1){
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            newNode.next = current;
            previous.next = newNode;
        }
    }

    /****
     * Delete the first Node
     */
    public ListNode deleteFirstNode(){
        if(head == null){
            return null;
        }
        ListNode current = head;
        head = head.next;
        current.next = null;
        return current;
    }

    /****
     * Delete last Node
     */
    public ListNode deleteLastNode() throws Exception {
        if (head == null){
            throw new Exception("Empty Linked List");
        }
        ListNode current = head;
        ListNode previous = null;
        while (current.next != null){
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;
    }

    /****
     * Delete any node
     */
    public void deleteNodeAtAGivenPosition(int position){
        if (position == 1){
            head = head.next;
        } else {
            ListNode previous = head;
            int count = 1;
            while (count < position - 1) {
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = current.next;
        }
    }

    /***\
     * Search for an element
     */
    public Boolean SearchForAValue(int value){
        if (head == null){
            return false;
        }
        ListNode current = head;
        while (current!=null){
            if (current.data == value){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /***
     * Reverse a linked list
     */

    public ListNode reverseList(ListNode head){
        if (head == null){
            return head;
        }

        ListNode current = head;
        ListNode previous = null;
        ListNode nextNode ;

        while (current!= null){
            nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        return previous;
    }

    /***
     * Nth node from the end
     */
    public ListNode nthNodefromTheEnd(int n){
        if (head == null){
            return null;
        }

        if (n<0){
            throw new IllegalArgumentException("Value Can\t Be negative: " + n);
        }
        int count = 0;
        ListNode mainPtr = head;
        ListNode refPtr = head;
        while (count < n){
            refPtr = refPtr.next;
            count++;
        }
        while (refPtr != null){
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }

    /****
     * remove duplicates from the Linked List
     */

    public void removeDuplicates(){
        if (head == null){
            return;
        }

        ListNode current = head;
        while (current != null && current.next != null){
            if (current.data == current.next.data){
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    /***
     * Insert New Node in a Sorted Linked List
     */
    public ListNode insertNodeInSortedLinkedList(int value){
        ListNode current = head;
        ListNode temp = null;
        ListNode newNode = new ListNode(value);

        if (head==null){
            return newNode;
        }

        while (current != null && current.data < newNode.data){
            temp = current;
            current = current.next;
        }
        newNode.next = current;
        temp.next = newNode;
        return head;
    }

    /***
     * Remove a key from a linked list
     */
    public void removeAGivenKey(int value){
        if (head == null){
            return;
        }

        ListNode current = head;
        ListNode temp = null;

        while (current!= null && current.data != value){
            temp = current;
            current = current.next;
        }

        if (current == null){
            return;
        }

        temp.next = current.next;
    }

    /***
     * Detect a loop in singly linked list
     */
}

