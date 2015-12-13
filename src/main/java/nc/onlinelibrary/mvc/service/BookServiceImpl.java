package nc.onlinelibrary.mvc.service;

import nc.onlinelibrary.mvc.dao.BookDAO;
import nc.onlinelibrary.mvc.domain.Book;
import nc.onlinelibrary.mvc.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.inject.Named;
import java.util.List;

@Named("bookService")
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Transactional
    @Override
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    @Transactional
    @Override
    public List<Book> listBook() {
        return bookDAO.listBook();
    }

    @Transactional
    @Override
    public void removeBook(Integer id) {
        bookDAO.removeBook(id);
    }

    @Transactional
    @Override
    public Book getBook(Integer id) {
        return bookDAO.getBook(id);
    }

    @Transactional
    @Override
    public Book returnBook(Integer id, Users user) {
        return bookDAO.returnBook(id, user);
    }

    @Transactional
    @Override
    public void editBook(Integer id) {

    }

    @Transactional
    @Override
    public List<Book> searchBook(String str) {
        return bookDAO.searchBooks(str);
    }

    @Transactional
    @Override
    public Book getBookIssue(Integer id) {
        return bookDAO.getBookIssue(id);
    }

    @Transactional
    @Override
    public void setAvailable(Integer book_id, boolean value) {
        bookDAO.setAvailable(book_id, value);
    }
}
