package rnd.grails3.httpinvoker.consumer

import grails.validation.Validateable

/**
 * <h1>Publisher Command</h1>
 * Is a representation (with validation) for the Publisher Domain Class
 * This object will be used in the controllers and services
 * arguments to replace the params and to validate
 * @author  yahya
 * @version 1.0
 */
class PublisherCommand implements Validateable {

    Long id
    String name
    CountryCommand country


    static constraints = {
        id(nullable:true)
        name(nullable:false)
        country(nullable:false)
    }

}
