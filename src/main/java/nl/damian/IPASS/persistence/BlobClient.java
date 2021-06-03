package nl.damian.IPASS.persistence;

import java.io.InputStream;
import java.io.OutputStream;

public class BlobClient {
    public void delete(){

    }

    public void download(OutputStream stream){
    }

    public boolean exists(){
        return true;
    }

    public void upload(InputStream data,long length){
    }

    public void upload(InputStream data, long length, boolean overwrite){}
}
