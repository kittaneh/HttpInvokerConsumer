package rnd.grails3.httpinvoker.consumer

import grails.converters.JSON
import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse
import groovy.time.TimeCategory
import groovy.time.TimeDuration

/**
* <h1>Home Controller</h1>
* @author  yahya
* @version 1.0
*/

class HomeController {

    RemotingBookService remotingBookService



    def index() {
        def myRes = JSON.parse(remotingBookService.findBookById(3L))
        render  myRes
    }

    def list(){
        remotingBookService.getAllBooks()
        return []
    }


    def listDTO(){
        remotingBookService.getAllBooksDTO()
        return []
    }


    def saveBook(BookCommand bc){
        /* just like we are using the domain class!
           the advantage of this approach that we are validating
           before remoting
         */
        if(!bc.hasErrors()){
            remotingBookService.saveBook(bc)
        } else {
            bc.errors.allErrors.each{
                println it
            }
        }

        return []
    }

    def restIndex(){
        def rest = new RestBuilder()
       RestResponse resp = rest.get("http://localhost:8080/httpInvokerProducer/books/3")
       JSON.use('deep'){
           render resp.json
       }

        return []
    }


    def restSaveBook(BookCommand bc){
        /* just like we are using the domain class!
           the advantage of this approach that we are validating
           before remoting
         */
        if(!bc.hasErrors()){
            def rest = new RestBuilder()
            RestResponse resp = rest.post("http://localhost:8080/httpInvokerProducer/books/"){
                json (bc as JSON).toString()
            }
        } else {
            bc.errors.allErrors.each{
                println it
            }
        }
        return []
    }


    def getBooksJSON(){

        def rest = new RestBuilder()
        def timeStart = new Date()
        RestResponse resp = rest.get("http://localhost:8080/httpInvokerProducer/books/?parser={parser}"){
            urlVariables parser: "json"

        }
        def timeStop = new Date()
        TimeDuration duration = TimeCategory.minus(timeStop, timeStart)
        println " consumer: REST protocol with JSON time: " + duration.toMilliseconds()

        return []
    }


    def getBooksGSON(){

        def rest = new RestBuilder()
        def timeStart = new Date()
        RestResponse resp = rest.get("http://localhost:8080/httpInvokerProducer/books/?parser={parser}"){
            urlVariables parser: "gson"

        }
        def timeStop = new Date()
        TimeDuration duration = TimeCategory.minus(timeStop, timeStart)
        println " consumer: REST protocol with GSON time: " + duration.toMilliseconds()

        return []
    }



}
