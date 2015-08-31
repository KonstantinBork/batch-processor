package com.bonial.batch

/**
 * batch-processor
 * @author  Konstantin Bork
 * @version 0.2
 * @created 08/28/2015
 *
 * A service which tests the sample job.
 */

class BatchTestService {

    def springBatchService

    def launchSampleJob() {
        println("Start new job")
        springBatchService.launch("sampleJob")
        println("Job started")
    }

}