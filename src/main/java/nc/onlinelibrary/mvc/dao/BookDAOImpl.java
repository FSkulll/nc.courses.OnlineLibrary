package nc.onlinelibrary.mvc.dao;

import nc.onlinelibrary.mvc.domain.Book;
import nc.onlinelibrary.mvc.domain.Issue;
import nc.onlinelibrary.mvc.domain.Users;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addBook(Book book) {
        book.setAvailable(true);
        sessionFactory.getCurrentSession().save(book);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> listBook() {
        return sessionFactory.getCurrentSession().createQuery("from Book").list();
    }

    @Override
    public void removeBook(Integer book_id) {
        Book book = (Book)sessionFactory.getCurrentSession().load(Book.class, book_id);
        if(book != null){
            sessionFactory.getCurrentSession().delete(book);
        }
    }

    @Override
    public Book getBook(Integer book_id) {
        Book book = (Book)sessionFactory.getCurrentSession().get(Book.class, book_id);
        return book;
    }

    @Override
    public Book returnBook(Integer book_id, Users user) {
        Book book = (Book)sessionFactory.getCurrentSession().get(Book.class, book_id);
        List<Issue> issueList = sessionFactory.getCurrentSession().createQuery("from Issue").list();
        for (Issue issue : issueList) {
            if(issue.getReadBook().getBookId() == book_id && issue.getReadUsername().getUsername().equals(user.getUsername())){
                issue.setDateOfReturn(new Date());
            }
        }
        book.setAvailable(true);
        book.setOwner(null);
        return book;
    }

    @Override
    public List<Book> searchBooks(String str) {
        List<Book> books = new ArrayList<Book>();
        for (Book book : listBook()) {
            if(book.getTitle().contains(str) || book.getTitle().contains(str) || book.getIsbn().toString().contains(str)){
                books.add(book);
            }
        }
        return books;
    }

    @Override
    public Book getBookIssue(Integer book_id) {
        Book book = (Book) sessionFactory.getCurrentSession().get(Book.class, book_id);
        Hibernate.initialize(book.getIssueList());
        return book;
    }

    @Override
    public void setAvailable(Integer book_id, boolean value) {
        Book book = (Book) sessionFactory.getCurrentSession().get(Book.class, book_id);
        book.setAvailable(value);
    }
}
