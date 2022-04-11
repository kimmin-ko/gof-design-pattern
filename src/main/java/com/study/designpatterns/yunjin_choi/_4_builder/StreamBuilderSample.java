package com.study.designpatterns.yunjin_choi._4_builder;

import java.util.stream.Stream;

/**
 * <pre>
 * com.study.designpatterns.yunjin_choi._4_builder
 *      StreamBuilderSample
 * </pre>
 *
 * @author YunJin Choi(zzdd1558@gmail.com)
 * @since 2022-04-10 오후 11:52
 */

public class StreamBuilderSample {
    public static void main(String[] args) {
        Stream.Builder<String> builder = Stream.builder();
        //
        // public static<T> Builder<T> builder() {
        //     return new Streams.StreamBuilderImpl<>();
        // }
        Stream<String> names = Stream.<String>builder().add("abc").add("def").build();
        names.forEach(System.out::print);
    }
}
