package course1.homework

object L066_PlusOne {

    @JvmStatic
    fun main(args: Array<String>) {
        plusOne(intArrayOf(9, 9, 9))
    }

    /**
     * 66. 加一
     */
    fun plusOne(digits: IntArray): IntArray {
        for (i in digits.size - 1 downTo 0) {
            digits[i]++
            digits[i] = digits[i] % 10
            if (digits[i] != 0) return digits
        }
        val newDigits = IntArray(digits.size + 1)
        newDigits[0] = 1
        return newDigits
    }

}