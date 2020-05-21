package entities;
//JAVA BEAN
public class Category {
    private long id;
    private String name;
    private long parent_category_id;
    private Category parent;

    public Category(){}

    public Category(long id, String name, long parent_category_id) {
        this.id = id;
        this.name = name;
        this.parent_category_id = parent_category_id;
        //this.parent = parent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getParentCategoryId() {
        return parent_category_id;
    }

    public void setParentCategoryId(long parent_category_id) {
        this.parent_category_id = parent_category_id;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parent_category_id=" + parent_category_id +
                ", parent=" + parent +
                '}';
    }
}
