package com.bonial.batch.interfaces

/**
 * batch-processor
 * @author Konstantin Bork
 * @version 0.1
 * @created 08/28/2015
 *
 * Interface for the task producer.
 */

interface Producer {

    /**
     * This function produces a batch task from given data and puts
     * it into the queue.
     *
     * @return unique ID of the task put into the queue
     */
    String produceTask()

}