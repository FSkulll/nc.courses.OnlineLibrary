package nc.onlinelibrary.mvc.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private Integer enabled;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Book> booksListCurrent;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "issue",
            joinColumns = {@JoinColumn(name = "username") },
            inverseJoinColumns = {@JoinColumn(name = "book_id")})
    private List<Book> read;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public List<Book> getBooksListCurrent() {
        return booksListCurrent;
    }

    public void setBooksListCurrent(List<Book> booksListCurrent) {
        this.booksListCurrent = booksListCurrent;
    }

    public List<Book> getRead() {
        return read;
    }

    public void setRead(List<Book> read) {
        this.read = read;
    }


}
