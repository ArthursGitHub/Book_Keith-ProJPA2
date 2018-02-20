package edu.javacourse.hibernate;

import org.agoncal.book.javaee7.chapter04.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Create")
public class Create extends HttpServlet
{
  private static final long serialVersionUID = 1L;


  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.getOutputStream().println("CREATE operation completed: " + fun());
  }

  private String fun() {

    // 1-Creates an instance of book
    Book book = new Book("H2G2", "The Hitchhiker's Guide to the Galaxy", 12.5F, "1-84023-742-2", 354, false);

    // 2-Obtains an entity manager and a transaction
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter04PU_HibernateMySQL"); // chapter04PU_MySQL
    EntityManager em = emf.createEntityManager();

    // 3-Persists the book to the database
//    EntityTransaction tx = em.getTransaction();
//    tx.begin();
    em.persist(book);
//    tx.commit();

    // 4-Executes the named query
    List<Book> books = em.createNamedQuery("findAllBooks", Book.class).getResultList();

    System.out.println("######### " + book.getTitle());

    String z = new String();
    for (Book book1 : books) {
      z += book1.getTitle();
    }
    // 5-Closes the entity manager and the factory
    em.close();
    emf.close();

    return z;
  }
}
