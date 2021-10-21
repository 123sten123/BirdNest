package ru.birdnest.service;

import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.ObjectWriteResponse;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


@Service
@RequestScope
@Qualifier("minioService")
public class MinIoService implements ServiceStrong {

    public void storeFile(String key, byte[] content){
        try{
            ByteArrayInputStream bais = new ByteArrayInputStream(content);

            MinioClient minioClient =
                    MinioClient.builder()
                            .endpoint("http://192.168.0.101:9000")
                            .credentials("admin", "password")
                            .build();

            ObjectWriteResponse response = minioClient.putObject(
             PutObjectArgs.builder().bucket("test").
                     object(key).stream(bais, content.length, -1).build()
            );

            System.out.println("put " +key+ " чет еще");

        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    public byte[] readFile(String key){

        MinioClient minioClient =
                MinioClient.builder()
                        .endpoint("http://127.0.0.1:9000")
                        .credentials("admin", "password")
                        .build();
        try(InputStream stram = minioClient.getObject(GetObjectArgs.builder()
                .bucket("test")
                .object(key)
                . build())) {

            return stram.readAllBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

}
