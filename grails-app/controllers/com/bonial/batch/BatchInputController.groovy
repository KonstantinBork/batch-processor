package com.bonial.batch

import com.bonial.batch.interfaces.InputController
import org.springframework.batch.core.JobExecution
import org.springframework.batch.core.configuration.JobRegistry
import org.springframework.batch.core.launch.JobOperator

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
    def batchConsumerService

    boolean consumingRunning = false

    def index() {
        if(!consumingRunning) {
            Thread.start {
                while(true)
                    batchConsumerService.consumeNextTask()
            }
            consumingRunning = true
        }
        Map lists = prepareLists()
        render(view: "index", model: lists)
    }

    @Override
    def registerTask() {
        def batchTaskName = params.taskName
        batchProducerService.produceTask(batchTaskName)
        redirect(action: index())
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

    Map prepareLists() {
        JobRegistry registry = springBatchService.jobRegistry
        Collection<String> jobs = registry.jobNames
        JobOperator operator = springBatchService.jobOperator
        Map runningExecutions = [:]
        for(String job in jobs) {
            Set<Long> execs = operator.getRunningExecutions(job)
            runningExecutions.put(job, execs)
        }
        return [jobNames: jobs, executions: runningExecutions]
    }

}