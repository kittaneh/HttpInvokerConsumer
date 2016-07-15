package rnd.grails3.httpinvoker.consumer

import grails.validation.Validateable


/**
* <h1>Book Command</h1>
* Is a representation (with validation) for the Book Domain Class
* This object will be used in the controllers and services
* arguments to replace the params and to validate
* @author  yahya
* @version 1.0
*/

class BookCommand implements Validateable {

    Long id
    String title
    String ISBN
    String createdBy

    Boolean hardCover
    Long pagesNumber
    Float weight

    Date dateCreated
    Date lastUpdated

    Category category
    PublisherCommand publisher
    AuthorCommand author

    static constraints = {
        id(nullable:true)
        title(nullable: false)
        ISBN(nullable: false)
        author(nullable: false)
        publisher(nullable: false)
        category(nullable: false)
        dateCreated(nullable: true)
        lastUpdated(nullable: true)
        weight(nullable: true)
        pagesNumber(nullable: true)
        hardCover(nullable: true)
        createdBy(nullable: true)
    }


    enum Category {
        IT,
        ECONOMICS,
        NOVEL
    }

}
