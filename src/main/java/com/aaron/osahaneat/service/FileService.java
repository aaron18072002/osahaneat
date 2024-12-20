package com.aaron.osahaneat.service;

import com.aaron.osahaneat.service.imp.FileServiceImp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService implements FileServiceImp {

    @Value("${fileUpload.rootPath}")
    private String rootPath;

    private Path root;

    public final void init() throws IOException {
        try {
            this.root = Paths.get(this.rootPath);
            if(Files.notExists(this.root)) {
                Files.createDirectories(this.root);
            }
        } catch(IOException ex) {
            System.out.println("Error in init: " + ex.getMessage());
        }
    }

    @Override
    public boolean saveFile(MultipartFile file) {
        try {
            return true;
        } catch (Exception e) {
            System.out.println("Error in saveFile: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Resource loadFile(String fileName) {
        return null;
    }

}
