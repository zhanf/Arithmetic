package course1.week_1_1

import java.util.*

object L020_IsValid {

    /**
     * 20. 有效的括号
     */
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        val array = s.toCharArray()
        for (c in array) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c)
            } else {
                if (stack.isEmpty()) return false
                if (c == ')' && stack.peek() == '(') {
                    stack.pop()
                } else if (c == '}' && stack.peek() == '{') {
                    stack.pop()
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop()
                } else {
                    return false
                }
            }
        }
        return stack.isEmpty()
    }
}