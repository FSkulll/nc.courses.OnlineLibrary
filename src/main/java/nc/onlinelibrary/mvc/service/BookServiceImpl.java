package nc.onlinelibrary.mvc.service;

import nc.onlinelibrary.mvc.dao.BookDAO;
import nc.onlinelibrary.mvc.domain.Book;
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
    public Book returnBook(Integer id) {
        return bookDAO.returnBook(id);
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
    public Book getBookWithRead(Integer id) {
        return bookDAO.getBookWithRead(id);
    }
}
