package com.techriders.logisticservice.services;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FilesStorageService {
    public void init();

    public void save(MultipartFile file);

    public void deleteAll();

    public Stream<Path> loadAll();
}
