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
{int}  {return new Symbol(sym.INT);}
{char}  {return new Symbol(sym.CHAR);}
{nat}   {return new Symbol(sym.NAT);}

{program}   {return new Symbol(sym.PROGRAM);}
{consts}   {return new Symbol(sym.CONSTS);}
{const}   {return new Symbol(sym.CONST);}
{tipos}   {return new Symbol(sym.TIPOS);}
{tipo}   {return new Symbol(sym.TIPO);}

{naturales}   {return new Symbol(sym.NATURALES, yytext());}
{real}   {return new Symbol(sym.REAL, yytext());}
{entero}   {return new Symbol(sym.ENTERO, yytext());}
{caracter}   {return new Symbol(sym.CARACTER, yytext());}
{booleano}   {return new Symbol(sym.BOOLEANO, yytext());}
{vars}   {return new Symbol(sym.VARS);}
{var}   {return new Symbol(sym.VAR);}
{natural}   {return new Symbol(sym.NATURAL);}
{integer}   {return new Symbol(sym.INTEGER);}
{float}   {return new Symbol(sym.FLOAT);}
{character}   {return new Symbol(sym.CHARACTER);}
{boolean}   {return new Symbol(sym.BOOLEAN);}
{subprograms}   {return new Symbol(sym.SUBPROGRAMS);}
{subprogram}   {return new Symbol(sym.SUBPROGRAM);}
{instructions}   {return new Symbol(sym.INSTRUCTIONS);}
{swap1}   {return new Symbol(sym.SWAP1);}
{swap2}   {return new Symbol(sym.SWAP2);}
{in}   {return new Symbol(sym.IN);}
{out}   {return new Symbol(sym.OUT);}
{and}     {return new Symbol(sym.AND);}
{or}      {return new Symbol(sym.OR);}
{if}      {return new Symbol(sym.IF);}
{then}    {return new Symbol(sym.THEN);}
{else}    {return new Symbol(sym.ELSE);}
{endif}      {return new Symbol(sym.ENDIF);}
{while}   {return new Symbol(sym.WHILE);}
{call}   {return new Symbol(sym.CALL);}
{do}   {return new Symbol(sym.DO);}
{endwhile}   {return new Symbol(sym.ENDWHILE);}


{not}   {return new Symbol(sym.NOT);}
\_   {return new Symbol(sym.BARRABAJA);}
\(        {return new Symbol(sym.PAP);}
\)        {return new Symbol(sym.PCIERRE);}
\{        {return new Symbol(sym.LLAVEAP);}
\}        {return new Symbol(sym.LLAVECIERRE);}
\[        {return new Symbol(sym.CORCAP);}
\]        {return new Symbol(sym.CORCCIERRE);}
\,        {return new Symbol(sym.COMA);}
\:        {return new Symbol(sym.DOSPUNTOS);}
\;        {return new Symbol(sym.PUNTOYCOMA);}
\=       {return new Symbol(sym.IGUAL);}
\<        {return new Symbol(sym.MENOR);}
\>        {return new Symbol(sym.MAYOR);}
\<=        {return new Symbol(sym.MENORIGUAL);}
\>=        {return new Symbol(sym.MAYORIGUAL);}
\==        {return new Symbol(sym.IGUALIGUAL);}
\!=        {return new Symbol(sym.DISTINTO);}
\+        {return new Symbol(sym.MAS);}
\-        {return new Symbol(sym.MENOS);}
\*        {return new Symbol(sym.MULT);}
\/        {return new Symbol(sym.DIV);}
\%        {return new Symbol(sym.MOD);}
\>>        {return new Symbol(sym.DESPDER);}
\<<        {return new Symbol(sym.DESPIZQ);}
{identificador}   {return new Symbol(sym.IDENTIFICADOR, yytext());}


[^]       {throw new Error("Caracter no reconocido:"+yytext());}

