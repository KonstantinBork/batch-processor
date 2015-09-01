package com.bonial.batch

/**
 * batch-processor
 * @author  Konstantin Bork
 * @version 0.4
 * @created 08/28/2015
 *
 * A controller which let the BatchTestService test the sample job.
 */

class BatchelorController {

    def batchTestService
    def batchProducerService
    def batchConsumerService

    def index() {

    }

    def launchSampleJobOnce() {
        batchTestService.launchSampleJob()
        redirect(uri: "/batchelor/index")
    }

    def launchSampleJobTenTimes() {
        for(int i in 0..9) {
            batchTestService.launchSampleJob()
        }
        redirect(uri: "/batchelor/index")
    }

    def launchSampleJob100() {
        for(int i in 0..99) {
            batchTestService.launchSampleJob()
        }
        redirect(uri: "/batchelor/index")
    }

    def produceTask() {
        int i = batchProducerService.batchQueueService.size()
        println(i)
        batchProducerService.produceTask("sampleJob")
        i = batchProducerService.batchQueueService.size()
        println(i)
        redirect(uri: "/batchelor/index")
    }

    def produce10Tasks() {
        int i = batchProducerService.batchQueueService.size()
        println(i)
        for(int j in 1..10)
            batchProducerService.produceTask("sampleJob")
        i = batchProducerService.batchQueueService.size()
        println(i)
        redirect(uri: "/batchelor/index")
    }

    def testConsumer() {
        for(int i in 1..100) {
            batchProducerService.produceTask("sampleJob")
            Thread.sleep(100)
        }
        while(!batchProducerService.batchQueueService.empty)
            batchConsumerService.consumeNextTask()
        redirect(uri: "/batchelor/index")
    }

    def testWorker() {
        batchTestService.testWorker()
        redirect(uri: "/batchelor/index")
    }

}