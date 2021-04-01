package com.lwc.controller;

import com.lwc.pojo.Books;
import com.lwc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //controller层调Service层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    //查询全部书籍并返回到一个书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        System.out.println(list);
        return "allBook";
    }

    /*跳转到书记增加页面*/
    @RequestMapping("/toAddBook")
    public String toAddPaper() {
        return "addBook";
    }

    /* 添加书籍的请求*/
    @RequestMapping("/addBook")
    public String addPaper(Books books) {
        System.out.println(books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }

    /**/
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model,int id) {
        Books books = bookService.queryBookById(id);
        System.out.println(books);
        model.addAttribute("Qbook",books );
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Model model, Books book) {
        System.out.println(book);
        bookService.updateBook(book);
        return "redirect:/book/allBook";
    }
    @RequestMapping("/deleteBook")
    public String deleteBook(int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
        Books books = bookService.queryBookByName(queryBookName);
        System.out.println("books=>"+books);
        List<Books> list = new ArrayList<>();
        list.add(books);
        if (books==null){
            list = bookService.queryAllBook();
            model.addAttribute("error","未查到");
        }
        System.out.println("list=>"+list);
        model.addAttribute("list",list);
        return "allBook";
    }
}
