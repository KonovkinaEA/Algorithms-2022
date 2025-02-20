package lesson7;

import kotlin.NotImplementedError;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class JavaDynamicTasks {
    /**
     * Наибольшая общая подпоследовательность.
     * Средняя
     *
     * Дано две строки, например "nematode knowledge" и "empty bottle".
     * Найти их самую длинную общую подпоследовательность -- в примере это "emt ole".
     * Подпоследовательность отличается от подстроки тем, что её символы не обязаны идти подряд
     * (но по-прежнему должны быть расположены в исходной строке в том же порядке).
     * Если общей подпоследовательности нет, вернуть пустую строку.
     * Если есть несколько самых длинных общих подпоследовательностей, вернуть любую из них.
     * При сравнении подстрок, регистр символов *имеет* значение.
     */
    public static String longestCommonSubSequence(String first, String second) {
        if (first == null || second == null) return "";
        int m = first.length();
        int n = second.length();
        if (m == 0 || n == 0) return "";
        if (first.equals(second)) return first;
        int[][] matrix = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (first.charAt(i) == second.charAt(j)) {
                    matrix[i + 1][j + 1] = matrix[i][j] + 1;
                }
                else {
                    matrix[i + 1][j + 1] = Math.max(matrix[i + 1][j], matrix[i][j + 1]);
                }
        int i = m;
        int j = n;
        StringBuilder res = new StringBuilder();
        while (i != 0 && j != 0) {
            if (matrix[i][j] == matrix[i - 1][j])
                i--;
            else if (matrix[i][j] == matrix[i][j - 1])
                j--;
            else {
                assert first.charAt(i - 1) == second.charAt(j - 1);
                res.append(first.charAt(i - 1));
                i--;
                j--;
            }
        }
        return res.reverse().toString();
    }
    // Трудоемкость = O(m * n)
    // Ресурсоемкость = O(m * n)

    /**
     * Наибольшая возрастающая подпоследовательность
     * Сложная
     *
     * Дан список целых чисел, например, [2 8 5 9 12 6].
     * Найти в нём самую длинную возрастающую подпоследовательность.
     * Элементы подпоследовательности не обязаны идти подряд,
     * но должны быть расположены в исходном списке в том же порядке.
     * Если самых длинных возрастающих подпоследовательностей несколько (как в примере),
     * то вернуть ту, в которой числа расположены раньше (приоритет имеют первые числа).
     * В примере ответами являются 2, 8, 9, 12 или 2, 5, 9, 12 -- выбираем первую из них.
     */
    public static List<Integer> longestIncreasingSubSequence(List<Integer> list) {
        int seqSize = list.size();
        if (seqSize <= 1) return list;
        int[] max = new int[seqSize];
        int[] res = new int[seqSize];
        for (int i = 0; i < seqSize; i++) {
            max[i] = 1;
            res[i] = -1;
            for (int j = 0; j < seqSize; j++) {
                if (list.get(j) < list.get(i) && max[j] + 1 > max[i]) {
                    max[i] = max[j] + 1;
                    res[i] = j;
                }
            }
        }
        int ind = 0;
        int length = max[0];
        for (int i = 0; i < seqSize; i++) {
            if (max[i] > length) {
                ind = i;
                length = max[i];
            }
        }
        List<Integer> resSeq = new ArrayList<>();
        while (ind != -1) {
            resSeq.add(0, list.get(ind));
            ind = res[ind];
        }
        return resSeq;
    }
    // Трудоемкость = O(N^2)
    // Ресурсоемкость = O(N)

    /**
     * Самый короткий маршрут на прямоугольном поле.
     * Средняя
     *
     * В файле с именем inputName задано прямоугольное поле:
     *
     * 0 2 3 2 4 1
     * 1 5 3 4 6 2
     * 2 6 2 5 1 3
     * 1 4 3 2 6 2
     * 4 2 3 1 5 0
     *
     * Можно совершать шаги длиной в одну клетку вправо, вниз или по диагонали вправо-вниз.
     * В каждой клетке записано некоторое натуральное число или нуль.
     * Необходимо попасть из верхней левой клетки в правую нижнюю.
     * Вес маршрута вычисляется как сумма чисел со всех посещенных клеток.
     * Необходимо найти маршрут с минимальным весом и вернуть этот минимальный вес.
     *
     * Здесь ответ 2 + 3 + 4 + 1 + 2 = 12
     */
    public static int shortestPathOnField(String inputName) {
        throw new NotImplementedError();
    }
}
