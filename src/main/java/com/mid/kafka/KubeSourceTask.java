package com.mid.kafka;

import java.util.List;
import java.util.Map;
import org.apache.kafka.connect.source.SourceRecord;
import org.apache.kafka.connect.source.SourceTask;

public class KubeSourceTask extends SourceTask {

    @Override
    public String version() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void start(Map<String, String> props) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<SourceRecord> poll() throws InterruptedException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub
        
    }
    
}
