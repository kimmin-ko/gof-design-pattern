package com.study.designpatterns.yunjin_choi._4_builder;

/**
 * <pre>
 * com.study.designpatterns.yunjin_choi._4_builder
 *      StringBuilderSample
 * </pre>
 *
 * @author YunJin Choi(zzdd1558@gmail.com)
 * @since 2022-04-10 오후 11:51
 */

public class StringBuilderSample {
    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder();

        // return StringBuilder
        builder.append("abc");
        builder.append("def");

    }
}
