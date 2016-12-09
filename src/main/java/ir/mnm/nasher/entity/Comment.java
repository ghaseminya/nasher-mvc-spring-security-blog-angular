package ir.mnm.nasher.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by mghasemy on 12/10/16.
 */
@javax.persistence.Entity
public class Comment implements Entity {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String text;

    @Column
    private Long blogid;


    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
