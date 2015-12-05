package nc.onlinelibrary.mvc.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "issue")
public class Issue {

    @Id
    @Column(name = "issue_id")
    @GeneratedValue
    private Integer id;

    @Column(name = "username")
    private String reader;

    @Column(name = "book_id")
    private Integer book;

    @Column(name = "dateOfIssue")
    private Date dateOfIssue;

    @Column(name = "dateOfReturn")
    private Date dataOfReturn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReader() {
        return reader;
    }

    public void setReader(String reader) {
        this.reader = reader;
    }

    public Integer getBook() {
        return book;
    }

    public void setBook(Integer book) {
        this.book = book;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public Date getDataOfReturn() {
        return dataOfReturn;
    }

    public void setDataOfReturn(Date dataOfReturn) {
        this.dataOfReturn = dataOfReturn;
    }
}
