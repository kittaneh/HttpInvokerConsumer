package rnd.grails3.httpinvoker.producer.dto;

import org.grails.plugins.dto.DTO;

import java.util.Date;

/**
 * <h1>Book DTO</h1>
 * Book Data Transfer Object
 * @author  yahya
 * @version 1.0
 */
public class BookDTO implements DTO {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private String ISBN;
    private String createdBy;

    private Boolean hardCover;
    private Long pagesNumber;
    private Float weight;

    private Date dateCreated;
    private Date lastUpdated;

    AuthorDTO author;
    PublisherDTO publisher;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Boolean getHardCover() {
        return hardCover;
    }

    public void setHardCover(Boolean hardCover) {
        this.hardCover = hardCover;
    }

    public Long getPagesNumber() {
        return pagesNumber;
    }

    public void setPagesNumber(Long pagesNumber) {
        this.pagesNumber = pagesNumber;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BookDTO[");
        sb.append("\n\tid: " + this.id);
        sb.append("\n\ttitle: " + this.title);
        sb.append("\n\tISBN: " + this.ISBN);
        sb.append("\n\tcreatedBy: " + this.createdBy);
        sb.append("\n\thardCover: " + this.hardCover);
        sb.append("\n\tpagesNumber: " + this.pagesNumber);
        sb.append("\n\tweight: " + this.weight);
        sb.append("\n\tdateCreated: " + this.dateCreated);
        sb.append("\n\tlastUpdated: " + this.lastUpdated);
        sb.append("\n\tauthor: " + this.author);
        sb.append("\n\tpublisher: " + this.publisher);
        sb.append("]");
        return sb.toString();
    }
}
