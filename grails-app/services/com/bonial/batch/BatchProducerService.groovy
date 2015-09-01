package com.bonial.batch

import com.bonial.batch.interfaces.Producer
import org.springframework.batch.core.Job
import org.springframework.batch.core.JobParameters
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.core.configuration.JobRegistry
import org.springframework.batch.integration.launch.JobLaunchRequest
import org.springframework.integration.Message
import org.springframework.integration.message.GenericMessage

/**
 * batch-processor
 * @author  Konstantin Bork
 * @version 0.4
 * @created 08/28/2015
 *
 * The implementation of the Producer interface.
 */

class BatchProducerService implements Producer {

    def batchQueueService
    def springBatchService

    @Override
    String produceTask(String jobName, Map<String, String> params = null) {
        Job job = findJob(jobName)
        JobLaunchRequest launchRequest = buildLaunchRequest(job, params)
        Message m = new GenericMessage(launchRequest)
        batchQueueService.enqueue(m)
        return launchRequest.hashCode() // TODO change the String
    }

    /**
     * Finds the job by its name.
     *
     * @param jobName name of the job which should be found
     * @return job with the given name
     */
    Job findJob(String jobName) {
        JobRegistry registry = springBatchService.jobRegistry
        return registry.getJob(jobName)
    }

    /**
     * Builds the launch request for execution.
     *
     * @param job the job which should be executed
     * @param params parameters for the execution
     * @return
     */
    JobLaunchRequest buildLaunchRequest(Job job, Map<String, String> params) {
        JobParameters jobParameters = buildJobParameters(params)
        return new JobLaunchRequest(job, jobParameters)
    }

    /**
     * Converts all given parameters into JobParameters.
     *
     * @param params parameters for job execution
     * @return converted data
     */
    JobParameters buildJobParameters(Map<String, String> params) {
        JobParametersBuilder parametersBuilder = new JobParametersBuilder()
        if(!params) {
            parametersBuilder.addDate("Date", new Date())
        }
        else {
            for (def parameter in params)
                parametersBuilder.addString(parameter.key, parameter.value)
        }
        return parametersBuilder.toJobParameters()
    }

}