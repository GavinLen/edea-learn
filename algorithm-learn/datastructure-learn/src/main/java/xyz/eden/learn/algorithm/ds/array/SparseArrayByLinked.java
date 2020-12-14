package xyz.eden.learn.algorithm.ds.array;

/**
 * 通过链表实现稀疏数组
 * 简介:
 * 当一个数组中大部分元素为相同值, 可以通过稀疏数组保存该数组.
 * 处理方式:
 * 1. 将压缩数组中的元素通过链表实现
 *
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2020/12/10 9:57
 */
public class SparseArrayByLinked {

    public static void main(String[] args) {

        Solution solution = new SparseArrayByLinked().new Solution();

        SparseArrayByLinked.Node rootNode =  new SparseArrayByLinked().new Node();
        rootNode.x = 1;
        rootNode.y = 1;
        rootNode.v = 1;

        SparseArrayByLinked.Node node;
        for (int i = 2; i < 10; i++) {
            node = new SparseArrayByLinked().new Node();
            node.x = i;
            node.y = i;
            node.v = i;

            solution.addNode(rootNode, node);
        }
    }

    class Node {
        int x;
        int y;
        int v;
        Node childNode;
    }

    class Solution {


        /**
         * @param arr
         * @return
         */
        public Node arrayToLinker(int[][] arr) {

            Node root = new Node();
            root.x = arr.length;
            root.y = arr[0].length;

            int eSum = 0;
            for (int i = 0; i < root.x; i++) {
                for (int j = 0; j < root.y; j++) {
                    int e = arr[i][j];
                    if (e != 0) {
                        eSum += 1;
                    }
                }
            }
            root.v = eSum;

            Node eNode;
            for (int i = 0; i < root.x; i++) {
                for (int j = 0; j < root.y; j++) {
                    int e = arr[i][j];
                    if (e != 0) {
                        eNode = new Node();
                        eNode.x = i;
                        eNode.y = j;
                        eNode.v = e;

                        root.childNode = eNode;
                    }
                }
            }
            root.v = eSum;


            return root;
        }

        public Node addNode(Node rootNode, Node newNode) {

            Node createNode = rootNode;
            while (true) {
                Node childNode = createNode.childNode;
                if (childNode != null) {
                    createNode = createNode.childNode;
                } else {
                    createNode.childNode = newNode;
                    return rootNode;
                }
            }
        }

    }

}
