package xyz.eden.learn.algorithm.ds.tree;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2020/12/11 10:50
 */
@Data
public class BinaryTreeByLinked<E extends Comparable> {

    private Node<E> rootNode;
    private int size;

    public BinaryTreeByLinked<E> remove(E el) {
        // https://zhuanlan.zhihu.com/p/311745433
        return this;
    }

    public BinaryTreeByLinked<E> put(E el) {
        Node<E> elNode = new Node<>(el, null, null);
        if (rootNode == null) {
            rootNode = elNode;
            size++;
            return this;
        }

        Node<E> currentNode = rootNode;
        Node<E> childNode = null;
        while (true) {
            E item = currentNode.item;
            if (el.compareTo(item) < 0) {
                if (currentNode.leftNode == null) {
                    currentNode.leftNode = elNode;
                    return this;
                } else if (el.compareTo(currentNode.leftNode.item) > 0) {
                    elNode.leftNode = currentNode.leftNode;
                    currentNode.leftNode = elNode;
                    return this;
                }
                currentNode = currentNode.leftNode;
            } else if (el.compareTo(item) > 0) {
                if (currentNode.rightNode == null) {
                    currentNode.rightNode = elNode;
                    return this;
                } else if (el.compareTo(currentNode.rightNode.item) > 0) {

                }
                currentNode = currentNode.rightNode;
            }
        }
    }

    @Data
    @AllArgsConstructor
    private static class Node<E extends Comparable> {
        private E item;
        private Node<E> leftNode;
        private Node<E> rightNode;
    }

}
