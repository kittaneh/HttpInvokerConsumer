package rnd.grails3.httpinvoker.consumer

import grails.converters.JSON
import groovy.time.TimeCategory
import groovy.time.TimeDuration
import org.grails.web.json.JSONElement
import rnd.grails3.httpinvoker.producer.dto.BookDTO

/**
* <h1>Remoting Book Service</h1>
* Is a Proxy service that will call
 * remote methods
* @author  yahya
* @version 1.0
*/

class RemotingBookService {

    ProxyFactoryService proxyFactoryService

    /**
     *
     * @param book : a command object, the aim is to use strong typed object
     * to know what type, or name of parameters to send
     * @return  command object
     * @author yahya
     */
    public BookCommand saveBook(BookCommand book){
        JSON.use('deep')
        String bookJSON = (book as JSON).toString(true)
        String persisted  =  save(bookJSON)

        /*
        depends on the result coming from the producer!
        use when custom marshalling happen
        */
        def resultMap = JSON.parse(persisted)
        JSONElement commandObjectJSON = JSON.parse(resultMap.data)
        return new BookCommand(commandObjectJSON)

        /*
          uncomment if you use direct parse to command object
          return new BookCommand(JSON.parse(persisted))
         */

    }

    /* ######################  Remoting Services ######################## */

    /**
     * This is a proxy method that will call
     * http://[localhost][8080]/[httpInvokerProducer]/httpInvoker/BookService#findBookById
     * @param bookId: identifier to get data for
     * @return a string representation of Book JSON
     * @author yahya
     */
    public String findBookById(Long bookId){
        proxyFactoryService.bookProxySetup()
        return proxyFactoryService.bookProxy.findBookById(bookId)
    }


    /**
     * This is a proxy method that will call
     * http://[localhost][8080]/[httpInvokerProducer]/httpInvoker/BookService#getAllBooks
     * @return a string representation of all Books JSON
     * @author yahya
     */
    public String getAllBooks(){

        def timeStart = new Date()
        proxyFactoryService.bookProxySetup()
        String booksListJSON  = proxyFactoryService.bookProxy.getAllBooks()
        def timeStop = new Date()
        TimeDuration duration = TimeCategory.minus(timeStop, timeStart)
        println " consumer: httpInvoker protocol with JSON time: " + duration.toMilliseconds()

        return booksListJSON
    }


    /**
     * This is a proxy method that will call
     * http://[localhost][8080]/[httpInvokerProducer]/httpInvoker/BookService#getAllBooksDTO
     * @return a string representation of all Books JSON
     * @author yahya
     */
    public List<BookDTO> getAllBooksDTO(){

        def timeStart = new Date()
        proxyFactoryService.bookProxySetup()
        List<BookDTO> booksListDTO  = proxyFactoryService.bookProxy.getAllBooksDTO()
        def timeStop = new Date()
        TimeDuration duration = TimeCategory.minus(timeStop, timeStart)
        println " consumer: httpInvoker protocol with DTO time: " + duration.toMilliseconds()

        return booksListDTO
    }

    /**
     * This is a proxy method that will call
     * http://[localhost][8080]/[httpInvokerProducer]/httpInvoker/BookService#save
     * @param bookJSON: string representation of BookCommand JSON to put data
     * @return a string representation of Book (combined or separated) JSON with errors
     * @author yahya
     */
    private String save(String bookCommandJSON){
        proxyFactoryService.bookProxySetup()
        return proxyFactoryService.bookProxy.save(bookCommandJSON)
    }


}
