package rnd.grails3.httpinvoker.consumer

import grails.converters.JSON
import grails.test.mixin.TestFor
import rnd.grails3.httpinvoker.producer.dto.BookDTO
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

/**
 * <h1>RemotingBook Service Unit Testing</h1>
 * Tests methods in RemotingBook Service for
 * the purpose of remoting
 * @author  yahya
 * @version 1.0
 */
@TestFor(RemotingBookService)
class RemotingBookServiceSpec extends Specification {

    // global properties to share among all specs
    @Shared proxyFactoryService

    /**
     *  In TEST environment you should manually inject
     *  any spring beans (even grails services)
     */
    def doWithSpring = {
        proxyFactoryService(ProxyFactoryService)
    }

    /**
     * putting all shared assignations and initializations to all specs
     */
    def setup() {
        proxyFactoryService = grailsApplication.mainContext.getBean('proxyFactoryService')
    }

    @Unroll
    def "test read remoting for grails3 using book id number #a"() {
        given:
        def jsonBook = JSON.parse(service.findBookById(a))

        expect:
        jsonBook.title == b

        where:
        a << [3L,15L]
        b << ["title","title"]

    }


    @Unroll
    def "test read all data using remoting with JSON #a"() {
        given:
        def jsonBooks =service.getAllBooks()
        def jsonBookList = JSON.parse(jsonBooks) as List

        expect:
        jsonBookList.size()==5000

        where:
        a << [1,2]

    }


    @Unroll
    def "test read all data using remoting with DTO #a"() {
        given:
        List<BookDTO> books =service.getAllBooksDTO()

        expect:
        books.size()==5000

        where:
        a << [1,2]

    }

}
