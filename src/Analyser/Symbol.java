package Analyser;

import Tokenizer.TokenType;

import java.util.ArrayList;

public class Symbol {
//    private String name;
//    private int chain=-1;
//    private TokenType type;
//    private boolean isConst=false;
//    private boolean isFn=false;
//    private ArrayList<TokenType> params=null;
//    private SymbolType symbolType;
//    private int fnoffset;
//    private int offset;
//
    private String name;
    private int chain=-1;
    private int fnOffset;
    private int offSet;
    private TokenType tokenType;
    private SymbolType symbolType;
    private boolean isConst=false;
    private boolean isFn=false;
    private ArrayList<TokenType> paramsList=null;


    public Symbol(String name, int chain, TokenType tokenType, SymbolType symbolType, boolean isConst,  int offset){
        this.name = name;
        this.chain = chain;
        this.tokenType = tokenType;
        this.isConst = isConst;
        this.symbolType = symbolType;
        this.offSet = offSet;
    }

    public Symbol(String name,boolean isFn, int fnOffset ,int offSet) {
        this.name = name;
        this.isFn = isFn;
        this.fnOffset = fnOffset;
        this.offSet = offSet;
        this.paramsList = new ArrayList<TokenType>();
        this.symbolType = SymbolType.global;
        this.isConst = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChain() {
        return chain;
    }

    public void setChain(int chain) {
        this.chain = chain;
    }

    public int getFnOffset() {
        return fnOffset;
    }

    public void setFnOffset(int fnOffset) {
        this.fnOffset = fnOffset;
    }

    public int getOffSet() {
        return offSet;
    }

    public void setOffSet(int offSet) {
        this.offSet = offSet;
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public void setTokenType(TokenType tokenType) {
        this.tokenType = tokenType;
    }

    public Analyser.SymbolType getSymbolType() {
        return symbolType;
    }

    public void setSymbolType(Analyser.SymbolType symbolType) {
        this.symbolType = symbolType;
    }

    public boolean isConst() {
        return isConst;
    }

    public void setConst(boolean aConst) {
        isConst = aConst;
    }

    public boolean isFn() {
        return isFn;
    }

    public void setFn(boolean fn) {
        isFn = fn;
    }

    public ArrayList<TokenType> getParamsList() {
        return paramsList;
    }

    public void setParamsList(ArrayList<TokenType> paramsList) {
        this.paramsList = paramsList;
    }
//    public Symbol(String name, int chain, TokenType type, boolean isConst, SymbolType symbolType, int offset) {
//        this.name = name;
//        this.chain = chain;
//        this.type = type;
//        this.isConst = isConst;
//        this.symbolType = symbolType;
//        this.offset = offset;
//    }
//
//    public Symbol(String name,boolean isFn, int offset, int fnoffset) {
//        this.name = name;
//        this.isFn = isFn;
//        this.params = new ArrayList<TokenType>();
//        this.symbolType = SymbolType.global;
//        this.offset = offset;
//        this.fnoffset = fnoffset;
//        this.isConst = true;
//    }
//
//    public int getFnoffset() {
//        return fnoffset;
//    }
//
//    public void setFnoffset(int fnoffset) {
//        this.fnoffset = fnoffset;
//    }
//
//    public SymbolType getSymbolType() {
//        return symbolType;
//    }
//
//    public void setSymbolType(SymbolType symbolType) {
//        this.symbolType = symbolType;
//    }
//
//    public int getOffset() {
//        return offset;
//    }
//
//    public void setOffset(int offset) {
//        this.offset = offset;
//    }
//
//    public TokenType getType() {
//        return type;
//    }
//
//    public void setType(TokenType type) {
//        this.type = type;
//    }
//
//    public boolean isConst() {
//        return isConst;
//    }
//
//    public void setConst(boolean aConst) {
//        isConst = aConst;
//    }
//
//    public boolean isFn() {
//        return isFn;
//    }
//
//    public void setFn(boolean fn) {
//        isFn = fn;
//    }
//
//    public ArrayList<TokenType> getParams() {
//        return params;
//    }
//
//    public void setParams(ArrayList<TokenType> params) {
//        this.params = params;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getChain() {
//        return chain;
//    }
//
//    public void setChain(int chain) {
//        this.chain = chain;
//    }
}
