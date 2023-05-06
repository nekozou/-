package kcsj.dao;
import kcsj.SearchCriteria;
import kcsj.domain.mas_book;

import java.util.List;
public interface mas_bookDAO {
    void addmas_book(mas_book new_mas_book, String no, String pwd);
    void updatemas_book(mas_book mas_book_update, String no, String pwd,int i);
    void deletemas_book(String book_no, String no, String pwd);
    mas_book getmas_book(String book_no, String no, String pwd);
    List<mas_book> findmas_book(SearchCriteria searchCriteria);
}
