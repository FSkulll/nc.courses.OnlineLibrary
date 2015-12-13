package nc.onlinelibrary.mvc.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Gusev on 12.12.2015.
 */
@Entity
public class Issue {
    private int issueId;
    private Date dateOfReturn;
    private Date dateOfIssue;
    private Book readBook;
    private Users readUsername;

    @Id
    @Column(name = "issue_id")
    @GeneratedValue
    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    @Basic
    @Column(name = "dateOfReturn")
    public Date getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(Date dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    @Basic
    @Column(name = "dateOfIssue")
    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    @ManyToOne
    @JoinColumn(name = "book_id")
    public Book getReadBook() {
        return readBook;
    }

    public void setReadBook(Book readBook) {
        this.readBook = readBook;
    }

    @ManyToOne
    @JoinColumn(name = "username")
    public Users getReadUsername() {
        return readUsername;
    }

    public void setReadUsername(Users readUsername) {
        this.readUsername = readUsername;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Issue issue = (Issue) o;

        if (issueId != issue.issueId) return false;
        if (readBook != issue.readBook) return false;
        if (dateOfReturn != null ? !dateOfReturn.equals(issue.dateOfReturn) : issue.dateOfReturn != null) return false;
        if (dateOfIssue != null ? !dateOfIssue.equals(issue.dateOfIssue) : issue.dateOfIssue != null) return false;
        if (readUsername != null ? !readUsername.equals(issue.readUsername) : issue.readUsername != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = issueId;
        result = 31 * result + (dateOfReturn != null ? dateOfReturn.hashCode() : 0);
        result = 31 * result + (dateOfIssue != null ? dateOfIssue.hashCode() : 0);
        result = 31 * result + (readUsername != null ? readUsername.hashCode() : 0);
        return result;
    }
}
