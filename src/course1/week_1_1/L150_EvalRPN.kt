package course1.week_1_1

import java.util.*

object L150_EvalRPN {

    @JvmStatic
    fun main(args: Array<String>) {
        println(evalRPN(arrayOf("4", "13", "5", "/", "+")))
    }

    /**
     * 150. 逆波兰表达式求值
     */
    fun evalRPN(tokens: Array<String>): Int {
        val stack = Stack<Long>()
        for (token in tokens) {
            if (token == "+" || token == "-" || token == "*" || token == "/") {
                //先pop是被除数
                val b = stack.pop()
                val a = stack.pop()
                stack.push(cal(a.toLong(), b.toLong(), token))
            } else {
                stack.push(token.toLong())
            }
        }
        return stack.peek().toInt()
    }

    private fun cal(a: Long, b: Long, token: String): Long {
        if (token == "+") return a + b
        if (token == "-") return a - b
        if (token == "*") return a * b
        if (token == "/") return a / b
        return 0L
    }

}