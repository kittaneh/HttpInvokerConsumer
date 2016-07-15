package rnd.grails3.httpinvoker.consumer

import grails.test.mixin.TestFor
import org.junit.Ignore
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise
import spock.lang.Unroll

/**
* <h1>Home Controller Unit Testing</h1>
* Tests methods in Home Controller for
 * the purpose of remoting and REST
* @author  yahya
* @version 1.0
*/
@TestFor(HomeController)
@Stepwise
class HomeControllerSpec extends Specification {

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

    @Ignore
    def "test read remoting for grails3"() {
        when: 'invoke the index like we are hitting the url http://localhost:8090/httpInvokerConsumer/home/index'
          controller.index()

        then: 'statically providing book with id 3 underneath'
          response.json.title == 'title'

    }

    @Ignore
    def "test read REST"() {
        when: 'invoke the index like we are hitting the url http://localhost:8090/httpInvokerConsumer/home/restIndex'
        controller.restIndex()

        then:'statically providing book with id 3 underneath'
        response.json.title == 'title'

    }

    @Unroll
    def "test read all books httpInvoker with JSON #a"() {
        when:
        controller.list()


        then:
        // response.json.title == 'title'
        1==1

        where:
        a << [1,2,3,4,5,6,7,8,9,10]
    }


    @Unroll
    def "test read all books REST #a"() {
        when:
        controller.searchBook()

        then:
       // response.json.title == 'title'
        1==1

        where:
        a << [1,2,3,4,5,6,7,8,9,10]
    }


    @Unroll
    def "test read all books httpInvoker with DTO #a"() {
        when:
        controller.listDTO()

        then:
        // response.json.title == 'title'
        1==1

        where:
        a << [1,2,3,4,5,6,7,8,9,10]
    }

}
