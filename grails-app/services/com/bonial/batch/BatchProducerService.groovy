package com.bonial.batch

import com.bonial.batch.interfaces.Producer
import grails.transaction.Transactional

/**
 * batch-processor
 * @author  Konstantin Bork
 * @version 0.1
 * @created 08/28/2015
 *
 * The implementation of the Producer interface.
 */

@Transactional
class BatchProducerService implements Producer {

    @Override
    String produceTask() {
        return null
    }

}