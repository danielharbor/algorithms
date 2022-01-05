package com.phonescreens;

import java.util.List;
import static java.util.Arrays.asList;

class Airbnb2019 {

    public static void main(String[] args) {
        System.out.println("AirBnB phone screen!!!");
        System.out.println();

        List<Article> articles = asList(new Article("This is a long sentence" +
        " that should wrap around, after all is said and done."),
        new Article("The plane is flying high"),
        new Article("How difficult do you think this is really?"));

        int width = 90;

        printArticles(articles, width);
    }

    static void printArticles(List<Article> articles, int width) {
        printDashes(width);
        for (Article article : articles) {
            printArticle(article, width);
            printDashes(width);
        }
    }

    static void printArticle(Article article, int width) {
        System.out.print("+");
        String[] words = article.text.split(" ");
        int lenPrintedSoFar = 0;
        for (int i = 0; i < words.length; i++) {
            String nextWord = i == 0 ? words[i] : " " + words[i];
            if (lenPrintedSoFar + nextWord.length() > width) {
                printSpacePadding(lenPrintedSoFar, width);
                System.out.println("+"); // close current line
                System.out.print("+"); // begin new line
                System.out.print(words[i]);
                lenPrintedSoFar = words[i].length(); // start new length
            } else {
                System.out.print(nextWord);
                lenPrintedSoFar += nextWord.length();
            }
        }
        printSpacePadding(lenPrintedSoFar, width);
        System.out.println("+"); // close line
    }

    static void printSpacePadding(int lenPrintedSoFar, int width) {
        while (lenPrintedSoFar++ < width) {
            System.out.print(" ");
        }
    }

    static void printDashes(int w) {
        System.out.print("+");
        for (int i = 0; i < w; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}

class Article {
    String text;

    public Article(String t) {
        text = t;
    }
}
