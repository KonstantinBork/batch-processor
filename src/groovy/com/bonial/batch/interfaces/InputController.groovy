package com.bonial.batch.interfaces

/**
 * batch-processor
 * @author Konstantin Bork
 * @version 0.5
 * @created 08/28/2015
 *
 * Interface for the input controller.
 */

interface InputController {

    /**
     * Registers a new batch task to the queue.
     */
    def registerTask()

    /**
     * Gets the current status of the given batch task.
     */
    def getStatus()

    /**
     * Requests to pause the given batch task.
     */
    def pauseTask()

    /**
     * Requests to stop the given batch task.
     */
    def stopTask()

}