package com.bonial.batch

import com.bonial.batch.interfaces.Consumer
import grails.transaction.Transactional

/**
 * batch-processor
 * @author  Konstantin Bork
 * @version 0.1
 * @created 08/28/2015
 *
 * The implementation of the Consumer interface.
 */

@Transactional
class BatchConsumerService implements Consumer {

    @Override
    void consumeNextTask() {

    }

}