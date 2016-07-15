package rnd.grails3.httpinvoker.consumer

import grails.converters.JSON
import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Shared
import spock.lang.Specification

/**
 * <h1>Global Unit Testing Class</h1>
 * Another way using @testMixin to test
 * any grails artifact (Controller, Service, ot even Taglib)
 * @author  yahya
 * @version 1.0
 */

@TestMixin(GrailsUnitTestMixin)
class TestRemotingSpec extends Specification {

    // global properties to share among all specs
    @Shared proxyFactoryService
    @Shared remotingBookService

    /**
     *  In TEST environment you should manually inject
     *  any spring beans (even grails services)
     */
    def doWithSpring = {
        //proxyFactoryService is a dependency for remotingService
        proxyFactoryService(ProxyFactoryService)
        remotingBookService(RemotingBookService)
    }

    /**
     * putting all shared assignations and initializations to all specs
     */
    def setup() {
         proxyFactoryService = grailsApplication.mainContext.getBean('proxyFactoryService')
         remotingBookService = grailsApplication.mainContext.getBean('remotingBookService')

        /*proxyFactoryService is a dependency for remotingService ,
          so that it should be assigned
         */
        remotingBookService.proxyFactoryService = proxyFactoryService
    }

    def "grailsApplication is not null"() {
        expect:
        grailsApplication != null
    }

    def "doWithSpring callback is executed"() {
        expect:
        grailsApplication.mainContext.getBean('remotingBookService') != null
    }


    def "test read remoting for grails3"() {
        given:
        def jsonBook = JSON.parse(remotingBookService.findBookById(bookId))

        expect:
        jsonBook.title == "title"

        where:
        bookId=3L

    }


}
