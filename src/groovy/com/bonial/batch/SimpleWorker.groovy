package com.bonial.batch

import com.bonial.batch.interfaces.Worker
import org.springframework.integration.Message

/**
 * batch-processor
 * @author Konstantin Bork
 * @version 0.2
 * @created 08/31/2015
 *
 * Implementation of the Worker interface.
 */

class SimpleWorker implements Worker {

    def currentTask

    @Override
    boolean start(Message m) {
        if(currentTask) return false
        currentTask = m.payload
        // TODO logic for task starting
    }

    @Override
    boolean stop() {
        if(!currentTask) return false
        // TODO logic for task stopping
        currentTask = null
        return true
    }

    @Override
    boolean pause() {
        // TODO logic for task pausing
    }

}