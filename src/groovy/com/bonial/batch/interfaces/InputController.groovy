package com.bonial.batch.interfaces

/**
 * batch-processor
 * @author Konstantin Bork
 * @version 0.1
 * @created 08/28/2015
 *
 * Interface for the input controller.
 */

interface InputController {

    /**
     * Registers a new batch task to the queue.
     */
    void registerTask()

    /**
     * Gets the current status of the given batch task.
     * @param batchTaskID
     */
    void getStatus(String batchTaskID)

    /**
     * Requests to pause the given batch task.
     * @param batchTaskID
     */
    void pauseTask(String batchTaskID)

    /**
     * Requests to stop the given batch task.
     * @param batchTaskID
     */
    void stopTask(String batchTaskID)

}