package com.motorola.junit.utils;

import java.io.*;
import java.util.Properties;

public class CommonUtils {

    /**
     * @method readErrorMsgFile()
     * @description reads the existing file and loads the properties using Properties class and properties are returned
     * @return properties
     * @throws IOException
     */
    public Properties readErrorMsgFile() throws IOException {
        File file = new File("src/test/java/com/motorola/junit/resources/message.properties");
        FileReader fileReader = new FileReader(file);
        Properties properties = new Properties();
        properties.load(fileReader);
        return properties;
    }



}
