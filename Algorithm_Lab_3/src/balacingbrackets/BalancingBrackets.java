package balacingbrackets;

import java.util.*;

public class BalancingBrackets {
    static boolean areBracketsBalanced(String expr)
    {
        Stack<Character> stack = new Stack<Character>();
        for (int index = 0; index < expr.length(); index++)
        {
            char character = expr.charAt(index);
 
            if (character == '(' || character == '[' || character == '{')
            {
                stack.push(character);
                continue;
            }
            if (stack.isEmpty())
                return false;
            char c;
            switch (character) {
            case ')':
                c = stack.pop();
                if (c == '{' || c == '[')
                    return false;
                break;
 
            case '}':
                c = stack.pop();
                if (c == '(' || c == '[')
                    return false;
                break;
 
            case ']':
                c = stack.pop();
                if (c == '(' || c == '{')
                    return false;
                break;
            }
        }
 
        return (stack.isEmpty());
    }
 
    public static void main(String[] args)
    {
        String expr = "([{{}}])";
        if (areBracketsBalanced(expr))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");
    }
}
