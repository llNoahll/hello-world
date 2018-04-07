#include<stdio.h>
#include<stdlib.h>
#include<math.h>

#define MAX 100


int main(void)
{
    int order = 0;
    int matrix[MAX][MAX];
    /* int c[MAX], r[MAX]; */
    int number = 1;
    int i = 0, j = 0;
    int judge = 0;              /* 矩阵阶数的奇偶性 */

    printf("请输入矩阵的阶数:(0~100) ");
    scanf("%d", &order);
    while(order <= 0 || order > MAX)
    {
        printf("数据错误, 请重新输入矩阵阶数:(0~100) ");
        scanf("%d", &order);
    }
    judge = order % 2;
    order--;


    /* 计算下三角矩阵 */
    for(i=order; i >= 0; i--) {
        if(0 == i%2) {
            for(j=0; j <= order-i; j++) {
                matrix[i+j][j] = number++;
            }
        }
        else {
            for(j=0; j <= order-i; j++) {
                matrix[order-j][order-j-i] = number++;
            }
        }
    }

    /* 计算上三角矩阵 */
    printf("*********\n");
    int times = 0;
    for(i=order-1; i >= 0; i--) {
        if(judge == i % 2) {
            for(j=order; j >= order-i; j--) {
                matrix[(j-1)-times][j] = number++;
            }
        }
        else {
            for(j=order; j >= order-i; j--) {
                matrix[order-j][(order-j+1)+times] = number++;
            }
        }

        times++;
    }

    /* 输出矩阵 */
    printf("\n\n");
    for(i=0; i <= order; i++) {
        for(j=0; j <= order; j++) {
            printf("%5d", matrix[i][j]);
        }
        printf("\n");
    }


    return 0;
}
