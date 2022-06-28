package com.study.designpatterns.seungchan_moon._23_visitor.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class VisitorInJava {
    public static void main(String[] args) throws IOException {
        Path startingDirectory = Path.of("/Users/moon_/IdeaProjects/gof-design-patterns");
        SearchFileVisitor searchFileVisitor =
                new SearchFileVisitor("Triangle.java", startingDirectory);
        Files.walkFileTree(startingDirectory, searchFileVisitor);
    }
}
