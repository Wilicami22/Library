package edu.eci.cvds.tdd.library;
import static org.junit.jupiter.api.Assertions.*;

import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.loan.Loan;
import edu.eci.cvds.tdd.library.loan.LoanStatus;
import edu.eci.cvds.tdd.library.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private Library library;
    private Book book1;
    private User user1;
    private User user2;

    @BeforeEach
    void setUp() {
        library = new Library();
        book1 = new Book("Doce cuentos peregrinos","Gabriel Garcia Marquez","101");
        user1 = new User(); user1.setName("Wiliam H"); user1.setId("001");
        user2 = new User(); user2.setName("Nicolas T"); user2.setId("002");
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
        library.addBook(book1);
        library.addBook(book2);
    }

    @Test
    void shouldCreateLoanWithUserIdAndBookIsbn() {
        library.addBook(book1);
        library.addUser(user1);
        library.loanABook("001", "101");
        assertEquals(1, library.getLoans().size());
    }

    @Test
    void shouldValidateThereIsUserAndBook(){
        library.addBook(book1);
        library.addUser(user1);
        library.loanABook("695", "654");
        assertEquals(0, library.getLoans().size());
    }

    @Test
    void shouldValidateAvailabilityOfBooks(){
        library.addBook(book1);
        library.addUser(user1);
        library.addUser(user2);
        library.loanABook("001", "101");
        library.loanABook("002", "101");
        assertEquals(1, library.getLoans().size());
    }

    @Test
    void shouldValidateUserWithTheSameBook(){
        library.addBook(book1);
        library.addBook(book1);
        library.addUser(user1);
        library.loanABook("001", "101");
        library.loanABook("001", "101");
        assertEquals(1, library.getLoans().size());
    }

    @Test
    void shouldValidateStatusActive(){
        library.addBook(book1);
        library.addUser(user1);
        Loan loan1 = library.loanABook("001", "101");
        assertEquals(LoanStatus.ACTIVE, loan1.getStatus());
    }

    @Test
    void shouldValidateCurrentDate(){
        library.addBook(book1);
        library.addUser(user1);
        Loan loan1 = library.loanABook("001", "101");
        assertEquals(LocalDateTime.now(), loan1.getLoanDate());
    }


}
