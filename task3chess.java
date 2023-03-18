// На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга. И вывести Доску. Пример вывода доски 8x8

public class task3chess {
    private int[] column; // Есть ли ферзь на доске в том же столбце, 1 - есть.
    private int[] rightup; // Есть ли ферзь на доске сверху справа налево снизу, 1 - есть
    private int[] leftup; // Есть ферзь на доске сверху слева направо снизу, 1 - есть
    private int[] queen; // ответ
    private int num; // Счетчик

    public task3chess() {
        column = new int[9];
        rightup = new int[17];
        leftup = new int[17];
        for (int i = 1; i < 9; i++)
            column[i] = 0;
        for (int i = 1; i < 17; i++)
            rightup[i] = leftup[i] = 0; // Исходное определение - все без ферзя
        queen = new int[9];
    }

    public void backtrack(int i) {
        if (i >= 9) {
            printchess();
        } else {
            for (int j = 1; j < 9; j++) {
// Условия для установки ферзя:                
                if ((column[j] == 0) && (rightup[i + j] == 0) && (leftup[i - j + 9 - 1] == 0)) {
// Если нет ферзя, все по нулям то ставим ферзя.
                    queen[i] = j; 
                    column[j] = rightup[i + j] = leftup[i - j + 9 - 1] = 1;
                    backtrack(i + 1); //  рекурсивный вызов
                    column[j] = rightup[i + j] = leftup[i - j + 9 - 1] = 0;
                }
            }
        }
    }

    public void printchess() {
        num++;
        System.out.println("\nОтвет" + num);
        for (int y = 1; y < 9; y++) {
            for (int x = 1; x < 9; x++) {
                if (queen[y] == x) {
                    System.out.print("|Q");
                } else {
                    System.out.print("|_");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        task3chess queen = new task3chess();
        queen.backtrack(1);
    }
}
