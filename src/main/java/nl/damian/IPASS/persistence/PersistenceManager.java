package nl.damian.IPASS.persistence;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import nl.damian.IPASS.domein.Gebruiker;
import nl.damian.IPASS.domein.Product;
import java.io.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import static nl.damian.IPASS.domein.Gebruiker.getGebruikers;
import static nl.damian.IPASS.domein.Product.getAssortiment;

public class PersistenceManager {
    private final static String ENDPOINT = "https://binocitiesblob.file.core.windows.net/";
    private final static String SASTOKEN = "?sv=2020-02-10&ss=b&srt=sco&sp=rwdlactfx&se=2021-06-01T23:22:41Z&st=2021-06-01T15:22:41Z&spr=https&sig=CzfNbFgmrUfYCnqg289lEB6kk3Zi5nBifAAAS6OZzQY%3D";
    private final static String CONTAINER = "bankcontainer";

    private static BlobContainerClient blobContainer = new BlobContainerClientBuilder()
            .endpoint(ENDPOINT).sasToken(SASTOKEN).containerName(CONTAINER).buildClient();

    public void saveBlobba() throws IOException {
        BlobClient blob = blobContainer.getBlobClient("ShopBlob");
        CollectiveClass all = new CollectiveClass();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        all.setAssortiment(Product.getAssortiment());
        all.setGebruikers(Gebruiker.getGebruikers());

        oos.writeObject(all);

        byte[] bytez = baos.toByteArray();

        ByteArrayInputStream bais = new ByteArrayInputStream(bytez);
        blob.upload(bais, bytez.length,true);

        bais.close();
        baos.close();
        oos.close();
    }

    public void loadBlobba() throws IOException, ClassNotFoundException {
        if (blobContainer.exists()) {
            BlobClient blob = blobContainer.getBlobClient("ShopBlob");

            if (blob.exists()) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                blob.download(baos);

                ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                ObjectInputStream ois = new ObjectInputStream(bais);

                CollectiveClass loadedClasses = (CollectiveClass) ois.readObject();

                Product.setAssortiment(loadedClasses.getAssortiment());
                Gebruiker.setGebruikers(loadedClasses.getGebruikers());
            }
        }
    }
}
