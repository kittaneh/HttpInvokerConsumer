package rnd.grails3.httpinvoker.consumer

import grails.validation.Validateable

/**
* <h1>Author Command Object</h1>
* Is a representation (with validation) for the Author Domain Class
 * This object will be used in the controllers and services
 * arguments to replace the params and to validate
* @author  yahya
* @version 1.0
*/
class AuthorCommand implements Validateable {

    Long id
    String name

    // lazy initialization
    // see http://stackoverflow.com/questions/18382346/command-object-and-hasmany
    List<BookCommand> books = [].withDefault { new BookCommand() }

    static constraints = {
        id(nullable:true)
        name(nullable:false)
    }
}
