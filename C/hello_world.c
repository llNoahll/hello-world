#include<stdio.h>
#include<math.h>
int main(void)
{
    int i,z,x,y;
    char c;

    for(i=0;(c=getchar()!='=');)
    {
        if(i==0)
            scanf("%d%c%d",&x,&c,&y);
        else
            scanf("%c%d",&c,&y);
        for(i=1;i<=1;)
        {
            switch(c)
            {
                case'+':z=x+y;break;
                case'-':z=x-y;break;
                case'*':z=x*y;break;
                case'/':
                    if (fabs(y)<=1e-6)
                        printf("error");
                    else
                        z=x/y;
                    break;
                default:printf("error!\n");
                    break;
            }
            i=i+1;
        }
        x=z;
    }

    printf("%d", z);

    return 0;
}
