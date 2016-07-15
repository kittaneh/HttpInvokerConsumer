package rnd.grails3.httpinvoker.consumer

import grails.validation.Validateable

/**
 * <h1>Country Command</h1>
 * Is a representation (with validation) for the Country Domain Class
 * This object will be used in the controllers and services
 * arguments to replace the params and to validate
 * @author  yahya
 * @version 1.0
 */

class CountryCommand implements Validateable {

    Long id
    String code
    String name

    static constraints = {
        id(nullable:true)
        code(nullable:false)
        name(nullable:false)
    }

}
