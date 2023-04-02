package Seminar3;

public class LinList {
    private Node head;

    private class Node {
        private int value;
        private Node next;
    }

    public void reverse() {
        if(head != null && head.next != null) { // выполняем разворот, если есть хотя бы 2 значения в списке
            //создаем 3 ноды, которым присваиваем значения:
            //текущему значению присваиваем значение самого первого значения
            //предыдущему ставим ссылку на ноль, так как мы переворачиваем список и первый элемент будет последним, а последний указывает на ноль
            //и заводим временную переменную, в которую кладем второе значение, по нему мы будем шагать по списку
            Node currentNode = head;
            Node previousNode = null;
            Node temp = head.next;
            //в цикле перебираем список до тех пор, пока не дойдем до конца, то есть пока temp, временное следующее значение не станет нулем
            while(temp != null) {
                //переносим значения дальше по списку и перенаправляем ссылки
                currentNode.next = previousNode;
                previousNode = currentNode;
                currentNode = temp;
                //едем дальше по изначальному списку с помощью переменной temp
                temp = temp.next;
            } 
            //перенаправляем конечную ссылку и меняем первое значение
            currentNode.next = previousNode;
            head = currentNode;
        }
    }

    public void addFirst(int value) {
        Node node = new Node();
        node.value = value;
        if (head != null) {
            node.next = head;
        }
        head = node;
    }

    public void removeFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    public boolean find(int value) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public void addLast(int value) {
        Node currentNode = new Node();
        currentNode.value = value;
        if(head == null) {
            head = currentNode;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = currentNode;
        }
    }

    public void removeLast() {
        if(head.next == null) {
            head = null;
            return;
        }
        if (head != null) {
            Node currentNode = head;
            while(currentNode.next != null) {
                if(currentNode.next.next == null) {
                    currentNode.next = null;
                    return;
                }
                currentNode = currentNode.next;
            }
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
