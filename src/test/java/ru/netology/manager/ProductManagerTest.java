package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductManager manager = new ProductManager();
    Product book1 = new Book(1, "Book1", 100, "Author1");
    Product book2 = new Book(2, "Book2", 200, "Author2");
    Product smartphone1 = new Smartphone(3, "Smartphone1", 3000, "Manufacturer1");
    Product smartphone2 = new Smartphone(4, "Smartphone2", 4000, "Manufacturer2");
    Product extra = new Product(5, "extra", 0);

    @BeforeEach
    void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(extra);
    }

    @Test
    void shouldSearchBookByName() {
        Product[] actual = manager.searchBy("Book1");
        Product[] expected = new Product[]{book1};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldSearchBookByAuthor() {
        Product[] actual = manager.searchBy("Author2");
        Product[] expected = new Product[]{book2};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldSearchSmartphoneByName() {
        Product[] actual = manager.searchBy("Smartphone1");
        Product[] expected = new Product[]{smartphone1};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldSearchByProducer() {
        Product[] actual = manager.searchBy("Manufacturer2");
        Product[] expected = new Product[]{smartphone2};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldNotSearchExtra() {
        Product[] actual = manager.searchBy("extra");
        Product[] expected = new Product[]{};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldSearchABooksWithOneName() {
        Product[] actual = manager.searchBy("Book");
        Product[] expected = new Product[]{book1, book2};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldSearchDoNotExist() {
        Product[] actual = manager.searchBy("NotExist");
        Product[] expected = new Product[]{};
        assertArrayEquals(actual, expected);
    }
}