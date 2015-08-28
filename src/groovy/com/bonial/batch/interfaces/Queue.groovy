package com.bonial.batch.interfaces

/**
 * batch-processor
 * @author Konstantin Bork
 * @version 0.1
 * @created 08/28/2015
 *
 * Interface for the batch task queue.
 */

interface Queue {

    /**
     * Puts the given batch task into the queue.
     */
    void enqueue()

    /**
     * Gets the first batch task from the queue and removes it.
     */
    void dequeue()

    /**
     * Gets the current size of the queue.
     * @return the size of the queue
     */
    int size()

    /**
     * Gets the first batch task without removing it.
     * @return
     */
    void head()

    /**
     * Asks if queue is empty or not.
     * @return if queue is empty
     */
    boolean isEmpty()

}