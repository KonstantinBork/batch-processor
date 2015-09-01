package com.bonial.batch

import org.springframework.batch.core.Job
import org.springframework.batch.core.configuration.JobRegistry
import org.springframework.batch.integration.launch.JobLaunchRequest
import org.springframework.integration.Message
import org.springframework.integration.message.GenericMessage

/**
 * batch-processor
 * @author  Konstantin Bork
 * @version 0.2
 * @created 08/28/2015
 *
 * A service which tests the sample job.
 */

class BatchTestService {

    static transactional = false

    def springBatchService

    def launchSampleJob() {
        springBatchService.launch("sampleJob")
    }

    def testWorker() {
        def worker = new SimpleWorker()
        JobRegistry registry = springBatchService.jobRegistry
        Job job = registry.getJob("sampleJob")
        JobLaunchRequest request = new JobLaunchRequest(job, null)
        Message m = new GenericMessage(request)
        worker.start(m)
    }

}