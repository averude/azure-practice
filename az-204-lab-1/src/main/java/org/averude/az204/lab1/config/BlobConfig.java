package org.averude.az204.lab1.config;

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BlobConfig {

    @Value("${azure.blob.connectionString}")
    private String connectionString;

    @Value("${azure.blob.containerName}")
    private String containerName;

    @Bean
    public BlobContainerClient blobContainerClient() {
        return new BlobContainerClientBuilder()
                .connectionString(connectionString)
                .containerName(containerName)
                .buildClient();
    }
}
