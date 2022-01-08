package com.mid.kafka;

import java.util.Map;
import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.config.ConfigDef.Importance;
import org.apache.kafka.common.config.ConfigDef.Type;

public class KubeSourceConnectorConfig extends AbstractConfig {

    public KubeSourceConnectorConfig(final Map<?, ?> originals) {
        super(CONFIG, originals);
    }

    public static final ConfigDef CONFIG = createConfigDef();

    private static final String TOPIC_MAPPER_CONFIG = "topic.mapper";
    // Yet to implement!!
    private static final String TOPIC_MAPPER_DEFAULT =
            "com.mid.kafka.config.topic.mapping.DefaultTopicMapper";
    // Determine the optimum field to use for topic mapping?
    private static final String TOPIC_MAPPER_DOC =
            "The class that determines the topic to write the source data to. By default this will be based on the 'uid' field in the Kubernetes event document.";

    private static final String NAMESPACE_CONFIG = "kube.namespace";
    private static final String NAMESPACE_DEFAULT = "all";
    private static final String NAMESPACE_DOC =
            "The Kubernetes namespace to read events from. By default all events of the cluster would be read.";

    public static final String MONITOR_THREAD_TIMEOUT_CONFIG = "monitor.thread.timeout";
    private static final String MONITOR_THREAD_TIMEOUT_DOC =
            "Timeout used by the monitoring thread";
    private static final int MONITOR_THREAD_TIMEOUT_DEFAULT = 10000;

    private static ConfigDef createConfigDef() {
        ConfigDef configDef = new ConfigDef();
        configDef
                .define(TOPIC_MAPPER_CONFIG, Type.STRING, TOPIC_MAPPER_DEFAULT, Importance.HIGH,
                        TOPIC_MAPPER_DOC)

                .define(NAMESPACE_CONFIG, Type.STRING, NAMESPACE_DEFAULT, Importance.HIGH,
                        NAMESPACE_DOC)

                .define(MONITOR_THREAD_TIMEOUT_CONFIG, Type.INT, MONITOR_THREAD_TIMEOUT_DEFAULT,
                        Importance.LOW, MONITOR_THREAD_TIMEOUT_DOC);

        return configDef;
    }


}
