/* The following code was generated by JFlex 1.4.3 on 16/06/13 22:00 */

package plg.proto;

import java_cup.runtime.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 16/06/13 22:00 from the specification file
 * <tt>./Scanner.l</tt>
 */
class Scanner implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\37\1\41\1\0\2\37\22\0\1\37\1\57\3\0\1\63"+
    "\1\0\1\24\1\43\1\44\1\61\1\60\1\51\1\23\1\22\1\62"+
    "\1\17\1\33\1\34\7\14\1\52\1\53\1\55\1\54\1\56\1\0"+
    "\1\40\4\15\1\20\25\15\1\47\1\0\1\50\1\0\1\42\1\0"+
    "\1\5\1\31\1\7\1\35\1\21\1\30\1\4\1\16\1\13\2\36"+
    "\1\27\1\6\1\10\1\3\1\1\1\36\1\2\1\11\1\12\1\26"+
    "\1\25\1\32\3\36\1\45\1\0\1\46\uff82\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\11\2\2\3\1\2\1\4\1\1\5\2"+
    "\2\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\1\22\1\1\1\23"+
    "\1\24\1\25\1\26\1\2\1\27\14\2\1\30\1\31"+
    "\2\0\2\2\2\32\1\0\5\2\1\33\1\34\1\35"+
    "\1\36\1\37\1\40\1\41\1\2\1\42\1\43\3\2"+
    "\1\44\1\45\6\2\1\46\2\47\1\0\1\47\2\2"+
    "\1\50\1\51\6\2\1\52\1\53\3\2\1\54\1\55"+
    "\1\56\2\2\1\0\2\2\1\57\1\60\4\2\1\61"+
    "\3\2\1\62\1\63\1\64\2\2\1\65\1\2\1\66"+
    "\1\2\1\67\1\2\1\70\7\2\1\71\1\2\1\72"+
    "\2\2\1\73\1\2\1\74\3\2\1\75\1\76\2\2"+
    "\1\77\1\2\1\100\1\2\1\101";

  private static int [] zzUnpackAction() {
    int [] result = new int[167];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\64\0\150\0\234\0\320\0\u0104\0\u0138\0\u016c"+
    "\0\u01a0\0\u01d4\0\u0208\0\u023c\0\u0270\0\u02a4\0\u02d8\0\u030c"+
    "\0\u0340\0\u0374\0\u03a8\0\u03dc\0\u0410\0\64\0\u0444\0\64"+
    "\0\64\0\64\0\64\0\64\0\64\0\64\0\64\0\64"+
    "\0\64\0\u0478\0\u04ac\0\u04e0\0\u0514\0\64\0\64\0\64"+
    "\0\64\0\u0548\0\234\0\u057c\0\u05b0\0\u05e4\0\u0618\0\u064c"+
    "\0\u0680\0\u06b4\0\u06e8\0\u071c\0\u0750\0\u0784\0\u07b8\0\u07ec"+
    "\0\234\0\u0820\0\u0854\0\u0888\0\u08bc\0\u08f0\0\u0270\0\u0924"+
    "\0\u0958\0\u098c\0\u09c0\0\u09f4\0\u0a28\0\234\0\64\0\64"+
    "\0\64\0\64\0\64\0\64\0\u0a5c\0\234\0\234\0\u0a90"+
    "\0\u0ac4\0\u0af8\0\234\0\u0b2c\0\u0b60\0\u0b94\0\u0bc8\0\u0bfc"+
    "\0\u0c30\0\u0c64\0\u0c98\0\u0ccc\0\64\0\u0d00\0\u0d34\0\u0d68"+
    "\0\u0d9c\0\64\0\u0dd0\0\u0e04\0\u0e38\0\u0e6c\0\u0ea0\0\u0ed4"+
    "\0\u0f08\0\234\0\u0f3c\0\u0f70\0\u0fa4\0\u0fd8\0\234\0\u100c"+
    "\0\234\0\u1040\0\u1074\0\u10a8\0\u10dc\0\u1110\0\234\0\234"+
    "\0\u1144\0\u1178\0\u11ac\0\u11e0\0\u1214\0\u1248\0\u127c\0\u12b0"+
    "\0\234\0\234\0\234\0\u12e4\0\u1318\0\234\0\u134c\0\234"+
    "\0\u1380\0\234\0\u13b4\0\234\0\u13e8\0\u141c\0\u1450\0\u1484"+
    "\0\u14b8\0\u14ec\0\u1520\0\234\0\u1554\0\234\0\u1588\0\u15bc"+
    "\0\234\0\u15f0\0\234\0\u1624\0\u1658\0\u168c\0\234\0\234"+
    "\0\u16c0\0\u16f4\0\u1728\0\u175c\0\234\0\u1790\0\234";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[167];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\4\1\6\1\4\1\7"+
    "\1\10\1\11\1\12\1\13\1\14\1\2\1\4\1\15"+
    "\1\2\1\16\1\2\1\17\1\20\1\21\2\4\1\22"+
    "\1\23\1\24\2\14\1\25\1\4\1\26\1\27\1\26"+
    "\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37"+
    "\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47"+
    "\1\50\1\51\65\0\1\4\1\52\17\4\3\0\12\4"+
    "\3\0\1\4\22\0\21\4\3\0\12\4\3\0\1\4"+
    "\22\0\1\4\1\53\17\4\3\0\1\4\1\54\10\4"+
    "\3\0\1\4\22\0\7\4\1\55\11\4\3\0\12\4"+
    "\3\0\1\4\22\0\2\4\1\56\1\4\1\57\10\4"+
    "\1\60\3\4\3\0\12\4\3\0\1\4\22\0\2\4"+
    "\1\61\1\4\1\62\14\4\3\0\12\4\3\0\1\4"+
    "\22\0\21\4\3\0\1\4\1\63\3\4\1\64\4\4"+
    "\3\0\1\4\22\0\1\4\1\65\10\4\1\66\2\4"+
    "\1\67\3\4\3\0\12\4\3\0\1\4\22\0\7\4"+
    "\1\70\11\4\3\0\3\4\1\71\6\4\3\0\1\4"+
    "\35\0\1\14\2\0\1\14\2\72\1\73\10\0\2\14"+
    "\47\0\2\72\1\73\42\0\7\4\1\74\11\4\3\0"+
    "\2\4\1\75\7\4\3\0\1\4\35\0\1\76\2\0"+
    "\1\77\13\0\2\76\27\0\24\100\1\0\37\100\1\0"+
    "\4\4\1\101\14\4\3\0\12\4\3\0\1\4\22\0"+
    "\4\4\1\102\14\4\3\0\2\4\1\103\7\4\3\0"+
    "\1\4\22\0\2\4\1\104\16\4\3\0\12\4\3\0"+
    "\1\4\22\0\15\4\1\105\3\4\3\0\12\4\3\0"+
    "\1\4\22\0\2\4\1\106\16\4\3\0\12\4\3\0"+
    "\1\4\21\0\41\27\1\0\22\27\54\0\1\107\63\0"+
    "\1\110\1\111\62\0\1\112\1\0\1\113\61\0\1\114"+
    "\10\0\2\4\1\115\16\4\3\0\12\4\3\0\1\4"+
    "\22\0\11\4\1\116\7\4\3\0\12\4\3\0\1\4"+
    "\22\0\21\4\3\0\10\4\1\117\1\4\3\0\1\4"+
    "\22\0\7\4\1\120\11\4\3\0\12\4\3\0\1\4"+
    "\22\0\21\4\3\0\2\4\1\121\7\4\3\0\1\4"+
    "\22\0\4\4\1\122\14\4\3\0\12\4\3\0\1\4"+
    "\22\0\11\4\1\123\7\4\3\0\12\4\3\0\1\4"+
    "\22\0\11\4\1\124\7\4\3\0\12\4\3\0\1\4"+
    "\22\0\21\4\3\0\4\4\1\125\5\4\3\0\1\4"+
    "\22\0\4\4\1\126\14\4\3\0\12\4\3\0\1\4"+
    "\22\0\21\4\3\0\1\4\1\127\10\4\3\0\1\4"+
    "\22\0\1\130\20\4\3\0\12\4\3\0\1\4\22\0"+
    "\20\4\1\131\3\0\12\4\3\0\1\4\22\0\10\4"+
    "\1\132\1\133\7\4\3\0\12\4\3\0\1\4\35\0"+
    "\1\134\2\0\1\135\3\0\1\136\7\0\2\134\43\0"+
    "\1\137\2\0\1\137\13\0\2\137\30\0\21\4\3\0"+
    "\10\4\1\140\1\4\3\0\1\4\22\0\10\4\1\141"+
    "\10\4\3\0\12\4\3\0\1\4\35\0\1\76\2\0"+
    "\1\76\2\72\1\73\10\0\2\76\53\0\1\142\40\0"+
    "\1\4\1\143\17\4\3\0\12\4\3\0\1\4\22\0"+
    "\21\4\3\0\2\4\1\144\7\4\3\0\1\4\22\0"+
    "\2\4\1\145\16\4\3\0\12\4\3\0\1\4\22\0"+
    "\2\4\1\146\16\4\3\0\12\4\3\0\1\4\22\0"+
    "\12\4\1\147\6\4\3\0\12\4\3\0\1\4\22\0"+
    "\3\4\1\150\15\4\3\0\12\4\3\0\1\4\22\0"+
    "\10\4\1\151\10\4\3\0\12\4\3\0\1\4\22\0"+
    "\21\4\3\0\2\4\1\152\7\4\3\0\1\4\22\0"+
    "\1\4\1\153\17\4\3\0\12\4\3\0\1\4\22\0"+
    "\21\4\3\0\1\4\1\154\10\4\3\0\1\4\22\0"+
    "\1\155\20\4\3\0\12\4\3\0\1\4\22\0\1\156"+
    "\20\4\3\0\12\4\3\0\1\4\22\0\20\4\1\157"+
    "\3\0\12\4\3\0\1\4\22\0\2\4\1\160\16\4"+
    "\3\0\12\4\3\0\1\4\22\0\7\4\1\161\11\4"+
    "\3\0\12\4\3\0\1\4\22\0\11\4\1\162\7\4"+
    "\3\0\12\4\3\0\1\4\22\0\20\4\1\163\3\0"+
    "\12\4\3\0\1\4\35\0\1\134\2\0\1\134\13\0"+
    "\2\134\43\0\1\134\2\0\1\135\13\0\2\134\43\0"+
    "\1\137\2\0\1\164\2\72\11\0\2\137\30\0\12\4"+
    "\1\165\6\4\3\0\5\4\1\166\4\4\3\0\1\4"+
    "\22\0\20\4\1\167\3\0\12\4\3\0\1\4\22\0"+
    "\10\4\1\170\10\4\3\0\12\4\3\0\1\4\22\0"+
    "\10\4\1\127\10\4\3\0\12\4\3\0\1\4\22\0"+
    "\4\4\1\171\14\4\3\0\12\4\3\0\1\4\22\0"+
    "\21\4\3\0\2\4\1\172\7\4\3\0\1\4\22\0"+
    "\21\4\3\0\2\4\1\173\7\4\3\0\1\4\22\0"+
    "\1\4\1\174\17\4\3\0\12\4\3\0\1\4\22\0"+
    "\11\4\1\175\7\4\3\0\12\4\3\0\1\4\22\0"+
    "\4\4\1\176\14\4\3\0\12\4\3\0\1\4\22\0"+
    "\1\4\1\177\17\4\3\0\12\4\3\0\1\4\22\0"+
    "\1\4\1\200\17\4\3\0\12\4\3\0\1\4\22\0"+
    "\21\4\3\0\6\4\1\201\1\202\2\4\3\0\1\4"+
    "\22\0\10\4\1\203\10\4\3\0\12\4\3\0\1\4"+
    "\22\0\1\4\1\204\17\4\3\0\12\4\3\0\1\4"+
    "\22\0\3\4\1\205\15\4\3\0\12\4\3\0\1\4"+
    "\35\0\1\137\2\0\1\164\13\0\2\137\30\0\21\4"+
    "\3\0\3\4\1\206\6\4\3\0\1\4\22\0\15\4"+
    "\1\207\3\4\3\0\12\4\3\0\1\4\22\0\11\4"+
    "\1\210\7\4\3\0\12\4\3\0\1\4\22\0\20\4"+
    "\1\211\3\0\12\4\3\0\1\4\22\0\20\4\1\212"+
    "\3\0\12\4\3\0\1\4\22\0\4\4\1\213\14\4"+
    "\3\0\12\4\3\0\1\4\22\0\10\4\1\214\10\4"+
    "\3\0\12\4\3\0\1\4\22\0\6\4\1\215\12\4"+
    "\3\0\12\4\3\0\1\4\22\0\4\4\1\216\14\4"+
    "\3\0\12\4\3\0\1\4\22\0\2\4\1\217\16\4"+
    "\3\0\12\4\3\0\1\4\22\0\21\4\3\0\1\4"+
    "\1\220\10\4\3\0\1\4\22\0\20\4\1\221\3\0"+
    "\12\4\3\0\1\4\22\0\12\4\1\222\6\4\3\0"+
    "\12\4\3\0\1\4\22\0\4\4\1\223\14\4\3\0"+
    "\12\4\3\0\1\4\22\0\5\4\1\224\13\4\3\0"+
    "\12\4\3\0\1\4\22\0\11\4\1\225\7\4\3\0"+
    "\12\4\3\0\1\4\22\0\21\4\3\0\2\4\1\226"+
    "\7\4\3\0\1\4\22\0\3\4\1\227\15\4\3\0"+
    "\12\4\3\0\1\4\22\0\6\4\1\230\12\4\3\0"+
    "\12\4\3\0\1\4\22\0\1\4\1\231\17\4\3\0"+
    "\12\4\3\0\1\4\22\0\21\4\3\0\2\4\1\232"+
    "\7\4\3\0\1\4\22\0\7\4\1\233\11\4\3\0"+
    "\12\4\3\0\1\4\22\0\20\4\1\234\3\0\12\4"+
    "\3\0\1\4\22\0\1\4\1\235\17\4\3\0\12\4"+
    "\3\0\1\4\22\0\11\4\1\236\7\4\3\0\12\4"+
    "\3\0\1\4\22\0\20\4\1\237\3\0\12\4\3\0"+
    "\1\4\22\0\1\4\1\240\17\4\3\0\12\4\3\0"+
    "\1\4\22\0\4\4\1\241\14\4\3\0\12\4\3\0"+
    "\1\4\22\0\12\4\1\242\6\4\3\0\12\4\3\0"+
    "\1\4\22\0\5\4\1\243\13\4\3\0\12\4\3\0"+
    "\1\4\22\0\2\4\1\244\16\4\3\0\12\4\3\0"+
    "\1\4\22\0\10\4\1\245\10\4\3\0\12\4\3\0"+
    "\1\4\22\0\7\4\1\246\11\4\3\0\12\4\3\0"+
    "\1\4\22\0\10\4\1\247\10\4\3\0\12\4\3\0"+
    "\1\4\21\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[6084];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\23\1\1\11\1\1\12\11\4\1\4\11"+
    "\20\1\2\0\4\1\1\0\6\1\6\11\20\1\1\11"+
    "\1\0\3\1\1\11\21\1\1\0\63\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[167];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Scanner(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Scanner(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 134) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 60: 
          { return new Symbol(sym.BOOLEAN, yyline+1, yycolumn+1, yytext() );
          }
        case 66: break;
        case 34: 
          { return new Symbol(sym.OUT, yyline+1, yycolumn+1, yytext() );
          }
        case 67: break;
        case 50: 
          { return new Symbol(sym.SWAP1, yyline+1, yycolumn+1, yytext() );
          }
        case 68: break;
        case 10: 
          { return new Symbol(sym.LLAVECIERRE, yyline+1, yycolumn+1, yytext() );
          }
        case 69: break;
        case 2: 
          { return new Symbol(sym.IDENTIFICADOR, yyline+1, yycolumn+1, yytext() );
          }
        case 70: break;
        case 35: 
          { return new Symbol(sym.AND, yyline+1, yycolumn+1, yytext() );
          }
        case 71: break;
        case 61: 
          { return new Symbol(sym.ENDWHILE, yyline+1, yycolumn+1, yytext() );
          }
        case 72: break;
        case 33: 
          { return new Symbol(sym.DISTINTO, yyline+1, yycolumn+1, yytext() );
          }
        case 73: break;
        case 27: 
          { return new Symbol(sym.DO, yyline+1, yycolumn+1, yytext() );
          }
        case 74: break;
        case 21: 
          { return new Symbol(sym.DIV, yyline+1, yycolumn+1, yytext() );
          }
        case 75: break;
        case 32: 
          { return new Symbol(sym.DESPDER, yyline+1, yycolumn+1, yytext() );
          }
        case 76: break;
        case 37: 
          { return new Symbol(sym.NAT, yyline+1, yycolumn+1, yytext() );
          }
        case 77: break;
        case 58: 
          { return new Symbol(sym.NATURAL, yyline+1, yycolumn+1, yytext() );
          }
        case 78: break;
        case 42: 
          { return new Symbol(sym.CALL, yyline+1, yycolumn+1, yytext() );
          }
        case 79: break;
        case 56: 
          { return new Symbol(sym.CONSTS, yyline+1, yycolumn+1, yytext() );
          }
        case 80: break;
        case 11: 
          { return new Symbol(sym.CORCAP, yyline+1, yycolumn+1, yytext() );
          }
        case 81: break;
        case 20: 
          { return new Symbol(sym.MULT, yyline+1, yycolumn+1, yytext() );
          }
        case 82: break;
        case 23: 
          { return new Symbol(sym.OR, yyline+1, yycolumn+1, yytext() );
          }
        case 83: break;
        case 9: 
          { return new Symbol(sym.LLAVEAP, yyline+1, yycolumn+1, yytext() );
          }
        case 84: break;
        case 1: 
          { throw new Error("Caracter no reconocido: "+ (yyline+1) + " " + (yycolumn+1) + " " + yytext());
          }
        case 85: break;
        case 6: 
          { return new Symbol(sym.BARRABAJA, yyline+1, yycolumn+1, yytext() );
          }
        case 86: break;
        case 31: 
          { return new Symbol(sym.MAYORIGUAL, yyline+1, yycolumn+1, yytext() );
          }
        case 87: break;
        case 39: 
          { return new Symbol(sym.REAL, yyline+1, yycolumn+1, yytext() );
          }
        case 88: break;
        case 26: 
          { return new Symbol(sym.ENTERO, yyline+1, yycolumn+1, yytext() );
          }
        case 89: break;
        case 40: 
          { return new Symbol(sym.CARACTER, yyline+1, yycolumn+1, yytext() );
          }
        case 90: break;
        case 52: 
          { return new Symbol(sym.TIPOS, yyline+1, yycolumn+1, yytext() );
          }
        case 91: break;
        case 8: 
          { return new Symbol(sym.PCIERRE, yyline+1, yycolumn+1, yytext() );
          }
        case 92: break;
        case 13: 
          { return new Symbol(sym.COMA, yyline+1, yycolumn+1, yytext() );
          }
        case 93: break;
        case 18: 
          { return new Symbol(sym.MAYOR, yyline+1, yycolumn+1, yytext() );
          }
        case 94: break;
        case 25: 
          { return new Symbol(sym.IF, yyline+1, yycolumn+1, yytext() );
          }
        case 95: break;
        case 7: 
          { return new Symbol(sym.PAP, yyline+1, yycolumn+1, yytext() );
          }
        case 96: break;
        case 43: 
          { return new Symbol(sym.CHAR, yyline+1, yycolumn+1, yytext() );
          }
        case 97: break;
        case 59: 
          { return new Symbol(sym.INTEGER, yyline+1, yycolumn+1, yytext() );
          }
        case 98: break;
        case 46: 
          { return new Symbol(sym.THEN, yyline+1, yycolumn+1, yytext() );
          }
        case 99: break;
        case 4: 
          { return new Symbol(sym.MENOS, yyline+1, yycolumn+1, yytext() );
          }
        case 100: break;
        case 22: 
          { return new Symbol(sym.MOD, yyline+1, yycolumn+1, yytext() );
          }
        case 101: break;
        case 12: 
          { return new Symbol(sym.CORCCIERRE, yyline+1, yycolumn+1, yytext() );
          }
        case 102: break;
        case 63: 
          { return new Symbol(sym.SUBPROGRAM, yyline+1, yycolumn+1, yytext() );
          }
        case 103: break;
        case 28: 
          { return new Symbol(sym.IGUALIGUAL, yyline+1, yycolumn+1, yytext() );
          }
        case 104: break;
        case 38: 
          { return new Symbol(sym.INT, yyline+1, yycolumn+1, yytext() );
          }
        case 105: break;
        case 51: 
          { return new Symbol(sym.SWAP2, yyline+1, yycolumn+1, yytext() );
          }
        case 106: break;
        case 36: 
          { return new Symbol(sym.NOT, yyline+1, yycolumn+1, yytext() );
          }
        case 107: break;
        case 55: 
          { return new Symbol(sym.WHILE, yyline+1, yycolumn+1, yytext() );
          }
        case 108: break;
        case 49: 
          { return new Symbol(sym.CONST, yyline+1, yycolumn+1, yytext() );
          }
        case 109: break;
        case 54: 
          { return new Symbol(sym.FLOAT, yyline+1, yycolumn+1, yytext() );
          }
        case 110: break;
        case 44: 
          { return new Symbol(sym.BOOLEANO, yyline+1, yycolumn+1, yytext() );
          }
        case 111: break;
        case 53: 
          { return new Symbol(sym.ENDIF, yyline+1, yycolumn+1, yytext() );
          }
        case 112: break;
        case 65: 
          { return new Symbol(sym.INSTRUCTIONS, yyline+1, yycolumn+1, yytext() );
          }
        case 113: break;
        case 3: 
          { return new Symbol(sym.NATURALES, yyline+1, yycolumn+1, yytext() );
          }
        case 114: break;
        case 24: 
          { return new Symbol(sym.IN, yyline+1, yycolumn+1, yytext() );
          }
        case 115: break;
        case 30: 
          { return new Symbol(sym.DESPIZQ, yyline+1, yycolumn+1, yytext() );
          }
        case 116: break;
        case 29: 
          { return new Symbol(sym.MENORIGUAL, yyline+1, yycolumn+1, yytext() );
          }
        case 117: break;
        case 41: 
          { return new Symbol(sym.VAR, yyline+1, yycolumn+1, yytext() );
          }
        case 118: break;
        case 16: 
          { return new Symbol(sym.IGUAL, yyline+1, yycolumn+1, yytext() );
          }
        case 119: break;
        case 45: 
          { return new Symbol(sym.TIPO, yyline+1, yycolumn+1, yytext() );
          }
        case 120: break;
        case 14: 
          { return new Symbol(sym.DOSPUNTOS, yyline+1, yycolumn+1, yytext() );
          }
        case 121: break;
        case 64: 
          { return new Symbol(sym.SUBPROGRAMS, yyline+1, yycolumn+1, yytext() );
          }
        case 122: break;
        case 57: 
          { return new Symbol(sym.PROGRAM, yyline+1, yycolumn+1, yytext() );
          }
        case 123: break;
        case 62: 
          { return new Symbol(sym.CHARACTER, yyline+1, yycolumn+1, yytext() );
          }
        case 124: break;
        case 48: 
          { return new Symbol(sym.VARS, yyline+1, yycolumn+1, yytext() );
          }
        case 125: break;
        case 47: 
          { return new Symbol(sym.ELSE, yyline+1, yycolumn+1, yytext() );
          }
        case 126: break;
        case 17: 
          { return new Symbol(sym.MENOR, yyline+1, yycolumn+1, yytext() );
          }
        case 127: break;
        case 19: 
          { return new Symbol(sym.MAS, yyline+1, yycolumn+1, yytext() );
          }
        case 128: break;
        case 5: 
          { 
          }
        case 129: break;
        case 15: 
          { return new Symbol(sym.PUNTOYCOMA, yyline+1, yycolumn+1, yytext() );
          }
        case 130: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(sym.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
