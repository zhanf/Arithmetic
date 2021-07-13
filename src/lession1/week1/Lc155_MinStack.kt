package lession1.week1
import java.util.*

object Lc155_MinStack {
    /**
     * 155. 最小栈
     */
    class MinStack() {

        private val minStack = Stack<Int>()
        private var stack = Stack<Int>()

        init {
            minStack.push(Int.MAX_VALUE)
        }

        fun push(`val`: Int) {
            stack.push(`val`)
            minStack.push(Math.min(`val`, minStack.peek()))
        }

        fun pop() {
            minStack.pop()
            stack.pop()
        }

        fun top(): Int {
            return stack.peek()
        }

        fun getMin(): Int {
            return minStack.peek()
        }

    }
}