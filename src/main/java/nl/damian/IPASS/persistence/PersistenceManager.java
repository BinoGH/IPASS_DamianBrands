package nl.damian.IPASS.persistence;

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;

public class PersistenceManager {
    private final static String ENDPOINT = "https://binocitiesblob.file.core.windows.net/";
    private final static String SASTOKEN = "?sv=2020-02-10&ss=b&srt=sco&sp=rwdlactfx&se=2021-06-01T23:22:41Z&st=2021-06-01T15:22:41Z&spr=https&sig=CzfNbFgmrUfYCnqg289lEB6kk3Zi5nBifAAAS6OZzQY%3D";
    private final static String CONTAINER = "bankcontainer";

    private static BlobContainerClient blobContainer = new BlobContainerClientBuilder()
            .endpoint(ENDPOINT).sasToken(SASTOKEN).containerName(CONTAINER).buildClient();
}
