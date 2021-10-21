package ru.birdnest.service;

public interface ServiceStrong {
    void storeFile(String key, byte[] content);
    byte[] readFile(String key);
}
