package org.averude.az204.lab1.service;

import com.azure.storage.blob.BlobContainerClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlobStorageServiceImpl implements BlobStorageService {

    private final BlobContainerClient blobContainerClient;

    @Override
    public byte[] getData(String blobName) {
        return blobContainerClient.getBlobClient(blobName)
                .getBlockBlobClient().downloadContent().toBytes();
    }
}
