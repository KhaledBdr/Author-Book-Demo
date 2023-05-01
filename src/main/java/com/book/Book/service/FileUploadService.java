package com.book.Book.service;

import com.book.Book.entity.Author;
import com.book.Book.entity.Book;
import com.book.Book.exception.FileException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileUploadService {

    final private AuthorService authorService;
    final private BookService bookService;
    final private MessageSource messageSource;
    @Value("${img_path}")
    String dest = "";
    public FileUploadService(AuthorService authorService, BookService bookService, MessageSource messageSource) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.messageSource = messageSource;
    }

    public String uploadFile(String pathType, Long id
            , MultipartFile multipartFile) {
       if(! multipartFile.getContentType().contains("image")){
           String notImage = messageSource.getMessage("BadFile",null, LocaleContextHolder.getLocale());
           throw new FileException(notImage);
       }

        File file = convertMultiPartToFile(multipartFile);
        Path localPath = Paths.get(dest + pathType).toAbsolutePath().normalize();

        try {
            Files.createDirectories(localPath);
        } catch (IOException e) {
            String pathCreationError = messageSource.getMessage("pathCreationError",
                    null,
                    LocaleContextHolder.getLocale());
            throw new FileException(pathCreationError ,  e);
        }

        String fileName = StringUtils.cleanPath(id + "-" + UUID.randomUUID()
                +file.getName().substring(file.getName().lastIndexOf('.')));
        try {
            if (fileName.contains(".."))
                throw new FileException("Can't create path...." + fileName);
            Path targetLocation = localPath.resolve(fileName);
            InputStream inputStream = new FileInputStream(file);
            Files.copy(inputStream, targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return updateImagePath(id ,pathType , fileName);
        } catch (FileNotFoundException e) {
            throw new FileException("File not found ", e);
        } catch (IOException e) {
            throw new FileException(e.getMessage() , e);
        }
    }

    private File convertMultiPartToFile(MultipartFile multipartFile) {
        File file = new File(multipartFile.getOriginalFilename());
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(multipartFile.getBytes());
        } catch (IOException ex) {
            throw new FileException("Error occur while covert multipart to file", ex);
        }
        return file;
    }
    private String updateImagePath(Long id , String pathType , String fileName) {
        if (pathType.contains("author")){
            Author author= authorService.findById(id);
            author.setImage(fileName);
            authorService.update(author);
        }else if (pathType.contains("book")){
            Book book = bookService.findById(id);
            book.setImage(fileName);
            bookService.update(book);
        }
        return pathType+"/" +fileName;
    }
}
