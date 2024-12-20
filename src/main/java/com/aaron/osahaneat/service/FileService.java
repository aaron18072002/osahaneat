package com.aaron.osahaneat.service;

import com.aaron.osahaneat.service.imp.FileServiceImp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileService implements FileServiceImp {

    @Value("${fileUpload.rootPath}")
    private String rootPath;

    private Path root;

    public final void init() {
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
            Files.copy(file.getInputStream(),
                    this.root.resolve(file.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException e) {
            System.out.println("Error in saveFile: " + e.getMessage());
            return false;
        }
    }

    // resolve = rootPath + /
    @Override
    public Resource loadFile(String fileName) {
        try {
            Path file = this.root.resolve(fileName);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }
        } catch (IOException ex) {
            System.out.println("Error in loadFile: " + ex.getMessage());
        }

        return null;
    }

}
