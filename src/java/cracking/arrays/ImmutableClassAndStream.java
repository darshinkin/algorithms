package cracking.arrays;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ImmutableClassAndStream {

    public static void main(String[] args) {

        List<Author> hpAuthors = new ArrayList<>();
        hpAuthors.add(new Author("Joanne", "Rowling"));
        Book hp = new Book("Harry Potter", hpAuthors);
        List<Author> hpA = hp.getAuthors();
        hpA.add(new Author("1", "2"));

        List<Author> tsAuthors = new ArrayList<>();
        tsAuthors.add(new Author("Mark", "Twain"));
        tsAuthors.add(new Author("Joanne", "Twain"));
        tsAuthors.add(new Author("Anton", "Twain"));
        Book ts = new Book("The Adventures of Tom Sawyer", tsAuthors);

        Author jv = new Author("Jules", "Verne");

        List<Book> books = List.of(hp, ts);

        // List the book titles
        System.out.println(books.stream()
                .map(book -> book.title)
                .collect(Collectors.toList()));

        //        System.out.println(books.stream().map(x -> x.getTitle()).collect(toList()));

        // List<a, List<b>> -> List<a, b>
//        System.out.println(books.stream()
//                .flatMap(book -> book.getAuthors().stream())
//                .map(author -> author.firstName)
//                .sorted((n1, n2) -> Comparator.comparing(n1.compareTo(n2), Comparator.reverseOrder()))
//                .distinct()
//                .collect(Collectors.toList()));

        //        System.out.println(books.stream().flatMap(Collections::Stream).collect());

    }

    static class Book {
        private final String title;
        private final List<Author> authors;

        public Book(String title, List<Author> authors) {
            this.title = title;
            this.authors = new ArrayList<>();

            for (Author a : authors) {
                this.authors.add(a);
            }

        }

        public List<Author> getAuthors() {
            //            List<Author> returnList = new ArrayList();
            return new ArrayList<>(authors);
        }
    }

    static class Author {
        private final String firstName;
        private final String lastName;

        public Author(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        private String getFirstName() {
            return firstName;
        }

        private String getLastName() {
            return lastName;
        }
    }
}
