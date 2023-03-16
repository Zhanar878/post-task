package kz.dar.academy.backend.config;

import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

@Configuration
public class ElasticConfig extends AbstractElasticsearchConfiguration {
    @Override
    public RestHighLevelClient elasticsearchClient(){
        ClientConfiguration clientConfiguration=ClientConfiguration.builder()
                .connectedTo("post-task.es.us-central1.gcp.cloud.es.io:9243")
                .usingSsl()
                .withBasicAuth("elastic","9S1f5VtpNyuVuyd3hYIr4QAL")
                .build();
                return RestClients.create(clientConfiguration).rest();
    }
}
