package group5.duan.library.Service.book;

import group5.duan.library.Mapper.IBookMapper;
import group5.duan.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BookService implements  IBookService{
    private final BookRepository bookRepo;
    private final IBookMapper bookMapper;

    public BookService(BookRepository bookRepo, IBookMapper bookMapper) {
        this.bookRepo = bookRepo;
        this.bookMapper = bookMapper;
    }

}
