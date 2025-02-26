class Books {
    String title;
    String author;
    int yearPublished;
    double prices;
    boolean available = true;

    Books(String s, String a, int y, double p) {
        title = s;
        author = a;
        yearPublished = y;
        prices = p;
    }

    void SearchBook(String str, String au, int year) {
        if (str == title && au == author && year == yearPublished) {
            System.out.println("Book found");
            available = false;
        } else {
            System.out.println("Book not found");
        }
    }

    void IssueBook(String str, String au, int year) {
        if (available) {
            System.out.println("Book can be issued");
            System.out.println("The book cost " + prices);
        } else {
            System.out.println("Book is not available");
        }
    }
}

class Magazines {
    String title;
    String publication;
    double prices;

    Magazines(String s, String p, double p1) {
        title = s;
        publication = p;
        prices = p1;
    }

}

public class multiple {
    public static void main(String[] args) {

    }
}
