package com.lwc.service;

import com.lwc.dao.BookMapper;
import com.lwc.pojo.Books;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class BookServiceImpl implements BookService{
    /*调用dao层的操作，设置一个set接口，方便Spring管理 */
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    @Override
    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    @Override
    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    @Override
    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    @Override
    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    @Override
    public Books queryBookByName(String bookName) {
        return  bookMapper.queryBookByName(bookName);
    }

}