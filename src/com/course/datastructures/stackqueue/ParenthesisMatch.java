package com.course.datastructures.stackqueue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ParenthesisMatch {
    public static final Map<Character, Character> matchingParenMap = new HashMap<>();
    public static final Set<Character> openingParenSet = new HashSet<>();

    static {
        matchingParenMap.put(')', '(');
        matchingParenMap.put(']', '[');
        matchingParenMap.put('}', '{');
        openingParenSet.addAll(matchingParenMap.values());
    }

    public boolean isValid(String expr){
        Stack<Character> parenStack = new Stack<>();
        for(int i = 0; i < expr.length(); i++){
            char ch = expr.charAt(i);
            if (openingParenSet.contains(ch)){
               parenStack.push(ch);
            }
            if(matchingParenMap.containsKey(ch)) {
                Character lastParen = parenStack.pop();
                if(matchingParenMap.get(ch) != lastParen){
                    return false;
                }
            }
        }
        return parenStack.isEmpty();
    }
}
