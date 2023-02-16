package org.example.node;

/**
 * Class Description:
 *
 * @author zxcbv
 */
public class TestNode {
    public static void main(String[] args) {
        ListNode nodeHead = new ListNode(0);
        ListNode nextNode;
        // 创建
        nextNode = create(nodeHead);
        // 插入
        insert(nodeHead, nextNode);
        // 替换
        replace(nodeHead, nextNode);
        // 删除
        delete(nodeHead, nextNode);
    }

    static void delete(ListNode nodeHead, ListNode nextNode) {
        while (nextNode != null) {
            if (nextNode.val == 3) {
                ListNode node = nextNode.next.next;
                nextNode.next = node;
            }

            nextNode = nextNode.next;
        }

        nextNode = nodeHead;
        print(nextNode);
    }
    static void replace(ListNode nodeHead, ListNode nextNode) {
        while (nextNode != null) {
            if (nextNode.val == 3) {
                ListNode replaceNode = new ListNode(33);
                ListNode node = nextNode.next.next;
                nextNode.next = replaceNode;
                replaceNode.next = node;
            }

            nextNode = nextNode.next;
        }

        nextNode = nodeHead;
        print(nextNode);
    }

    static void insert(ListNode nodeHead, ListNode nextNode) {
        while (nextNode != null) {
            if (nextNode.val == 3) {
                ListNode insertNode = new ListNode(99);
                ListNode node = nextNode.next;
                nextNode.next = insertNode;
                insertNode.next = node;
            }
            nextNode = nextNode.next;
        }

        nextNode = nodeHead;
        print(nextNode);
    }

    static ListNode create(ListNode nodeHead) {
        ListNode nextNode = nodeHead;

        for (int i = 1; i < 5; i++) {
            ListNode node = new ListNode(i);

            nextNode.next = node;

            nextNode = nextNode.next;
        }

        nextNode = nodeHead;
        print(nextNode);

        return nextNode;
    }

    static void print(ListNode listNode) {
        while (listNode!= null) {
            System.out.println("节点: " + listNode.val);

            listNode = listNode.next;
        }

        System.out.println();
    }
}
