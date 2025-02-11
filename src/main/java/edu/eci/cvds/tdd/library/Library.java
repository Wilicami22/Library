package edu.eci.cvds.tdd.library;

import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.loan.Loan;
import edu.eci.cvds.tdd.library.loan.LoanStatus;
import edu.eci.cvds.tdd.library.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Library responsible for manage the loans and the users.
 */
public class Library {

    private final List<User> users;
    private final Map<Book, Integer> books;
    private final List<Loan> loans;

    public Library() {
        users = new ArrayList<>();
        books = new HashMap<>();
        loans = new ArrayList<>();
    }

    /**
     * Adds a new {@link edu.eci.cvds.tdd.library.book.Book} into the system, the book is store in a Map that contains
     * the {@link edu.eci.cvds.tdd.library.book.Book} and the amount of books available, if the book already exist the
     * amount should increase by 1 and if the book is new the amount should be 1, this method returns true if the
     * operation is successful false otherwise.
     *
     * @param book The book to store in the map.
     *
     * @return true if the book was stored false otherwise.
     */
    public boolean addBook(Book book) {
        if (book == null) {
            return false;
        }

        for (Book book1 : books.keySet()) {
            if (book.getIsbn().equals(book1.getIsbn()) && !(book.getTittle().equals(book1.getTittle()))) {
                return false;
            }
        }
        if (books.containsKey(book)) {
            books.put(book, books.get(book) + 1);
        } else {
            books.put(book, 1);
        }

        return true;
    }
    /**
     * Return the books in the library
     */
    public Map<Book, Integer> getBooks() {
        return books;
    }

    /**
     * This method creates a new loan with for the User identify by the userId and the book identify by the isbn,
     * the loan should be store in the list of loans, to successfully create a loan is required to validate that the
     * book is available, that the user exist and the same user could not have a loan for the same book
     * {@link edu.eci.cvds.tdd.library.loan.LoanStatus#ACTIVE}, once these requirements are meet the amount of books is
     * decreased and the loan should be created with {@link edu.eci.cvds.tdd.library.loan.LoanStatus#ACTIVE} status and
     * the loan date should be the current date.
     *
     * @param userId id of the user.
     * @param isbn book identification.
     *
     * @return The new created loan.
     */
    public Loan loanABook(String userId, String isbn) {
        Loan currentLoan = new Loan();
        Book bookLoan = null;
        Boolean alreadyLoaned = false;
        for (Book book : books.keySet()) {
            if (book.getIsbn().equals(isbn) && books.get(book)>0) {
                bookLoan = book;
            }
        }
        User userLoan = null;
        for (User user : users) {
            if (user.getId().equals(userId)) {
                userLoan = user;
            }
        }
        for (Loan loan : loans) {
            if (loan.getUser().equals(userLoan) && loan.getBook().equals(bookLoan)) {
                alreadyLoaned = true;
            }
        }
        if (bookLoan == null || userLoan == null || alreadyLoaned) {
            return currentLoan;
        }

        currentLoan.setUser(userLoan);
        currentLoan.setBook(bookLoan);
        loans.add(currentLoan);
        Integer currentBookValue = books.get(bookLoan);
        books.put(bookLoan, currentBookValue - 1);
        currentLoan.setStatus(LoanStatus.ACTIVE);
        currentLoan.setLoanDate(LocalDateTime.now());
        return currentLoan;
    }

    /**
     * This method return a loan, meaning that the amount of books should be increased by 1, the status of the Loan
     * in the loan list should be {@link edu.eci.cvds.tdd.library.loan.LoanStatus#RETURNED} and the loan return
     * date should be the current date, validate that the loan exist.
     *
     * @param loan loan to return.
     *
     * @return the loan with the RETURNED status.
     */
    public Loan returnLoan(Loan loan) {
        boolean loanExist = false;
        for (Loan loan1 : loans) {
            if (loan == loan1) {
                loanExist = true;
            }
        }
        if (!loanExist) {
            return loan;
        }

        Integer currentBookValue = books.get(loan.getBook());
        books.put(loan.getBook(), currentBookValue + 1);
        loan.setStatus(LoanStatus.RETURNED);
        loan.setReturnDate(LocalDateTime.now());
        return loan;
    }

    public List<User> getUsers(){
        return users;
    }

    public boolean addUser(User user) {
        return users.add(user);
    }

    public List<Loan> getLoans() {
        return loans;
    }
}