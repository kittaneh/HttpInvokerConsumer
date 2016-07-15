package rnd.grails3.httpinvoker.remoting

import rnd.grails3.httpinvoker.producer.dto.BookDTO

/**
* <h1>HttpInvoker Interface</h1>
* This interface should exists in both the producer and the consumer
* @author  yahya
* @version 1.0
*/

interface IBook {

    /**
     * Read Book instance by Id
     * @param bookId
     * @return pretty JSON string representation of the book object
     */
    String findBookById(Long bookId)


    /**
     * Get all the book instances filled to load test data
     * @return pretty JSON string representation of the all books objects
     */
    String getAllBooks()

    /**
     * Get all the book instances filled to load test data
     * @return all books dtos objects
     */
    List<BookDTO> getAllBooksDTO()


    /**
     * Saves new Book instance
     * @param bookJSON : a string representation of the book
     * @return pretty JSON string representation of the book persisted object
     */
    String save(String bookJSON)

}