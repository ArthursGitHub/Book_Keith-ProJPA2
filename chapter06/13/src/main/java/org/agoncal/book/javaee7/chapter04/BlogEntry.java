package org.agoncal.book.javaee7.chapter04;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by arthur on 2/13/18.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "findMyBooks", query = "SELECT b FROM BlogEntry b"),
})
@Table
public class BlogEntry implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue
  private Long id;

  @Column
  private String content;

  public void setContent(String content) {
    this.content = content;
  }
  public String getContent() {
    return content;
  }

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  //    <... setters and getters ...>
}