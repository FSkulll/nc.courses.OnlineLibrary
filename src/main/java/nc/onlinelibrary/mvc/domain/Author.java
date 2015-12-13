package nc.onlinelibrary.mvc.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Gusev on 12.12.2015.
 */
@Entity
public class Author {
    private int authorId;
    private String authorInfo;
    private String authorName;
    private List<Book> bookList;

    @Id
    @Column(name = "author_id")
    @GeneratedValue
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Basic
    @Column(name = "author_info")
    public String getAuthorInfo() {
        return authorInfo;
    }

    public void setAuthorInfo(String authorInfo) {
        this.authorInfo = authorInfo;
    }

    @Basic
    @Column(name = "author_name")
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (authorId != author.authorId) return false;
        if (authorInfo != null ? !authorInfo.equals(author.authorInfo) : author.authorInfo != null) return false;
        if (authorName != null ? !authorName.equals(author.authorName) : author.authorName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = authorId;
        result = 31 * result + (authorInfo != null ? authorInfo.hashCode() : 0);
        result = 31 * result + (authorName != null ? authorName.hashCode() : 0);
        return result;
    }
}
