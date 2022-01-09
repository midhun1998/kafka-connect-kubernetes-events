package com.mid.kafka;

import static java.util.Collections.singletonList;
import java.util.List;
import java.util.Map;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.source.SourceConnector;

public class KubeSourceConnector extends SourceConnector {
    private Map<String, String> settings;

    @Override
    public String version() {
        return PropertiesUtil.getConnectorVersion();
    }

    @Override
    public void start(Map<String, String> props) {
        this.settings = props;
    }

    @Override
    public Class<? extends Task> taskClass() {
        return KubeSourceTask.class;
    }

    @Override
    public List<Map<String, String>> taskConfigs(int maxTasks) {
        return singletonList(settings);
    }

    @Override
    public void stop() {}

    @Override
    public ConfigDef config() {
        return KubeSourceConnectorConfig.CONFIG;
    }

}
