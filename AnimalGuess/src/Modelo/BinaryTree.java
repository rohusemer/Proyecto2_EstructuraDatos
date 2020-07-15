/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Extra.Extra;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Luis A. Sarango-Parrales
 */
public class BinaryTree<T> {

    private BinaryNode<T> root;

    public BinaryTree() {
        this.root = new BinaryNode<>();
    }

    public BinaryTree(T content) {
        this.root = new BinaryNode<>(content);
    }

    public BinaryNode<T> getRoot() {
        return root;
    }

    public void setRoot(BinaryNode<T> root) {
        this.root = root;
    }

    public void setLeft(BinaryTree<T> tree) {
        this.root.setLeft(tree);
    }

    public void setRight(BinaryTree<T> tree) {
        this.root.setRight(tree);
    }

    public BinaryTree<T> getLeft() {
        return this.root.getLeft();
    }

    public BinaryTree<T> getRight() {
        return this.root.getRight();
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean isLeaf() {
        return this.root.getLeft() == null && this.root.getRight() == null;
    }

    public int countLeavesRecursive() { // funciona
        if (this.isEmpty()) {
            return 0;
        } else if (this.isLeaf()) {
            return 1;
        } else {
            int leavesLeft = 0;
            int leavesRight = 0;
            if (this.root.getLeft() != null) {
                leavesLeft = this.root.getLeft().countLeavesRecursive();
            }
            if (this.root.getRight() != null) {
                leavesRight = this.root.getRight().countLeavesRecursive();
            }
            return leavesLeft + leavesRight;
        }
    }

    public int countLeavesIterative() { // funciona
        Stack<BinaryTree<T>> stack = new Stack();
        int count = 0;
        if (this.isEmpty()) {
            return count;
        } else {
            stack.push(this);
            while (!stack.empty()) {
                BinaryTree<T> subtree = stack.pop();
                if (subtree.root.getLeft() != null) {
                    stack.push(subtree.root.getLeft());
                }
                if (subtree.root.getRight() != null) {
                    stack.push(subtree.root.getRight());
                }
                if (subtree.isLeaf()) {
                    count++;
                }
            }
        }
        return count;
    }

    public BinaryNode<T> recursiveSearch(T content) { // funciona
        if (this.isEmpty()) {
            return null;
        } else {
            if (this.root.getContent().equals(content)) {

                return this.root;
            } else {
                BinaryNode<T> tmp = null;
                if (this.root.getLeft() != null) {
                    tmp = this.root.getLeft().recursiveSearch(content);
                }
                if (tmp == null) {
                    if (this.root.getRight() != null) {
                        return this.root.getRight().recursiveSearch(content);
                    }
                }
                return tmp;
            }
        }
    }

    public BinaryNode<T> iterativeSearch(T data) { // funciona

        if (data == null) {
            return null;
        }
        Stack<BinaryTree<T>> s = new Stack();
        s.push(this);

        while (!s.isEmpty()) {
            BinaryTree<T> temp = s.pop();

            if (temp.root.getContent().equals(data)) {
                return temp.root;
            }

            if ((temp.root.getRight()) != null) {
                s.push(temp.root.getRight());
            }

            if ((temp.root.getLeft()) != null) {
                s.push(temp.root.getLeft());
            }
        }
        return null;

    }

    public void preOrdenRecursive(BinaryTree<T> p) { // funciona
        if (p != null) {
            System.out.print(p.root.getContent() + " ");
            preOrdenRecursive(p.getLeft());
            preOrdenRecursive(p.getRight());
        }
    }

    public void preOrderIterative(BinaryTree<T> p) { // funciona

        if (p == null) {
            return;
        }

        Stack<BinaryTree<T>> s = new Stack();
        s.push(this);

        while (!s.isEmpty()) {
            BinaryTree<T> temp = s.pop();
            System.out.print(temp.root.getContent() + " ");

            if ((temp.root.getRight()) != null) {
                s.push(temp.root.getRight());
            }

            if ((temp.root.getLeft()) != null) {
                s.push(temp.root.getLeft());
            }
        }

    }

    public void postOrdenRecursive(BinaryTree<T> p) { // funciona

        if (p != null) {
            postOrdenRecursive(p.getLeft());
            postOrdenRecursive(p.getRight());
            System.out.print(p.root.getContent() + " ");
        }

    }

    public void postOrdenIterative(BinaryTree<T> p) { // funciona
        if (p == null) {
            return;
        }

        BinaryTree<T> temp = p;

        Stack<BinaryTree<T>> stack = new Stack<>();
        stack.push(p);

        while (!stack.isEmpty()) {
            p = stack.peek();

            boolean isRootWithPrintedChildren = temp == p.root.getLeft() || temp == p.root.getRight();

            if (p.isLeaf() || isRootWithPrintedChildren) {
                System.out.print(p.root.getContent() + " ");
                stack.pop();
                temp = p;

            } else {
                if (p.root.getRight() != null) {
                    stack.push(p.root.getRight());
                }
                if (p.root.getLeft() != null) {
                    stack.push(p.root.getLeft());
                }
            }
        }
    }

    public void inOrdenRecursive(BinaryTree<T> p) { // funciona

        if (p != null) {
            inOrdenRecursive(p.getLeft());
            System.out.println(p.root.getContent() + " ");
            inOrdenRecursive(p.getRight());
        }

    }

    public void inOrderIterative() { // funciona
        if (isEmpty()) {
            return;
        }

        Stack<BinaryTree<T>> s = new Stack();
        BinaryTree<T> temp = this;

        while (temp != null || !s.isEmpty()) {

            while (temp != null) {
                s.push(temp);
                temp = temp.getLeft();
            }
            temp = s.pop();
            System.out.print(temp.root.getContent() + " ");

            temp = temp.getRight();
        }
        System.out.println();

    }

    public int getMinRecursive() { // funciona
        return getMinRecursive(this);
    }

    private Integer getMinRecursive(BinaryTree<T> node) { // funciona
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        int res = (Integer) node.root.getContent();

        int lres = getMinRecursive(node.root.getLeft());
        int rres = getMinRecursive(node.root.getRight());

        if (lres < res) {
            res = lres;
        }
        if (rres < res) {
            res = rres;
        }

        return res;
    }

    public Integer getMinIterative() { // funciona

        int smallest = Integer.MAX_VALUE;

        Stack<BinaryTree<T>> s = new Stack();
        s.push(this);

        while (!s.isEmpty()) {
            BinaryTree<T> temp = s.pop();

            int n = (Integer) temp.root.getContent();

            if (n < smallest) {
                smallest = n;
            }

            if ((temp.root.getRight()) != null) {
                s.push(temp.root.getRight());
            }

            if ((temp.root.getLeft()) != null) {
                s.push(temp.root.getLeft());
            }
        }
        return smallest;

    }

    public int countLevelsRecursive() { // funciona
        return countLevelsRecursive(this);
    }

    private int countLevelsRecursive(BinaryTree<T> node) { // funciona
        if (node == null) {
            return 0;
        } else {
            int lDepth = countLevelsRecursive(node.root.getLeft());
            int rDepth = countLevelsRecursive(node.root.getRight());

            if (lDepth > rDepth) {
                return (lDepth + 1);
            } else {
                return (rDepth + 1);
            }
        }
    }

    /*public int countLevelsRecursive() { // josie
    if (this.isEmpty()) {
    return 0;
    }
    
    int l = 0, r = 0;
    
    if (this.getLeft() != null) {
    l = this.getLeft().countLevelsRecursive();
    }
    if (this.getRight() != null) {
    l = this.getRight().countLevelsRecursive();
    }
    
    return 1 + Math.max(1, r);
    }*/
    public int countLevelsIterative() {
        if (this == null) {
            return 0;
        }

        Queue<BinaryTree<T>> q = new LinkedList();

        q.add(this);
        int height = 0;

        while (true) {

            int nodeCount = q.size();
            if (nodeCount == 0) {
                return height;
            }
            height++;

            while (nodeCount > 0) {
                BinaryTree<T> newnode = q.peek();
                q.remove();
                if (newnode.root.getLeft() != null) {
                    q.add(newnode.root.getLeft());
                }
                if (newnode.root.getRight() != null) {
                    q.add(newnode.root.getRight());
                }
                nodeCount--;
            }
        }
    }

    public boolean isIdenticalRecursive(BinaryTree<T> tree) { // josie

        if (tree == null) {
            return false;
        }
        boolean content = this.root.equals(tree.root.getContent());

        if (content && tree.isLeaf() && this.isLeaf()) {
            return true;
        }

        boolean left = this.getLeft() == null && tree.getLeft() == null;
        boolean right = this.getRight() == null && tree.getRight() == null;

        if (this.getLeft() != null) {
            left = content && this.getLeft().isIdenticalRecursive(tree.getLeft());
        }
        if (this.getRight() != null) {
            right = content && this.getRight().isIdenticalRecursive(tree.getRight());
        }
        return left && right;

    }

    public boolean isIdenticalIterative(BinaryTree<T> tree2) {
        if (this.root == null && tree2.root == null) {
            return true;
        }

        if (this.root == null || tree2.root == null) {
            return false;
        }

        Queue<BinaryTree<T>> q1 = new LinkedList();
        Queue<BinaryTree<T>> q2 = new LinkedList();

        q1.add(this);
        q2.add(tree2);

        while (!q1.isEmpty() && !q2.isEmpty()) {

            BinaryTree<T> n1 = q1.poll();
            BinaryTree<T> n2 = q2.poll();

            if (n1.root.getContent() != n2.root.getContent()) {
                return false;
            }

            if (n1.root.getLeft() != null && n2.root.getLeft() != null) {
                q1.add(n1.root.getLeft());
                q2.add(n2.root.getLeft());
            } else if (n1.root.getLeft() != null || n2.root.getLeft() != null) {
                return false;
            }

            if (n1.root.getRight() != null && n2.root.getRight() != null) {
                q1.add(n1.root.getRight());
                q2.add(n2.root.getRight());
            } else if (n1.root.getRight() != null || n2.root.getRight() != null) {
                return false;
            }
        }

        return true;
    }

    public int size() {

        return size(this);
    }

    private int size(BinaryTree<T> viajero) {

        if (viajero == null) {
            return 0;
        }

        return 1 + size(viajero.getLeft()) + size(viajero.getRight());

    }

    /// Practica Codigos de Huffman
    private Map<Character, Integer> buildMap(String cadena) {
        Map<Character, Integer> uniqueCharacters = new HashMap();
        for (Character c : cadena.toCharArray()) {
            if (!uniqueCharacters.containsKey(c)) {
                uniqueCharacters.put(c, 0);
            }
        }
        return uniqueCharacters;
    }

    public Map<Character, Integer> getFrecuencies(String cadena) {
        Map<Character, Integer> caracterFrecuencia = buildMap(cadena);
        for (Character c : cadena.toCharArray()) {
            int anterior = caracterFrecuencia.get(c);
            caracterFrecuencia.replace(c, anterior + 1);
        }
        return caracterFrecuencia;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Proyecto Final
    private int binarySum(int n) {
        return (1 - ((int) Math.pow(2, n + 1))) / (1 - 2);
    }

    private void fillQuestions(DecisionContent newQuestion, BinaryTree<DecisionContent> parent, int i) {
        if (parent.isLeaf()) {

            parent.root.setLeft(new BinaryTree(newQuestion));

            parent.root.setRight(new BinaryTree(newQuestion));
            return;
        }
        if (binarySum(i) != this.size()) { // llena solamente hasta cierto nivel i 

            fillQuestions(newQuestion, parent.root.getLeft(), i);
            fillQuestions(newQuestion, parent.root.getRight(), i);

        }
    }

    public BinaryTree<DecisionContent> buildQuestionsTree(String[] preguntas) {
        DecisionContent p1 = new DecisionContent(preguntas[0], false);
        BinaryTree<DecisionContent> questionsTree = new BinaryTree(p1);

        for (int i = 1; i < preguntas.length; i++) {
            DecisionContent dc = new DecisionContent(preguntas[i], false);

            questionsTree.fillQuestions(dc, questionsTree, i);
        }

        return questionsTree;

    }

    public BinaryTree<DecisionContent> buildGameTree(String[] preguntas, Map<String, String> animalesRptas) {
        BinaryTree<DecisionContent> tree = buildQuestionsTree(preguntas);
        for (String animal : animalesRptas.keySet()) {

            DecisionContent dc = new DecisionContent(animal, true);
            dc.setCode(animalesRptas.get(animal));
            tree.putAnimal(dc);
        }

        return tree;

    }

    private void putAnimal(DecisionContent dc) {
        BinaryTree<DecisionContent> subtree = (BinaryTree<DecisionContent>) this;

        String[] codigo = dc.getCode().trim().split(" ");

        for (int i = 0; i < codigo.length; i++) {

            if (i != codigo.length - 1) { // recorrido hasta el penultimo
                //String previousCode = subtree.root.getContent().getCode();

                if (codigo[i].equals("Si")) {
                    subtree = subtree.root.getLeft();
                    // subtree.root.getContent().setCode(previousCode + " Si");

                } else if (codigo[i].equals("No")) {
                    subtree = subtree.root.getRight();
                    // subtree.root.getContent().setCode(previousCode + " No");
                }
            }
        }

        //ultimo paso
        if (codigo[codigo.length - 1].equals("Si")) {
            subtree.root.setLeft(new BinaryTree(dc));
        } else if (codigo[codigo.length - 1].equals("No")) {
            subtree.root.setRight(new BinaryTree(dc));
        }

    }

    public List<String> getResults(String s) {
        List<String> results = new ArrayList();
        fillResults(s, (BinaryTree<DecisionContent>) this, results);
        return results;
    }

    private void fillResults(String s, BinaryTree<DecisionContent> tree, List<String> results) {

        if (tree.isLeaf() && Extra.isContained(s.trim(), tree.root.getContent().getCode())) {
            results.add(tree.root.getContent().getContent());

        }

        if (tree.root.getLeft() != null) {
            fillResults(s.trim(), tree.root.getLeft(), results);
        }

        if (tree.root.getRight() != null) {
            fillResults(s.trim(), tree.root.getRight(), results);
        }

    }

    @Override
    public String toString() {
        return "BinaryTree{" + "root=" + root.getContent() + '}';
    }

}
