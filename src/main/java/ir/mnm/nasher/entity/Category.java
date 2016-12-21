package ir.mnm.nasher.entity;

import ir.mnm.nasher.JsonViews;
import org.codehaus.jackson.map.annotate.JsonView;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by mghasemy on 12/9/16.
 */
@javax.persistence.Entity
public class Category implements Entity {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    public String name;

    @Column
    public int parent;

    @JsonView(JsonViews.User.class)
    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public Category() {
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    @JsonView(JsonViews.User.class)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonView(JsonViews.Admin.class)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
