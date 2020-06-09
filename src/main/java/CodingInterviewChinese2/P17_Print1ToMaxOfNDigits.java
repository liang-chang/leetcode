package CodingInterviewChinese2;

public class P17_Print1ToMaxOfNDigits {

    public static void main(String[] args) {
        Print1ToMaxOfNDigits_2(3);


    }

    public static void Print1ToMaxOfNDigits_2(int n) {
        if (n <= 0)
            return;

        char[] number = new char[n + 1];
        number[n] = '\0';

        for (int i = 0; i < 10; ++i) {
            number[0] = (char) (i + '0');
            Print1ToMaxOfNDigitsRecursively(number, n, 0);
        }

    }

    public static void Print1ToMaxOfNDigitsRecursively(char[] number, int length, int index) {
        if (index == length - 1) {
            PrintNumber(number);
            return;
        }

        for (int i = 0; i < 10; ++i) {
            number[index + 1] = (char) (i + '0');
            Print1ToMaxOfNDigitsRecursively(number, length, index + 1);
        }
    }

    // ====================公共函数====================
// 字符串number表示一个数字，数字有若干个0开头
// 打印出这个数字，并忽略开头的0
    public static void PrintNumber(char[] number) {
        boolean isBeginning0 = true;
        int nLength = number.length;

        for (int i = 0; i < nLength; ++i) {
            if (isBeginning0 && number[i] != '0')
                isBeginning0 = false;

            if (!isBeginning0) {
                System.out.print(number[i]);
            }
        }

        System.out.println("\t");
    }
}
