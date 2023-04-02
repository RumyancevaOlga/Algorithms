package Seminar3;

public class Lin2List {

    private Node head;

    public Node getHead() {
        return head;
    }

    private Node tail;

    private class Node {
        private int value;
        private Node next;
        private Node previous;
    }
    //функции из лекции 
    public void reverse() {
        if(head != null && head.next != null) { 
            //если в списке есть хотя бы два значения, вызываем вспомогательную функцию, 
            //в которую передаем эти два значения
            reverse(head.next, head);
        }
    }
    //вспомогательная функция 
    private void reverse(Node currentNode, Node previousNode) {//получаем 2 значения (текущее и предыдущее) из предыдущей функции
        if (currentNode.next == null) { //проверяем есть ли следующее за текущим значение
            head = currentNode; // если его нет, то присваиваем голову текущему значению
        } else {
            reverse(currentNode.next, currentNode); // иначе, рекурсивно запускаем функцию, передавая в нее следующие значения
        }
        currentNode.next = previousNode;
        previousNode.next = null; //если зашли в условие if, то меняем ссылки 
    }

    //сортировка пузырьком
    public void bubbleSort() { 
        boolean swap; 
        Node currentNode; 
        Node lastNode = null; 
        Node start = head;
  
        // Проверка на то, что список не пустой 
        if (start != null) {
            do
            { 
                swap = true;//устанавливаем в положение true 
                currentNode = start;//начинаем с начала списка 
  
                while (currentNode.next != lastNode) //если следующее значение не равно последнему, то есть null
                { 
                    if (currentNode.value > currentNode.next.value) 
                    { 
                        //если текущее значение больше следующего, то меняем их местами
                        int t = currentNode.value;
                        currentNode.value = currentNode.next.value;
                        currentNode.next.value = t;
                        swap = false; // назначаем false, если заходим в цикл
                    } 
                    //берем следующее значение списка
                    currentNode = currentNode.next; 
                } 
            } 
            while(!swap);//закончится, когда не зайдем во вложенный цикл
        }
    } 

    public void addFirst(int value) {
        Node node = new Node();
        node.value = value;

        if(head!= null) {
            node.next = head;
            head.previous = node;
        } else {
            tail = node; // ошибка в семинаре
        }
        head = node;
    }

    public void removeFirst() {
        if(head != null && head.next != null) {
            head.next.previous = null;
            head = head.next;
        } else {
            tail = null;
            head = null;
        }
    }

    public void addLast(int value) {
        Node currentNode = new Node();
        currentNode.value = value;
        if(tail != null){
            currentNode.previous = tail;
            tail.next = currentNode;
        } else {
            head = currentNode;
        }
        tail = currentNode;
    }

    public void removeLast() {
        if (tail != null && tail.previous != null) {
            tail.previous.next = null;
            tail = tail.previous;
        } else {
            head = null;
            tail = null;
        }
    }

    public void print() {
        Node node = head;
        while(node != null) {
            System.out.print(node.value + " -> ");
            node = node.next;
        }
    }
}
