package rnd.grails3.httpinvoker.producer.dto;

import org.grails.plugins.dto.DTO;

import java.util.Set;

/**
 * <h1>Author DTO</h1>
 * Author Data Transfer Object
 * @author  yahya
 * @version 1.0
 */
public class AuthorDTO implements DTO {

    private String id;
    private String name;
    private Set<BookDTO> books;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(Set<BookDTO> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AuthorDTO[");
        sb.append("\n\tid: " + this.id);
        sb.append("\n\tname: " + this.name);
        sb.append("\n\tbooks: " + this.books);
        sb.append("]");
        return sb.toString();
    }
}
