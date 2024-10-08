package org.example;

import java.util.List;


public class HomeWork extends BinaryIntSearchTree {

    /**
     * <h1>Задание 1.</h1>
     * Дан класс BinaryTree, который реализует бинарное дерево поиска.
     * Реализовать метод findMaxDigits, который возвращает массив
     * наибольших элементов в дереве, не превосходящих upperBound.
     * <br/>
     * Пример :
     * коллекция в дереве 1, 2, 3, 4, 5
     * count = 3, upperBound 4
     * ответ [4, 3, 2]

     *
     * @param count максимальное количество элементов в ответе
     * @param upperBound верхняя граница для поиска элементов
     * @return массив найденных максимальных значений не более чем upperBound и длиной не более count, отсортировано от большего к меньшему
     * Сигнатуру метода не меняем
     */



    
    private int size;

    // Для проверки метода fill добавим метод size
    public int size() {
        return size;
    }

    @Override
    public boolean add(int element) {

        if (root == null) {
            root = new Node(element);
            size++;
            return true;
        }
        boolean addElement = root.add(element);
        if (addElement) {
            size++;
        }
        return addElement;
    }

    // Чтобы получить все элементы дерева, добавляем метод fill, сохраняющих все элементы в List
    public void fill(Node node, List list) {
        if (node != null) {
            list.add(node.value);
            fill(node.left, list);
            fill(node.right, list);
        }
    }

    public List<Integer> findMaxDigits(int count, int upperBound) {

        List tmpSortList = new ArrayList();
        List newList = new ArrayList();
        int tmpCount = 0;
        // Заполняем tmpSortList всеми элементами дерева
        this.fill(this.root, tmpSortList);
        // Сортируем полученный список по убыванию
        Collections.sort(tmpSortList, Collections.reverseOrder());
        // Ставим условие прерывания цикла tmpCount != count, что счетчик tmpCount
        // добавления элемента будет равен счетчику в параметрах, цикл прервется
        for (int i = 0; tmpCount != count && i < tmpSortList.size(); i++) {
            // Проверка элемента на верхнюю границу
            if ((int) tmpSortList.get(i) <= upperBound) {
                // Если проверка пройдена добавляем элемент в итоговый список
                newList.add(tmpSortList.get(i));
                // Увеличиваем проверочный счетчик
                tmpCount++;
            }
        }

        System.out.println(tmpSortList);
        System.out.println(newList);
        return newList;
    }
}
