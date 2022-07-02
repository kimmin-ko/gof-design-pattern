package com.study.designpatterns.min_kim._23_visitor._3_java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class VisitorInJava {

    public static void main(String[] args) throws IOException {
        Path startingDirectory = Path.of("/Users/kimmin2300/Desktop/personal/java-apps/gof-design-patterns");
        String fileToSearch = "VisitorInJava.java";

        SearchFileVisitor searchFileVisitor = new SearchFileVisitor(fileToSearch, startingDirectory);
        Files.walkFileTree(startingDirectory, searchFileVisitor);
    }
}
