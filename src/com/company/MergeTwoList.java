package com.company;

//Merge two list into one sorted list
public class MergeTwoList {

    ListNode head = null;
    ListNode current = null;

    void insertAtLast(int value) {
        ListNode newNode = new ListNode();
        newNode.val = value;
        newNode.next = null;
        if (current != null)
            current.next = newNode;
        current = newNode;
        if (head == null) head = newNode;
    }

    void insertAtFirst(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    void insertInBetween(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = current.next;
        current.next = newNode;
        current = newNode;
    }

    void compareAndInsert(int newData) {
        current = head;
        if (head == null) {
            insertAtFirst(newData);
        } else {
            while (current != null) {
                if (newData >= current.val && current.next == null) {
                    insertAtLast(newData);
                    break;
                } else if (newData >= current.val && current.next != null) {
                    if (newData < current.next.val) {
                        insertInBetween(newData);
                        break;
                    } else {
                        current = current.next;
                    }
                } else if (newData < current.val && current == head) {
                    insertAtFirst(newData);
                    break;
                }
            }
        }
    }

    void mergeList(ListNode l1, ListNode l2) {
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                compareAndInsert(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                compareAndInsert(l2.val);
                l2 = l2.next;
            }
        }
    }

    public void displayList() {
        current = head;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
        System.out.println("****");
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MergeTwoList l1 = new MergeTwoList();
        l1.insertAtLast(1);
        l1.insertAtLast(3);
        l1.insertAtLast(6);
        MergeTwoList l2 = new MergeTwoList();
        l2.insertAtLast(2);
        l2.insertAtLast(10);
        l2.insertAtLast(-4);
        l1.displayList();
        l2.displayList();
        MergeTwoList s = new MergeTwoList();
        s.mergeList(l1.head, l2.head);
        s.displayList();
    }
}


