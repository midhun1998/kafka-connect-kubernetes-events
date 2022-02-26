package com.mid.kafka;

import org.slf4j.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.source.SourceRecord;
import org.apache.kafka.connect.source.SourceTask;
import org.slf4j.LoggerFactory;

public class KubeSourceTask extends SourceTask {

    private static Logger log = LoggerFactory.getLogger(KubeSourceTask.class);
    private KubeSourceConnectorConfig config;
    private List<String> sources;

    @Override
    public String version() {
        return PropertiesUtil.getConnectorVersion();
    }

    @Override
    public void start(Map<String, String> props) {
        config = new KubeSourceConnectorConfig(props);
        String sourcesStr = props.get("sources");
        sources = Arrays.asList(sourcesStr.split(","));
    }

    @Override
    public List<SourceRecord> poll() throws InterruptedException {
        List<SourceRecord> records = new ArrayList<>();
        for (String source : sources) {
            log.info("Polling data from source: " + source);
            records.add(new SourceRecord(Collections.singletonMap("source", source),
                    Collections.singletonMap("offset", 0), source, null, null, null,
                    Schema.BYTES_SCHEMA, String.format("Data from %s", source).getBytes()));
        }
        return records;
    }

    @Override
    public void stop() {
    }

}
