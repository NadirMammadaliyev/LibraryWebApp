package az.nadir.library.controller;

import az.nadir.library.dao.*;
import az.nadir.library.dao.impl.*;
import az.nadir.library.model.*;
import az.nadir.library.service.*;
import az.nadir.library.service.impl.*;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ControllerServlet", value = "/cs")
public class ControllerServlet extends HttpServlet {


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        UserDao userDao = new UserDaoImpl();
        UserService userService = new UserServiceImpl(userDao);

        AuthorDao authorDao = new AuthorDaoImpl();
        AuthorService authorService = new AuthorServiceImpl(authorDao);

        BookDao bookDao = new BookDaoImpl();
        BookService bookService = new BookServiceImpl(bookDao);

        BookInfoDao bookInfoDao = new BookInfoDaoImpl();
        BookInfoService bookInfoService = new BookInfoServiceImpl(bookInfoDao);

        GiveBookDao giveBookDao = new GiveBookDaoImpl();
        GiveBookService giveBookService = new GiveBookServiceImpl(giveBookDao);

        LanguageDao languageDao = new LanguageDaoImpl();
        LanguageService languageService = new LanguageServiceImpl(languageDao);

        TopicDao topicDao = new TopicDaoImpl();
        TopicService topicService = new TopicServiceImpl(topicDao);

        EmployeeDao employeeDao = new EmployeeDaoImpl();
        EmployeeService employeeService = new EmployeeServiceImpl(employeeDao);

        ShelfDao shelfDao = new ShelfDaoImpl();
        ShelfService shelfService = new ShelfServiceImpl(shelfDao);

        PositionDao positionDao = new PositionDaoImpl();
        PositionService positionService = new PositionServiceImpl(positionDao);

        ReadingRoomDao readingRoomDao = new ReadingRoomDaoImpl();
        ReadingRoomService readingRoomService = new ReadingRoomServiceImpl(readingRoomDao);


