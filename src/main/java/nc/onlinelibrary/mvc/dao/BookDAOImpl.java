package nc.onlinelibrary.mvc.dao;

import nc.onlinelibrary.mvc.domain.Book;
import nc.onlinelibrary.mvc.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addBook(Book book) {
        book.setIsAvailable(true);
        sessionFactory.getCurrentSession().save(book);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> listBook() {
        return sessionFactory.getCurrentSession().createQuery("from Book").list();
    }

    @Override
    public void removeBook(Integer id) {
        Book book = (Book)sessionFactory.getCurrentSession().load(Book.class, id);
        if(book != null){
            sessionFactory.getCurrentSession().delete(book);
        }
    }

    @Override
    public Book getBook(Integer id) {
        Book book = (Book)sessionFactory.getCurrentSession().get(Book.class, id);
        book.setIsAvailable(false);
        //book.setOwner((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal());//-------?
        return book;
    }

    @Override
    public Book returnBook(Integer id) {
        Book book = (Book)sessionFactory.getCurrentSession().get(Book.class, id);
        book.setIsAvailable(true);
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
}
