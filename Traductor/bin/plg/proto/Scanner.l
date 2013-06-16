package plg.proto;

import java_cup.runtime.*;

%%

%class Scanner

%unicode
%cup 
%line 
%column

program = "program"
consts = "consts" 
const = "const"
tipos = "tipos"
tipo = "tipo"
digito = [0-9]
letra = [A-Za-z_]
int = "int"
char = "char"
nat = "nat"
naturales = [0]|([1-9]({digito})*)
parte_exp = ("E"|"e"){entero}
parte_dec = "."([0]|({digito}*[1-9]))
parte_comp = {parte_dec}{parte_exp}
real = {entero}({parte_exp}|{parte_dec}|{parte_comp})
entero = [\-]?{naturales}
caracter = \'[^\']\' 
booleano = {true} | {false}
vars = "vars"
var = "var"
natural = "natural"
integer = "integer"
float = "float"
character = "character"
boolean = "boolean"
subprograms = "subprograms"
subprogram = "subprogram"
instructions = "instructions"
swap1 = "swap1"
swap2 = "swap2"
in = "in"
out = "out"
and = "and"
or = "or"
if = "if"
then = "then"
else = "else"
endif = "endif"
while = "while"
call = "call"
do = "do"
endwhile = "endwhile"
true = "true"
false = "false"

not = "not"
identificador = [a-z]({letra}|{digito})*


%%
[\ \n\f\t\r] {}
@[^\n]*   {}
{int}  {return new Symbol(sym.INT, yyline+1, yycolumn+1, yytext() );}
{char}  {return new Symbol(sym.CHAR, yyline+1, yycolumn+1, yytext() );}
{nat}   {return new Symbol(sym.NAT, yyline+1, yycolumn+1, yytext() );}

{program}   {return new Symbol(sym.PROGRAM, yyline+1, yycolumn+1, yytext() );}
{consts}   {return new Symbol(sym.CONSTS, yyline+1, yycolumn+1, yytext() );}
{const}   {return new Symbol(sym.CONST, yyline+1, yycolumn+1, yytext() );}
{tipos}   {return new Symbol(sym.TIPOS, yyline+1, yycolumn+1, yytext() );}
{tipo}   {return new Symbol(sym.TIPO, yyline+1, yycolumn+1, yytext() );}

{naturales}   {return new Symbol(sym.NATURALES, yyline+1, yycolumn+1, yytext() );}
{real}   {return new Symbol(sym.REAL, yyline+1, yycolumn+1, yytext() );}
{entero}   {return new Symbol(sym.ENTERO, yyline+1, yycolumn+1, yytext() );}
{caracter}   {return new Symbol(sym.CARACTER, yyline+1, yycolumn+1, yytext() );}
{booleano}   {return new Symbol(sym.BOOLEANO, yyline+1, yycolumn+1, yytext() );}
{vars}   {return new Symbol(sym.VARS, yyline+1, yycolumn+1, yytext() );}
{var}   {return new Symbol(sym.VAR, yyline+1, yycolumn+1, yytext() );}
{natural}   {return new Symbol(sym.NATURAL, yyline+1, yycolumn+1, yytext() );}
{integer}   {return new Symbol(sym.INTEGER, yyline+1, yycolumn+1, yytext() );}
{float}   {return new Symbol(sym.FLOAT, yyline+1, yycolumn+1, yytext() );}
{character}   {return new Symbol(sym.CHARACTER, yyline+1, yycolumn+1, yytext() );}
{boolean}   {return new Symbol(sym.BOOLEAN, yyline+1, yycolumn+1, yytext() );}
{subprograms}   {return new Symbol(sym.SUBPROGRAMS, yyline+1, yycolumn+1, yytext() );}
{subprogram}   {return new Symbol(sym.SUBPROGRAM, yyline+1, yycolumn+1, yytext() );}
{instructions}   {return new Symbol(sym.INSTRUCTIONS, yyline+1, yycolumn+1, yytext() );}
{swap1}   {return new Symbol(sym.SWAP1, yyline+1, yycolumn+1, yytext() );}
{swap2}   {return new Symbol(sym.SWAP2, yyline+1, yycolumn+1, yytext() );}
{in}   {return new Symbol(sym.IN, yyline+1, yycolumn+1, yytext() );}
{out}   {return new Symbol(sym.OUT, yyline+1, yycolumn+1, yytext() );}
{and}     {return new Symbol(sym.AND, yyline+1, yycolumn+1, yytext() );}
{or}      {return new Symbol(sym.OR, yyline+1, yycolumn+1, yytext() );}
{if}      {return new Symbol(sym.IF, yyline+1, yycolumn+1, yytext() );}
{then}    {return new Symbol(sym.THEN, yyline+1, yycolumn+1, yytext() );}
{else}    {return new Symbol(sym.ELSE, yyline+1, yycolumn+1, yytext() );}
{endif}      {return new Symbol(sym.ENDIF, yyline+1, yycolumn+1, yytext() );}
{while}   {return new Symbol(sym.WHILE, yyline+1, yycolumn+1, yytext() );}
{call}   {return new Symbol(sym.CALL, yyline+1, yycolumn+1, yytext() );}
{do}   {return new Symbol(sym.DO, yyline+1, yycolumn+1, yytext() );}
{endwhile}   {return new Symbol(sym.ENDWHILE, yyline+1, yycolumn+1, yytext() );}


