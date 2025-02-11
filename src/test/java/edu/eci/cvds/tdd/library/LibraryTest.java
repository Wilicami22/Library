package edu.eci.cvds.tdd.library;
import static org.junit.jupiter.api.Assertions.*;

import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.loan.Loan;
import edu.eci.cvds.tdd.library.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        library.loanABook("001", "123");
        library.loanABook("002", "123");
        assertEquals(1, library.getLoans().size());
    }

    @Test
    void shouldValidateUserWithTheSameBook(){
        library.addBook(book1);
        library.addBook(book1);
        library.addUser(user1);
        library.loanABook("001", "123");
        library.loanABook("001", "123");
        assertEquals(1, library.getLoans().size());
    }
}
