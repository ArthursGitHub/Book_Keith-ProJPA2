package edu.javacourse.hibernate;

import org.agoncal.book.javaee7.chapter04.BlogEntry;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

// https://www.cpume.com/question/tghisgne-glassfish4-1-hibernate-persistence-xml-exception.html


@WebServlet(name = "TestHibernateJTA", urlPatterns = {"/jta"})
public class TestJTA extends HttpServlet {

  @PersistenceContext(unitName = "myPU")
  EntityManager em;

  @Resource
  UserTransaction ut;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    BlogEntry be = new BlogEntry();
    be.setContent("some content");

    try {
      ut.begin();
      em.persist(be);
      ut.commit();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    System.out.println("1-------------------");
    List<BlogEntry> books = em.createNamedQuery("findMyBooks", BlogEntry.class).getResultList();
    System.out.println("2-------------------");
    for (BlogEntry book : books) {
      System.out.println(book.getContent());
    }
    System.out.println("3-------------------");


    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    try {
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet SearchFacadeClient</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Done without exceptions! Yarrrr!</h1>");
      out.println("<br/><a href='/'>Back</h1>");
      out.println("</body>");
      out.println("</html>");
    } finally {
      out.close();
    }
  }
}