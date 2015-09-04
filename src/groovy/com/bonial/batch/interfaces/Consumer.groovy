package com.bonial.batch.interfaces

/**
 * batch-processor
 * @author Konstantin Bork
 * @version 0.5
 * @created 08/28/2015
 *
 * Interface for the batch task consumer.
 */

interface Consumer {

    /**
     * Takes the first task from the queue for execution.
     */
    void consumeNextTask()

}