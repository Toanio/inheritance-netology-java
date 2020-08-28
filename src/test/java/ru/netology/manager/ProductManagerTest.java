package ru.netology.manager;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {


    private ProductManager manager = new ProductManager(new ProductRepository());
    Book first = new Book(1, "Elephant", 100, "Kuprin");
    Book second = new Book(2, "Stories for young children", 100, "Tolstoy");
    Book third = new Book(3, "Fur Seal", 100, "Baruzdin");
    Smartphone four = new Smartphone(4, "Xiaomi 5A", 200, "China");
    Smartphone fifth = new Smartphone(5, "Sumsung Galaxy", 200, "Korea");
    Smartphone sixth = new Smartphone(6, "Nokia", 200, "Vietnam");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(four);
        manager.add(fifth);
        manager.add(sixth);

    }

    @Test
    void shouldTest() {
        int idToRemove = 2;
        manager.removeById(idToRemove);

        Product[] actual = manager.findAll();
        Product[] expected = new Product[]{first, third, four, fifth, sixth};

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldFindBookByName() {

        Product[] actual = manager.searchBy("Stories for young children");
        Product[] expected = new Product[]{second};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindBookByAuthor() {

        Product[] actual = manager.searchBy("Baruzdin");
        Product[] expected = new Product[]{third};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindPhoneByName() {

        Product[] actual = manager.searchBy("Sumsung Galaxy");
        Product[] expected = new Product[]{fifth};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindPhoneByManufacturer() {

        Product[] actual = manager.searchBy("China");
        Product[] expected = new Product[]{four};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindAnyProducts() {
        Product[] actual = manager.searchBy("Fan");
        Product[] expected = new Product[]{};

        assertArrayEquals(expected, actual);
    }

}