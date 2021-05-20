import com.baeldung.hexagonalarchitecture.core.Book;
import com.baeldung.hexagonalarchitecture.core.BookStore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BookTests {

    @Test
    public void newBookTest(){
        Book book = new Book();
        book.setTitle("Le Petit Prince");
        assertEquals(book.getTitle(),new String("Le Petit Prince"));
    }

    @Test
    public void newBookListStoresTest(){
        Book book = new Book();
        book.setTitle("Le Petit Prince");
        BookStore bookStore = new BookStore();
        List<BookStore> listBookStores=new ArrayList<>();
        listBookStores.add(bookStore);
        book.setBookStores(listBookStores);
        assertEquals(book.getBookStores().size(),1);
    }

}
