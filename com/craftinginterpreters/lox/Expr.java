package com.craftinginterpreters.lox;
/* EXPRESSION SYNTAX
A capitalized terminal represents a single lexeme whose representation may vary
A quated string represents terminals that match exact lexemes

expression     → literal | unary | binary | grouping ;

literal        → NUMBER | STRING | "true" | "false" | "nil" ;
grouping       → "(" expression ")" ;
unary          → ( "-" | "!" ) expression ;
binary         → expression operator expression ;
operator       → "==" | "!=" | "<" | "<=" | ">" | ">="
               | "+"  | "-"  | "*" | "/" ; */
abstract class Expr {
    static class Binary extends Expr{
        Binary(Expr left, Token operator, Expr right){
            this.left = left;
            this.operator = operator;
            this.right = right;
        }
        final Expr left;
        final Token operator;
        final Expr right;
    }
    
}
