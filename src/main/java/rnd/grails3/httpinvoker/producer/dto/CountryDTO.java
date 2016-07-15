package rnd.grails3.httpinvoker.producer.dto;

import org.grails.plugins.dto.DTO;

/**
 * <h1>Country DTO</h1>
 * Country Data Transfer Object
 * @author  yahya
 * @version 1.0
 */
public class CountryDTO implements DTO {

    private Long id;
    private String code;
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CountryDTO[");
        sb.append("\n\tid: " + this.id);
        sb.append("\n\tname: " + this.name);
        sb.append("\n\tcode: " + this.code);
        sb.append("]");
        return sb.toString();
    }
}
