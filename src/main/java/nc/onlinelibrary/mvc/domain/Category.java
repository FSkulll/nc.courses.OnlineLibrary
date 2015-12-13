package nc.onlinelibrary.mvc.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Gusev on 12.12.2015.
 */
@Entity
public class Category {
    private int categoryId;
    private String categoryDescription;
    private String categoryName;
    private List<Book> bookList;

    @Id
    @Column(name = "category_id")
    @GeneratedValue
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "category_description")
    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    @Basic
    @Column(name = "category_name")
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
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

        Category category = (Category) o;

        if (categoryId != category.categoryId) return false;
        if (categoryDescription != null ? !categoryDescription.equals(category.categoryDescription) : category.categoryDescription != null)
            return false;
        if (categoryName != null ? !categoryName.equals(category.categoryName) : category.categoryName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoryId;
        result = 31 * result + (categoryDescription != null ? categoryDescription.hashCode() : 0);
        result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
        return result;
    }
}
