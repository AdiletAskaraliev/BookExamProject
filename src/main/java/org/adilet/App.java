package org.adilet;

import org.adilet.entity.Author;
import org.adilet.entity.Book;
import org.adilet.entity.Publisher;
import org.adilet.entity.Reader;
import org.adilet.enums.Gender;
import org.adilet.enums.Genre;
import org.adilet.service.AuthorService;
import org.adilet.service.BookService;
import org.adilet.service.PublisherService;
import org.adilet.service.ReaderService;
import org.adilet.service.serviceImpl.AuthorServiceImpl;
import org.adilet.service.serviceImpl.BookServiceImpl;
import org.adilet.service.serviceImpl.PublisherServiceImpl;
import org.adilet.service.serviceImpl.ReaderServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        PublisherService publisherService = new PublisherServiceImpl();
        AuthorService authorService = new AuthorServiceImpl();
        BookService bookService = new BookServiceImpl();
        ReaderService readerService = new ReaderServiceImpl();

        while (true) {
            switch (new Scanner(System.in).nextInt()) {
                case 1:
                    System.out.println(publisherService.savePublisher(new Publisher("Bishkek basmakana", "Bishkek")));
                    break;
                case 2:
                    System.out.println(publisherService.getPublisherById(3L));
                    break;
                case 3:
                    System.out.println(publisherService.getAllPublishers("desc"));
                    break;
                case 4:
                    publisherService.updatePublisher(4L, new Publisher("Kant basmakana", "Kant"));
                    break;
                case 5:
                    publisherService.deletePublisherByName("Osh basmakana");
                    break;
                case 6:
                    System.out.println(authorService.saveAuthor(
                            new Author("Uson", "Usonov", "a@mail.kg",
                                    LocalDate.of(1995, 4, 2), "KGZ", Gender.MALE)));
                    break;
                case 7:
                    authorService.updateAuthor(3L, new Author("Asel", "Bekova", "asel@mail.kg",
                            LocalDate.of(1997, 5, 8), "KGZ", Gender.FEMALE));
                    break;
                case 8:
                    System.out.println(authorService.getAuthorById(2L));
                    break;
                case 9:
                    authorService.assignAuthorToPublisher(2L, 3L);
                    break;
                case 10:
                    System.out.println(authorService.getAuthorsByPublisherId(3L));
                    break;
                case 11:
                    Book book = new Book("Ak Keme",
                            LocalDate.of(1980, 5, 8), BigDecimal.valueOf(2500), Genre.DRAMA);
                    bookService.saveBook(book, 1L);
                    break;
                case 12:
                    readerService.saveReader(new Reader("Ivan", "ivan@mail.kg"));
                    break;
            }
        }


    }
}
