package com.webflix.comm;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUploadUtil {
    public static void saveFile(String uploadDir, String fileName, InputStream fileContent) throws IOException {
        Files.createDirectories(Paths.get(uploadDir));
        Files.copy(fileContent, Paths.get(uploadDir).resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
    }
}
