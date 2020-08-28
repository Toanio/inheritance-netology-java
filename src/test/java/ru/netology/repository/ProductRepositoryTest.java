package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    Book first = new Book(1, "Elephant", 100, "Kuprin");
    Book second = new Book(2,"Stories for young children",100,"Tolstoy");
    Book third = new Book(3,"Fur Seal",100,"Baruzdin");
    Smartphone four = new Smartphone(4,"Xiaomi 5A",200,"China");
    Smartphone  five = new Smartphone(5,"Sumsung Galaxy",200,"China");
    Smartphone six = new Smartphone(6,"Nokia",200, "Vietnam");

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(four);
        repository.save(five);
        repository.save(six);
    }

    @Test
    void shouldSave() {

        Product[] actual = repository.getAll();
        Product[] expected = new Product[]{first, second, third, four,five,six};

        assertArrayEquals(expected, actual);

    }
    @Test
    void shouldFindById() {
        int idToFind = 2;
        repository.removeById(idToFind);

        Product[] actual = repository.getAll();
        Product[] expected = new Product[]{first, third, four,five,six};

        assertArrayEquals(expected, actual);

    }

}