{not}   {return new Symbol(sym.NOT, yyline+1, yycolumn+1, yytext() );}
\_   {return new Symbol(sym.BARRABAJA, yyline+1, yycolumn+1, yytext() );}
\(        {return new Symbol(sym.PAP, yyline+1, yycolumn+1, yytext() );}
\)        {return new Symbol(sym.PCIERRE, yyline+1, yycolumn+1, yytext() );}
\{        {return new Symbol(sym.LLAVEAP, yyline+1, yycolumn+1, yytext() );}
\}        {return new Symbol(sym.LLAVECIERRE, yyline+1, yycolumn+1, yytext() );}
\[        {return new Symbol(sym.CORCAP, yyline+1, yycolumn+1, yytext() );}
\]        {return new Symbol(sym.CORCCIERRE, yyline+1, yycolumn+1, yytext() );}
\,        {return new Symbol(sym.COMA, yyline+1, yycolumn+1, yytext() );}
\:        {return new Symbol(sym.DOSPUNTOS, yyline+1, yycolumn+1, yytext() );}
\;        {return new Symbol(sym.PUNTOYCOMA, yyline+1, yycolumn+1, yytext() );}
\=       {return new Symbol(sym.IGUAL, yyline+1, yycolumn+1, yytext() );}
\<        {return new Symbol(sym.MENOR, yyline+1, yycolumn+1, yytext() );}
\>        {return new Symbol(sym.MAYOR, yyline+1, yycolumn+1, yytext() );}
\<=        {return new Symbol(sym.MENORIGUAL, yyline+1, yycolumn+1, yytext() );}
\>=        {return new Symbol(sym.MAYORIGUAL, yyline+1, yycolumn+1, yytext() );}
\==        {return new Symbol(sym.IGUALIGUAL, yyline+1, yycolumn+1, yytext() );}
\!=        {return new Symbol(sym.DISTINTO, yyline+1, yycolumn+1, yytext() );}
\+        {return new Symbol(sym.MAS, yyline+1, yycolumn+1, yytext() );}
\-        {return new Symbol(sym.MENOS, yyline+1, yycolumn+1, yytext() );}
\*        {return new Symbol(sym.MULT, yyline+1, yycolumn+1, yytext() );}
\/        {return new Symbol(sym.DIV, yyline+1, yycolumn+1, yytext() );}
\%        {return new Symbol(sym.MOD, yyline+1, yycolumn+1, yytext() );}
\>>        {return new Symbol(sym.DESPDER, yyline+1, yycolumn+1, yytext() );}
\<<        {return new Symbol(sym.DESPIZQ, yyline+1, yycolumn+1, yytext() );}
{identificador}   {return new Symbol(sym.IDENTIFICADOR, yyline+1, yycolumn+1, yytext() );}


[^]       {throw new Error("Caracter no reconocido: "+ (yyline+1) + " " + (yycolumn+1) + " " + yytext());}

