package rnd.grails3.httpinvoker.producer.dto;

import org.grails.plugins.dto.DTO;

/**
 * <h1>Publisher DTO</h1>
 * Publisher Data Transfer Object
 * @author  yahya
 * @version 1.0
 */
public class PublisherDTO implements DTO {

    private Long id;
    private String name;
    private CountryDTO country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CountryDTO getCountry() {
        return country;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PublisherDTO[");
        sb.append("\n\tid: " + this.id);
        sb.append("\n\tname: " + this.name);
        sb.append("\n\tcountry: " + this.country);
        sb.append("]");
        return sb.toString();
    }
}
