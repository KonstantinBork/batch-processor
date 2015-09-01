package com.bonial.batch

import com.bonial.batch.interfaces.InputController
import org.springframework.batch.core.JobExecution

/**
 * batch-processor
 * @author  Konstantin Bork
 * @version 0.4
 * @created 08/28/2015
 *
 * Controller for incoming batch tasks.
 */

class BatchInputController implements InputController {

    def batchProducerService
    def springBatchService

    def index() {

    }

    @Override
    def registerTask() {
        def batchTaskName = params.taskName
        batchProducerService.produceTask(batchTaskName)
        println("task in system")
        redirect(url: "/batchInput/index")
    }

    @Override
    def getStatus() {
        JobExecution execution = getExecution(params.taskId)
        return execution.status
    }

    @Override
    def pauseTask() {
        JobExecution execution = getExecution(params.taskId)
    }

    @Override
    def stopTask() {
        JobExecution execution = getExecution(params.taskId)
        execution.stop()
    }

    JobExecution getExecution(String id) {
        def taskExecutionId = Long.parseLong(id)
        return springBatchService.jobExecution(taskExecutionId)
    }

}