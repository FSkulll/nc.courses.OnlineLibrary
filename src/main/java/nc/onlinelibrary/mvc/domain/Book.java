package nc.onlinelibrary.mvc.domain;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import javax.imageio.ImageIO;
import javax.persistence.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;

@Entity
@Table(name = "book")
public class Book{

    @Id
    @Column(name = "book_id")
    @GeneratedValue
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "isbn")
    private Integer isbn;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "available")
    private boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "username")
    private User owner;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "issue",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "username")})
    private List<User> read;

    @Column(name = "cover")
    private byte[] cover;

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<User> getRead() {
        return read;
    }

    public void setRead(List<User> read) {
        this.read = read;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

//    public BufferedImage getCover() {
//        InputStream in = new ByteArrayInputStream(cover);
//        try {
//            return ImageIO.read(in);
//        } catch (IOException e) {
//            System.out.println("Exc was created in Book domain (getCover)");
//        }
//    }
//
//    public void setCover(BufferedImage cover) {
//        BufferedOutputStream out = new BufferedOutputStream(new ByteArrayOutputStream());
//        try {
//            ImageIO.write(cover, "PNG", out );
//        } catch (IOException e) {
//            System.out.println("Exc was created in Book domain (getCover)");
//        }
//        this.cover = out.toByteArray();
//    }

    public byte[] getCover() {
        return cover;
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
    }
}
