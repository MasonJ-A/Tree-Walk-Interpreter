package com.craftinginterpreters.lox;

public enum TokenType {
    //Single Character Tokens
    LEFT_PAREN, RIGHT_PAREN, LEFT_BRACE, RIGHT_BRACE,
    COMMA, DOT, MINUS, PLUS, SEMICOLON, STAR, SLASH,

    //One or Two Character Tokens
    BANG, BANG_EQUAL, 
    EQUAL, EQUAL_EQUAL, 
    GREATER, GREATER_EQUAL,
    LESS, LESS_EQUAL,

    //Literals
    IDENTIFIER, STRING, NUMBER,

    //Keywords
    AND, CLASS, ELSE, FLASE, FUN, IF, NIL, OR,
    PRINT, RETURN, SUPER, THIS, TRUE, VAR, WHILE,

    EOF

}
