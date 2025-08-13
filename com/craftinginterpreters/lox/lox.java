package com.craftinginterpreters.lox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Lox{
    static boolean hadError = false;
    public static void main(String[] args) throws IOException{
        if (args.length > 1){ //if there is more than one argument exit
            System.out.println("Usage: jlox [script]");
            System.exit(64);
        }else if (args.length == 1) {//if there is one argument runFile with the argument as the path
            runFile(args[0]);
        } else {//otherwise runPrompt
            runPrompt();
        }
    }
    private static void runFile(String path) throws IOException{
        byte[] bytes = Files.readAllBytes(Paths.get(path));//turns path into bytes
        run(new String(bytes, Charset.defaultCharset()));//turns bytes into a String and inputs it as an argument for run()

        if (hadError) System.exit(65);
    }
    private static void runPrompt() throws IOException{
        InputStreamReader input = new InputStreamReader(System.in);//creates a Input stream reader
        BufferedReader reader = new BufferedReader(input);//creates a buffered reader using the input stream reader
        for(;;){//loops until break
            System.out.print(">");
            String line = reader.readLine();//prompts the user for an input
            if (line == null)break;//breaks if no input
            run(line);//uses the input as an argument for run
            hadError = false;
        }
    }
    private static void run(String source){
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();
        
        for (Token token : tokens){
            System.out.println(token);
        }
    
    }
    static void error(int line, String message){
        report(line, "", message);
    }
    private static void report(int line, String where, String message){
        System.err.println("[line"+ line + "] Error" +": " + message);
        hadError = true;
    }
}
