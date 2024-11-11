import java.util.ArrayList;
import java.util.Scanner;
public class Library {

    private ArrayList<Book> books;
    public boolean quit = false;

    public Library() {
        books = new ArrayList<>();
        books.add(new Book("to kill a mockingbird","harper lee","9780060935467",true));
        books.add(new Book("1984","george orwell","9780451524935",true));
        books.add(new Book(" the great gatsby","f. scott fitzgerald","9780743273565",true));
        service();
    }

    public void service (){
        while(true){
            System.out.println("write 1 to Add or 2 for remove books");
            System.out.println("write 3 to barrow or 4 for return books");
            System.out.println("write 5 to list available books or q to quite");
            Scanner input = new Scanner(System.in);
            String option = "";
            option = input.nextLine();

            switch (option) {
                case "1": {
                    System.out.println("Please write the title");
                    String title = input.nextLine();
                    System.out.println("Please write the author ");
                    String author = input.nextLine();
                    System.out.println("Please write the ISBN ");
                    String ISBN = input.nextLine();
                    books.add(new Book(title, author, ISBN, true));
                    System.out.println("Book added successfully");
                  break;
                }
                case "2": {
                    System.out.println("Please write ISBN number ");
                    String ISBN = input.nextLine();

                    if (ISBN.isEmpty()) {
                        System.out.println("can not found it ");
                        break;
                    }
                    books.removeIf(book -> book.ISBN.equals(ISBN));
                    System.out.println( "the book has been removed ");
                    break;
                }
                case "3":{
                    System.out.println("Please write name of book as its  ");
                    String title = input.nextLine().toLowerCase();
                    System.out.println(title);
                    for (Book book : books) {
                        if ((book.title.equals(title) && book.isAvailable)) {
                            book.isAvailable = false;
                            System.out.println("You have borrowed the book");
                            break;
                        }else{
                            System.out.println("the book is not available");
                            break;
                        }
                    }
                    break;
                }
                case "4":{

                    System.out.println("Please write name of book as its1  ");
                    String title = input.nextLine().toLowerCase();
                    for (Book book : books) {
                        if ((book.title.equals(title) && !book.isAvailable)) {
                            book.isAvailable = true;
                            System.out.println("You have returned the book");
                            break;
                        }
                    }
                    break;

                }
                case "5":{
                    System.out.println("--------LIST--------");

                    for(Book book:books){
                        System.out.println("title : "+ book.title +" - " + "author : "+book.author+ " avalibale : " + book.isAvailable);
                    }
                    System.out.println("---------------------");
                   break;

                }
                case "q":{
                return;}






            }
        }

    }


}
