package rnd.grails3.httpinvoker.consumer

import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean
import rnd.grails3.httpinvoker.remoting.IBook

/**
* <h1>Http Factory</h1>
* Factory Pattern to encapsulate all remoting settings
* @author  yahya
* @version 1.0
*/

class ProxyFactoryService {


    def bookProxy

    /**
     *  encapsulate settings for the book service
     *  @author: yahya
     */
    public void bookProxySetup() {
        if (!bookProxy) {
            try {
                HttpInvokerProxyFactoryBean httpInvokerBook = new HttpInvokerProxyFactoryBean()
                httpInvokerBook.setServiceInterface(IBook)
                httpInvokerBook.setServiceUrl("http://localhost:8080/httpInvokerProducer/httpinvoker/BookService")
                httpInvokerBook.afterPropertiesSet()
                bookProxy = (IBook) httpInvokerBook.getObject()
            } catch (ConnectException ex) {
                ex.printStackTrace()
            }
        }
    }

}
