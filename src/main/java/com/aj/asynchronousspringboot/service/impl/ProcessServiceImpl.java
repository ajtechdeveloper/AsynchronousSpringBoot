package com.aj.asynchronousspringboot.service.impl;

import com.aj.asynchronousspringboot.service.ProcessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ProcessServiceImpl implements ProcessService {

    private static final Logger logger = LoggerFactory.getLogger(ProcessServiceImpl.class);

    @Async("processExecutor")
    @Override
    public void process() {
        try {
            Thread.sleep(15 * 1000);
            logger.info("Processing complete");
        }
        catch (InterruptedException ie) {
            logger.error("Error in ProcessServiceImpl.process(): {}", ie.getMessage());
        }
    }
}
