package edu.eci.cvds.tdd.library;

import edu.eci.cvds.tdd.library.book.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    private Library library;

    @BeforeEach
    public void setUp() {
        library = new Library();
    }

    @Test
    public void testAddNewBook() {
        Book book = new Book("12345", "Effective Java", "Joshua Bloch");
        assertTrue(library.addBook(book), "El libro debería haberse añadido correctamente.");

        Map<Book, Integer> books = library.getBooks();
        assertTrue(books.containsKey(book), "El mapa debería contener el nuevo libro.");
        assertEquals(1, books.get(book), "La cantidad de libros debería ser 1.");
    }

    @Test
    public void testAddExistingBookIncreasesQuantity() {
        Book book = new Book("12345", "Effective Java", "Joshua Bloch");
        library.addBook(book);
        library.addBook(book);

        Map<Book, Integer> books = library.getBooks();
        assertEquals(2, books.get(book), "La cantidad de libros debería haberse incrementado a 2.");
    }

    @Test
    public void testAddNullBookReturnsFalse() {
        assertFalse(library.addBook(null), "Agregar un libro nulo debería retornar falso.");
    }

    @Test
    public void testAddMultipleDifferentBooks() {
        Book book1 = new Book("12345", "Effective Java", "Joshua Bloch");
        Book book2 = new Book("67890", "Clean Code", "Robert C. Martin");

        library.addBook(book1);
        library.addBook(book2);

        Map<Book, Integer> books = library.getBooks();
        assertEquals(1, books.get(book1), "El mapa debería contener el primer libro con cantidad 1.");
        assertEquals(1, books.get(book2), "El mapa debería contener el segundo libro con cantidad 1.");
    }

    @Test
    public void testNoAddTwoBooksWithSameISBNAndDifferentName() {
        Book book1 = new Book("12345", "Effective Java", "Joshua Bloch");
        Book book2 = new Book("Pedrito", "Rodirigo", "Joshua Bloch");
    }
}
