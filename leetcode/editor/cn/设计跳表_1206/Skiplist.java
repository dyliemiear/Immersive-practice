package editor.cn.设计跳表_1206;//不使用任何库函数，设计一个跳表。
//
// 跳表是在 O(log(n)) 时间内完成增加、删除、搜索操作的数据结构。跳表相比于树堆与红黑树，其功能与性能相当，并且跳表的代码长度相较下更短，其设计思想
//与链表相似。 
//
// 例如，一个跳表包含 [30, 40, 50, 60, 70, 90]，然后增加 80、45 到跳表中，以下图的方式操作： 
//
// 
//Artyom Kalinin [CC BY-SA 3.0], via Wikimedia Commons 
//
// 跳表中有很多层，每一层是一个短的链表。在第一层的作用下，增加、删除和搜索操作的时间复杂度不超过 O(n)。跳表的每一个操作的平均时间复杂度是 O(log(
//n))，空间复杂度是 O(n)。 
//
// 在本题中，你的设计应该要包含这些函数： 
//
// 
// bool search(int target) : 返回target是否存在于跳表中。 
// void add(int num): 插入一个元素到跳表。 
// bool erase(int num): 在跳表中删除一个值，如果 num 不存在，直接返回false. 如果存在多个 num ，删除其中任意一个即可。 
//
// 
//
// 了解更多 : https://en.wikipedia.org/wiki/Skip_list 
//
// 注意，跳表中可能存在多个相同的值，你的代码需要处理这种情况。 
//
// 样例: 
//
// editor.cn.设计跳表_1206.Skiplist skiplist = new editor.cn.设计跳表_1206.Skiplist();
//
//skiplist.add(1);
//skiplist.add(2);
//skiplist.add(3);
//skiplist.search(0);   // 返回 false
//skiplist.add(4);
//skiplist.search(1);   // 返回 true
//skiplist.erase(0);    // 返回 false，0 不在跳表中
//skiplist.erase(1);    // 返回 true
//skiplist.search(1);   // 返回 false，1 已被擦除
// 
//
// 约束条件: 
//
// 
// 0 <= num, target <= 20000 
// 最多调用 50000 次 search, add, 以及 erase操作。 
// 
// Related Topics 设计 链表 
// 👍 75 👎 0

import java.util.Objects;
import java.util.Random;

/**
 * 跳表 查找、插入、删除时间复杂度O(logN), 空间复杂度 O(N)
 */

//leetcode submit region begin(Prohibit modification and deletion)

// 执行用时：17 ms, 在所有 Java 提交中击败了95.81%的用户
//内存消耗：44.2 MB, 在所有 Java 提交中击败了66.44%的用户


class Skiplist {

    private static final double PROBABILITY = 0.5;
    private static final int MAX_LEVEL = 16;
    Node head;

    public Skiplist() {
        head = new Node(-1, true);
    }

    public boolean search(int num) {
        Node node = searchNode(num);
        return node.data == num;
    }

    public Object add(int num) {
        Node node = searchNode(num);
        Node newNode = new Node(num);
        for(int i =0; i<newNode.fw.length; i++){
            Node n = node;
            while (n.bw != null && n.fw.length < i+1){
                n = n.bw;
            }
            if(i == 0){
                if(n.fw[i] != null){
                    n.fw[i].bw = newNode;
                }
                newNode.bw = n;
            }

            newNode.fw[i] = n.fw[i];
            n.fw[i] = newNode;


        }
        return null;
    }

    public boolean erase(int num) {
        Node node = searchNode(num);
        if(node.data != num){
            return false;
        }
        for(int i =0; i<node.fw.length; i++){
            Node n = node.bw;
            while (n.bw != null && n.fw.length < i+1){
                n = n.bw;
            }
            if(i == 0 && node.fw[i] != null){
                node.fw[i].bw = n;
            }
            n.fw[i] = node.fw[i];

        }
        return true;
    }

    private void printList(){

        for (int i = MAX_LEVEL-1; i>=0; i--){
            Node node = head;
            if(node.fw[i] != null){
                StringBuilder stringBuilder = new StringBuilder();
                while (node.fw[i] != null){
                    stringBuilder.append(node.fw[i].data).append(" ");
                    node = node.fw[i];
                }
                System.out.println(stringBuilder.toString());
            }
        }
    }

    private Node searchNode(int num){
        Node node = head;
        for (int i = MAX_LEVEL - 1; i>=0; i--){
            if(node.data == num){
                return node;
            }
            while (node.data < num && node.fw[i] != null && node.fw[i].data <= num){
                node = node.fw[i];
            }
        }
        return node;
    }

    private class Node{


        private int data;
        private Node[] fw;
        private Node bw;

        public Node(int num){
            this.data = num;
            this.fw = new Node[randomLevel()];
        }

        public Node(int num, boolean maxLevelFlag){
            this.data = num;
            if(maxLevelFlag){
                this.fw = new Node[MAX_LEVEL];
            }
            else {
                this.fw = new Node[randomLevel()];
            }
        }

        private int randomLevel(){
            for(int i = 1; i<MAX_LEVEL; i++){
                if(Math.random() <= PROBABILITY){
                    return i;
                }
            }
            return MAX_LEVEL;
        }
    }
}

/**
 * Your editor.cn.设计跳表_1206.Skiplist object will be instantiated and called as such:
 * editor.cn.设计跳表_1206.Skiplist obj = new editor.cn.设计跳表_1206.Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */
//leetcode submit region end(Prohibit modification and deletion)
