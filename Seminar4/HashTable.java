package Seminar4;

public class HashTable <T, K> {

    private Basket<T, K>[] baskets;
    private static final int BASKET_COUNT = 16; 
    private static final double LOAD_FACTOR = 0.75;
    private int size = 0;

    public K get(T key) {
        int index = calculateIndex(key);
        Basket<T, K> basket = baskets[index];
        if (basket != null) {
            return basket.find(key);
        }
        return null;
    }

    private int calculateIndex(T key) {
        return Math.abs(key.hashCode()) % baskets.length;
    }

    private void recalculate() {
        Basket<T, K>[] old = baskets;
        baskets = (Basket<T, K>[]) new Object[old.length * 2];
        for (int i = 0; i < old.length; i++) {
            Basket basket = old[i];
            Basket.Node node = basket.head;
            while(node != null) {
                put((T)node.entity.key, (K)node.entity.value);
                node = node.next;
            }
            old[i] = null;
        }
    }

    public HashTable(int size) {
        baskets = (Basket<T, K>[]) new Object[size];
    }

    public HashTable() {
        this(BASKET_COUNT);
    }

    public boolean put(T key, K value) {
        if(baskets.length * LOAD_FACTOR < size) {
            recalculate();
        }
        int index = calculateIndex(key);
        Basket <T, K> basket = baskets[index];
        if(basket == null) {
            basket = new Basket<>();
            baskets[index] = basket;
        }
        Entity<T, K> entity = new Entity<>();
        entity.key = key;
        entity.value = value;
        boolean add =  basket.add(entity);
        if (add) {
            size++;
        }
        return add;
    }

    public boolean remove(T key) {
        int index = calculateIndex(key);
        Basket<T, K> basket = baskets[index];
        boolean del = basket.delete(key);
        if(del) {
            size--;
        }
        return del;
    }

    private class Basket<T, K> {
        Node head;

        public K find(T key) {
            Node node = head;
            while (node != null) {
                if (node.entity.key.equals(key)) {
                    return node.entity.value;
                } else {
                    node = node.next;
                }
            }
            return null;
        }

        public boolean add(Entity entity) {
            Node node = new Node();
            node.entity = entity;
            if(head != null) {
                Node currentNode = head;
                while(currentNode != null) {
                    if(currentNode.entity.equals(entity)) {
                        return false;
                    }
                    if(currentNode.next == null) {
                        currentNode.next = node;
                        return true;
                    }
                    else {
                        currentNode = currentNode.next;
                    }
                }
            } else {
                head = node;
                return true;
            }
            return false;
        }

        public boolean delete(T key) {
            if (head != null) {
                if (head.entity.key.equals(key)) {
                    head = head.next;
                    return true;
                } else {
                    Node node = head;
                    while (node.next != null) {
                        if(node.next.entity.key.equals(key)) {
                            node.next = node.next.next;
                            return true;
                        }
                        node = node.next;
                    }
                }
            }
            return false;
        }

        private class Node {
            Node next;
            Entity<T, K> entity;
        }
    }

    private static class Entity<T, K> {
        T key;
        K value;
    }
}
