package mate.academy;

import java.math.BigDecimal;
import mate.academy.dao.BookDao;
import mate.academy.lib.Injector;
import mate.academy.model.Book;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.academy");

    public static void main(String[] args) {
        BookDao bookDao = (BookDao) injector.getInstance(BookDao.class);
        Book book = new Book();
        book.setTitle("Java Programming");
        book.setPrice(new BigDecimal(200));

        bookDao.create(book);
        bookDao.findAll().forEach(System.out::println);
        System.out.println();
        System.out.println("Id 1 " + System.lineSeparator() + bookDao.findById(1L));
        bookDao.deleteById(2L);
        bookDao.findAll().forEach(System.out::println);
        System.out.println();
        bookDao.update(book);
        bookDao.findAll().forEach(System.out::println);
    }
}
