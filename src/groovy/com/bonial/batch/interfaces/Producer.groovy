package com.bonial.batch.interfaces

/**
 * batch-processor
 * @author Konstantin Bork
 * @version 0.2
 * @created 08/28/2015
 *
 * Interface for the task producer.
 */

interface Producer {

    /**
     * TODO look for parameter types
     * This function produces a batch task from given data and puts
     * it into the queue.
     *
     * @param jobName name of the job which should be run
     * @param params list of parameters needed for execution
     * @return unique ID of the task put into the queue
     */
    String produceTask(String jobName, Map params)

}