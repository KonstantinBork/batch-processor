package com.bonial.batch

import com.bonial.batch.interfaces.Queue
import grails.transaction.Transactional

/**
 * batch-processor
 * @author  Konstantin Bork
 * @version 0.1
 * @created 08/28/2015
 *
 * The implementation of the Queue interface.
 */

@Transactional
class BatchQueueService implements Queue {

    @Override
    void enqueue() {

    }

    @Override
    void dequeue() {

    }

    @Override
    int size() {
        return 0
    }

    @Override
    void head() {

    }

    @Override
    boolean isEmpty() {
        return false
    }

}