        String action = null;
        String address = null;
        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
        }
        try {
            if (action.equalsIgnoreCase("getUserList")) {
                List<User> userList = userService.getUserList();
                request.setAttribute("userList", userList);
                address = "WEB-INF/pages/userList.jsp";
            } else if (action.equalsIgnoreCase("getAuthorList")) {
                List<Author> authorList = authorService.getAuthorList();
                request.setAttribute("authorList", authorList);
                address = "WEB-INF/pages/authorList.jsp";
            } else if (action.equalsIgnoreCase("getBookList")) {
                List<Book> bookList = bookService.getBookList();
                request.setAttribute("bookList", bookList);
                address = "WEB-INF/pages/bookList.jsp";
            } else if (action.equalsIgnoreCase("getBookInfoList")) {
                List<BookInfo> bookInfoList = bookInfoService.getBookInfoList();
                request.setAttribute("bookInfoList", bookInfoList);
                address = "WEB-INF/pages/bookInfoList.jsp";
            } else if (action.equalsIgnoreCase("getGiveBookList")) {
                List<GiveBook> giveBookList = giveBookService.getGiveBookList();
                request.setAttribute("giveBookList", giveBookList);
                address = "WEB-INF/pages/giveBookList.jsp";
            } else if (action.equalsIgnoreCase("getStatisticsList")) {
                List<User> userStatistList = userService.getUserStatistList();
                request.setAttribute("userStatistList", userStatistList);
                address = "WEB-INF/pages/statisticsList.jsp";
            } else if (action.equalsIgnoreCase("getProblemUserList")) {
                List<User> userList = userService.getProblemicUsers();
                request.setAttribute("userList", userList);
                address = "WEB-INF/pages/problemUserList.jsp";
            } else if (action.equalsIgnoreCase("getLanguageList")) {
                List<Language> languageList = languageService.getLanguageList();
                request.setAttribute("languageList", languageList);
                address = "WEB-INF/pages/languageList.jsp";
            } else if (action.equalsIgnoreCase("getTopicList")) {
                List<Topic> topicList = topicService.getTopicList();
                request.setAttribute("topicList", topicList);
                address = "WEB-INF/pages/topicList.jsp";
            } else if (action.equalsIgnoreCase("getEmployeeList")) {
                List<Employee> employeeList = employeeService.getEmployeeList();
                request.setAttribute("employeeList", employeeList);
                address = "WEB-INF/pages/employeeList.jsp";
            } else if (action.equalsIgnoreCase("addUser")) {
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String dob = request.getParameter("dob");
                String phone = request.getParameter("phone");
                String mail = request.getParameter("mail");
                String identityNumber = request.getParameter("identityNumber");
                User user = new User();
                user.setName(name);
                user.setSurname(surname);
                user.setPhone(phone);
                user.setMail(mail);
                user.setIdentityNumber(identityNumber);
                user.setDob(df.parse(dob));
                userService.addUser(user);
                out.write("success");
            } else if (action.equalsIgnoreCase("newBook")) {
                List<Language> languageList = languageService.getLanguageList();
                List<Shelf> shelfList = shelfService.getShelfList();
                request.setAttribute("languageList", languageList);
                request.setAttribute("shelfList", shelfList);
                address = "views/newBook.jsp";
            } else if (action.equalsIgnoreCase("addBook")) {
                String name = request.getParameter("name");
                Long languageId = Long.parseLong(request.getParameter("languageId"));
                Long shelfId = Long.parseLong(request.getParameter("shelfId"));
                Integer page = Integer.parseInt(request.getParameter("page"));
                Double price = Double.parseDouble(request.getParameter("price"));
                String dateOfPublication = request.getParameter("dateOfPublication");
                Integer numberOfBook = Integer.parseInt(request.getParameter("numberOfBook"));
                Book book = new Book();
                BookInfo bookInfo = new BookInfo();
                Language language = new Language();
                language.setId(languageId);
                Shelf shelf = new Shelf();
                shelf.setId(shelfId);
                book.setName(name);
                book.setPage(page);
                book.setPrice(price);
                book.setDateOfPublication(dateOfPublication);
                book.setNumberOfBook(numberOfBook);
                book.setLanguage(language);
                book.setShelf(shelf);
                bookInfo.setBook(book);
                bookService.addBook(bookInfo);
            } else if (action.equalsIgnoreCase("addAuthor")) {
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                Author author = new Author();
                author.setName(name);
                author.setSurname(surname);
                authorService.addAuthor(author);
                out.write("success");
            } else if (action.equalsIgnoreCase("addTopic")) {
                String name = request.getParameter("name");
                Topic topic = new Topic();
                topic.setName(name);
                topicService.addTopic(topic);
                out.write("success");
            } else if (action.equalsIgnoreCase("addLanguage")) {
                String name = request.getParameter("name");
                Language language = new Language();
                language.setName(name);
                languageService.addLanguage(language);
                out.write("success");
            } else if (action.equalsIgnoreCase("newEmployee")) {
                List<Position> positionList = positionService.getPositionList();
                request.setAttribute("positionList", positionList);
                address = "views/newEmployee.jsp";
            } else if (action.equalsIgnoreCase("addEmployee")) {
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                Long positionId = Long.parseLong(request.getParameter("positionId"));
                Position position = new Position();
                position.setId(positionId);
                Employee employee = new Employee();
                employee.setName(name);
                employee.setSurname(surname);
                employee.setPosition(position);
                employeeService.addEmployee(employee);
                out.write("success");
            } else if (action.equalsIgnoreCase("addProblemUser")) {
                Long userId = Long.parseLong(request.getParameter("userId"));
                User user = new User();
                user.setId(userId);
                userService.updateUserAddProblemicUser(user);
                out.write("success");
            } else if (action.equalsIgnoreCase("addReturnBook")) {
                Long returnBookId = Long.parseLong(request.getParameter("returnBookId"));
                Book book = new Book();
                book.setId(returnBookId);
                Integer numOfBooks = bookService.getNumberOfBook(returnBookId);
                bookService.updateNumberOfBookPlus(book, numOfBooks);
                out.write("success");
            } else if (action.equalsIgnoreCase("editUser")) {
                Long userId = Long.parseLong(request.getParameter("userId"));
                User user = userService.getUserById(userId);
                request.setAttribute("user", user);
                address = "views/editUser.jsp";
            } else if (action.equalsIgnoreCase("updateUser")) {
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String dob = request.getParameter("dob");
                String phone = request.getParameter("phone");
                String mail = request.getParameter("mail");
                String identityNumber = request.getParameter("identityNumber");
                Integer userActivity = Integer.parseInt(request.getParameter("userActivity"));
                Long userId = Long.parseLong(request.getParameter("userId"));
                User user = new User();
                user.setId(userId);
                user.setName(name);
                user.setSurname(surname);
                user.setPhone(phone);
                user.setMail(mail);
                user.setIdentityNumber(identityNumber);
                user.setDob(df.parse(dob));
                user.setUserActivity(userActivity);
                userService.updateUser(user);
                out.write("success");
            } else if (action.equalsIgnoreCase("deleteUser")) {
                Long userId = Long.parseLong(request.getParameter("userId"));
                userService.deleteUser(userId);
                out.write("success");
            } else if (action.equalsIgnoreCase("editAuthor")) {
                Long authorId = Long.parseLong(request.getParameter("authorId"));
                Author author = authorService.getAuthorById(authorId);
                request.setAttribute("author", author);
                address = "views/editAuthor.jsp";
            } else if (action.equalsIgnoreCase("updateAuthor")) {
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                Long authorId = Long.parseLong(request.getParameter("authorId"));
                Author author = new Author();
                author.setId(authorId);
                author.setName(name);
                author.setSurname(surname);
                authorService.updateAuthor(author);
                out.write("success");
            } else if (action.equalsIgnoreCase("deleteAuthor")) {
                Long authorId = Long.parseLong(request.getParameter("authorId"));
                authorService.deleteAuthor(authorId);
                out.write("success");
            } else if (action.equalsIgnoreCase("editBook")) {
                Long bookId = Long.parseLong(request.getParameter("bookId"));
                Book book = bookService.getBookById(bookId);
                List<Language> languageList = languageService.getLanguageList();
                List<Shelf> shelfList = shelfService.getShelfList();
                request.setAttribute("book", book);
                request.setAttribute("languageList", languageList);
                request.setAttribute("shelfList", shelfList);
                address = "views/editBook.jsp";
            } else if (action.equalsIgnoreCase("updateBook")) {
                String name = request.getParameter("name");
                Long languageId = Long.parseLong(request.getParameter("languageId"));
                Long shelfId = Long.parseLong(request.getParameter("shelfId"));
                Integer page = Integer.parseInt(request.getParameter("page"));
                Double price = Double.parseDouble(request.getParameter("price"));
                String dateOfPublication = request.getParameter("dateOfPublication");
                Integer numberOfBook = Integer.parseInt(request.getParameter("numberOfBook"));
                Long bookId = Long.parseLong(request.getParameter("bookId"));
                Book book = new Book();
                Language language = new Language();
                language.setId(languageId);
                Shelf shelf = new Shelf();
                shelf.setId(shelfId);
                book.setId(bookId);
                book.setName(name);
                book.setPage(page);
                book.setPrice(price);
                book.setDateOfPublication(dateOfPublication);
                book.setNumberOfBook(numberOfBook);
                book.setLanguage(language);
                book.setShelf(shelf);
                bookService.updateBook(book);
                out.write("success");
            } else if (action.equalsIgnoreCase("deleteBook")) {
                Long bookId = Long.parseLong(request.getParameter("bookId"));
                bookService.deleteBook(bookId);
                out.write("success");
            } else if (action.equalsIgnoreCase("deleteProblemUser")) {
                Long userId = Long.parseLong(request.getParameter("userId"));
                userService.updateUserDeleteProblemicUser(userId);
                out.write("success");
            } else if (action.equalsIgnoreCase("editLanguage")) {
                Long languageId = Long.parseLong(request.getParameter("languageId"));
                Language language = languageService.getLanguageById(languageId);
                request.setAttribute("language", language);
                address = "views/editLanguage.jsp";
            } else if (action.equalsIgnoreCase("updateLanguage")) {
                String name = request.getParameter("name");
                Long languageId = Long.parseLong(request.getParameter("languageId"));
                Language language = new Language();
                language.setId(languageId);
                language.setName(name);
                languageService.updateLanguage(language);
                out.write("success");
            } else if (action.equalsIgnoreCase("deleteLanguage")) {
                Long languageId = Long.parseLong(request.getParameter("languageId"));
                languageService.deleteLanguage(languageId);
                out.write("success");
            } else if (action.equalsIgnoreCase("editTopic")) {
                Long topicId = Long.parseLong(request.getParameter("topicId"));
                Topic topic = topicService.getTopicById(topicId);
                request.setAttribute("topic", topic);
                address = "views/editTopic.jsp";
            } else if (action.equalsIgnoreCase("updateTopic")) {
                String name = request.getParameter("name");
                Long topicId = Long.parseLong(request.getParameter("topicId"));
                Topic topic = new Topic();
                topic.setId(topicId);
                topic.setName(name);
                topicService.updateTopic(topic);
                out.write("success");
            } else if (action.equalsIgnoreCase("deleteTopic")) {
                Long topicId = Long.parseLong(request.getParameter("topicId"));
                topicService.deleteTopic(topicId);
                out.write("success");
            } else if (action.equalsIgnoreCase("editEmployee")) {
                Long employeeId = Long.parseLong(request.getParameter("employeeId"));
                Employee employee = employeeService.getEmployeeById(employeeId);
                List<Position> positionList = positionService.getPositionList();
                request.setAttribute("employee", employee);
                request.setAttribute("positionList", positionList);
                address = "views/editEmployee.jsp";
            } else if (action.equalsIgnoreCase("updateEmployee")) {
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                Long employeeId = Long.parseLong(request.getParameter("employeeId"));
                Long positionId = Long.parseLong(request.getParameter("positionId"));
                Position position = new Position();
                position.setId(positionId);
                Employee employee = new Employee();
                employee.setId(employeeId);
                employee.setName(name);
                employee.setSurname(surname);
                employee.setPosition(position);
                employeeService.updateEmployee(employee);
                out.write("success");
            } else if (action.equalsIgnoreCase("deleteEmployee")) {
                Long employeeId = Long.parseLong(request.getParameter("employeeId"));
                employeeService.deleteEmployee(employeeId);
                out.write("success");
            } else if (action.equalsIgnoreCase("infoBook")) {
                Long bookId = Long.parseLong(request.getParameter("bookId"));
                Book book = bookService.getBookById(bookId);
                List<BookInfo> bookInfoList = bookInfoService.getBookInfoByBookId(book.getId());
                request.setAttribute("bookInfoList", bookInfoList);
                address = "WEB-INF/pages/bookInfoList.jsp";
            } else if (action.equalsIgnoreCase("newBookInfo")) {
                List<BookInfo> bookInfoList = bookInfoService.getBookInfoList();
                List<Author> authorList = authorService.getAuthorList();
                List<Topic> topicList = topicService.getTopicList();
                List<Book> bookList = bookService.getBookList();

                request.setAttribute("bookInfoList", bookInfoList);
                request.setAttribute("authorList", authorList);
                request.setAttribute("topicList", topicList);
                request.setAttribute("bookList", bookList);
                address = "views/newBookInfo.jsp";
            } else if (action.equalsIgnoreCase("addBookInfo")) {
                Long bookId = Long.parseLong(request.getParameter("bookId"));
                Long authorId = Long.parseLong(request.getParameter("authorId"));
                Long topicId = Long.parseLong(request.getParameter("topicId"));
                BookInfo bookInfo = new BookInfo();
                Book book = new Book();
                Author author = new Author();
                Topic topic = new Topic();
                book.setId(bookId);
                author.setId(authorId);
                topic.setId(topicId);
                bookInfo.setBook(book);
                bookInfo.setAuthor(author);
                bookInfo.setTopic(topic);
                bookInfoService.addBookInfo(bookInfo);
                out.write("success");
            } else if (action.equalsIgnoreCase("editBookInfo")) {
                Long bookInfoId = Long.parseLong(request.getParameter("bookInfoId"));
                BookInfo bookInfo = bookInfoService.getBookInfoById(bookInfoId);
                List<Author> authorList = authorService.getAuthorList();
                List<Topic> topicList = topicService.getTopicList();
                List<Book> bookList = bookService.getBookList();
                request.setAttribute("bookInfo", bookInfo);
                request.setAttribute("authorList", authorList);
                request.setAttribute("topicList", topicList);
                request.setAttribute("bookList", bookList);
                address = "views/editBookInfo.jsp";
            } else if (action.equalsIgnoreCase("updateBookInfo")) {
                Long bookId = Long.parseLong(request.getParameter("bookId"));
                Long authorId = Long.parseLong(request.getParameter("authorId"));
                Long topicId = Long.parseLong(request.getParameter("topicId"));
                Long bookInfoId = Long.parseLong(request.getParameter("bookInfoId"));
                BookInfo bookInfo = new BookInfo();
                bookInfo.setId(bookInfoId);
                Book book = new Book();
                Author author = new Author();
                Topic topic = new Topic();
                book.setId(bookId);
                author.setId(authorId);
                topic.setId(topicId);
                bookInfo.setBook(book);
                bookInfo.setAuthor(author);
                bookInfo.setTopic(topic);
                //     bookInfoService.updateBookInfo(bookInfo);    Method dao.impl classinda yazilmalidir
                out.write("success");
            } else if (action.equalsIgnoreCase("deleteBookInfo")) {
                Long bookInfoId = Long.parseLong(request.getParameter("bookInfoId"));
                bookInfoService.deleteBookInfo(bookInfoId);
                out.write("success");
            } else if (action.equalsIgnoreCase("newGiveBook")) {
                List<Book> bookList = bookService.getBookList();
                List<User> userList = userService.getUserList();
                List<Employee> employeeList = employeeService.getEmployeeList();
                List<ReadingRoom> readingRoomList = readingRoomService.getReadingRoomList();

                request.setAttribute("bookList", bookList);
                request.setAttribute("userList", userList);
                request.setAttribute("employeeList", employeeList);
                request.setAttribute("readingRoomList", readingRoomList);
                address = "views/newGiveBook.jsp";
            } else if (action.equalsIgnoreCase("addGiveBook")) {
                Long bookId = Long.parseLong(request.getParameter("bookId"));
                Long userId = Long.parseLong(request.getParameter("userId"));
                Long employeeId = Long.parseLong(request.getParameter("employee"));
                Long readingRoomId = Long.parseLong(request.getParameter("readingRoom"));
                String returnDate = request.getParameter("returnDate");
                GiveBook giveBook = new GiveBook();
                Book book = new Book();
                User user = new User();
                Employee employee = new Employee();
                ReadingRoom readingRoom = new ReadingRoom();
                book.setId(bookId);
                user.setId(userId);
                employee.setId(employeeId);
                readingRoom.setId(readingRoomId);
                giveBook.setBook(book);
                giveBook.setUser(user);
                giveBook.setEmployee(employee);
                giveBook.setReadingRoom(readingRoom);
                giveBook.setReturnDate(df.parse(returnDate));
                giveBookService.addGiveBook(giveBook);
                out.write("success");
            } else if (action.equalsIgnoreCase("editGiveBook")) {
                List<Book> bookList = bookService.getBookList();
                List<User> userList = userService.getUserList();
                List<Employee> employeeList = employeeService.getEmployeeList();
                List<ReadingRoom> readingRoomList = readingRoomService.getReadingRoomList();
                Long giveBookId = Long.parseLong(request.getParameter("giveId"));
                GiveBook giveBook = giveBookService.getGiveBookById(giveBookId);

                request.setAttribute("bookList", bookList);
                request.setAttribute("userList", userList);
                request.setAttribute("employeeList", employeeList);
                request.setAttribute("readingRoomList", readingRoomList);
                request.setAttribute("giveBook", giveBook);
                address = "views/editGiveBook.jsp";
            } else if (action.equalsIgnoreCase("updateGiveBook")) {
                Long bookId = Long.parseLong(request.getParameter("bookId"));
                Long userId = Long.parseLong(request.getParameter("userId"));
                Long employeeId = Long.parseLong(request.getParameter("employee"));
                Long readingRoomId = Long.parseLong(request.getParameter("readingRoom"));
                String returnDate = request.getParameter("returnDate");
                Long giveBookId = Long.parseLong(request.getParameter("giveId"));
                GiveBook giveBook = new GiveBook();
                giveBook.setId(giveBookId);
                Book book = new Book();
                User user = new User();
                Employee employee = new Employee();
                ReadingRoom readingRoom = new ReadingRoom();
                book.setId(bookId);
                user.setId(userId);
                employee.setId(employeeId);
                readingRoom.setId(readingRoomId);
                giveBook.setBook(book);
                giveBook.setUser(user);
                giveBook.setEmployee(employee);
                giveBook.setReadingRoom(readingRoom);
                giveBook.setReturnDate(df.parse(returnDate));
                giveBookService.updateGiveBook(giveBook);
                Integer numOfBooks = bookService.getNumberOfBook(bookId);
                bookService.updateNumberOfBookMinus(book, numOfBooks);
                out.write("success");
            } else if (action.equalsIgnoreCase("deleteGiveBook")) {
                Long giveId = Long.parseLong(request.getParameter("giveId"));
                giveBookService.deleteGiveBook(giveId);
                out.write("success");
            }

            if (address != null && !address.isEmpty()) {
                RequestDispatcher dispatcher = request.getRequestDispatcher(address);
                dispatcher.forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}