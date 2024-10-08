package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class HomeWorkTest {

    HomeWork homeWork = new HomeWork();

    void createTree(HomeWork homeWork){
        homeWork.add(5);
        homeWork.add(3);
        homeWork.add(1);
        homeWork.add(2);
        homeWork.add(4);
        homeWork.add(8);
        homeWork.add(7);
        homeWork.add(6);
        homeWork.add(10);
        homeWork.add(9);
    }
    // Проверим вспомогательный метод size
    @Test
    void sizeTest() {
        HomeWork homeWork = new HomeWork();
        homeWork.add(5);
        homeWork.add(6);
        homeWork.add(3);
        homeWork.add(1);

        assertEquals(4, homeWork.size());
        for(int i = 0; i < 100; i++){
            homeWork.add(i);
        }
        assertEquals(100, homeWork.size());
        // Добавляем повторяющийся элемент и размер не должен измениться
        homeWork.add(1);
        assertNotEquals(101, homeWork.size());
    }

    // Проверяем метод получения всех элементов дерева fill, сравнив размер дерева
    // с размером полученного списка
    @Test
    void fillTest() {
        // Создаем дерево
        createTree(homeWork);

        List newList = new ArrayList();
        homeWork.fill(homeWork.root, newList);
        assertEquals(homeWork.size(), newList.size());
        homeWork.add(11);
        assertNotEquals(homeWork.size(), newList.size());
    }

    @Test
    void findMaxDigitsTest(){

        // Создаем дерево
        createTree(homeWork);
        assertEquals(10, homeWork.size());
        // Если счетчик count больше размера дерева, и все елементы укладываются
        // под вверхнюю границу upperBound, то вернется список размером с дерево
        assertEquals(homeWork.size(), homeWork.findMaxDigits(100, 100).size());
        // Возврат пустого списка при count = 0
        assertEquals(0, homeWork.findMaxDigits(0, 100).size());
        // Возврат пустого списка при upperBound = 0
        assertEquals(0, homeWork.findMaxDigits(3, 0).size());
        // Частные случаи
        assertEquals(3, homeWork.findMaxDigits(3, 100).size());
        assertEquals(5, homeWork.findMaxDigits(5, 100).size());
        assertEquals(10, homeWork.findMaxDigits(10, 100).size());
        // Если count больше, чем количество элементов меньше или равной верхней границы
        assertEquals(2, homeWork.findMaxDigits(3, 2).size());
    }
}
