#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define IN     // 输入参数
#define OUT    // 输出参数
#define de_create_select    printf("*********学生信息操作界面!*********\n");\
                            printf("0:退出程序。\n");\
                            printf("1:链表尾部插入数据。\n");\
                            printf("2:链表头部插入数据。\n");\
                            printf("3:自定义插入数据。\n");\
                            printf("4:输出所有学生信息。\n");\
                            printf("5:删除指定学号的学生节点。\n");\
                            printf("6:删除所有数据。\n");
#define de_ptrue (pnew->ID < 10000000 && pnew->ID > 0 \
                && pnew->grade[0] < 1000 && pnew->grade[0] > 0 \
                && pnew->grade[1] < 1000 && pnew->grade[1] > 0 \
                && pnew->grade[2] < 1000 && pnew->grade[2] > 0)
#define de_f_read (fscanf(fp, "%d-%d-%d-%d-%s" \
					, &f_id, &f_grade[0], &f_grade[1], &f_grade[2], f_name)) // 从文件中读取链表数据
typedef struct STUDENT{
    int ID;
    int grade[3];
	char name[20];
    struct STUDENT *next;
}stu;

typedef struct LINK{
    stu *head;
    stu *tail;
}Link;

void link_read	  (OUT Link *link);
void link_write   (IN  Link link);
void select       (void);
void link_last    (OUT Link *link);
void link_head    (OUT Link *link);
void link_choose  (OUT Link *link);
void link_delete  (OUT Link *link);
void showlink     (IN  Link link);
void deletelink   (OUT Link *link);

int main(void)
{
    de_create_select;
    select();

    return 0;
}

void link_read(OUT Link *link)
{
	int  f_id;
	int  f_grade[3];
	char f_name[20];
	stu *f_pnew, *f_q;
	FILE *fp = fopen("student.txt", "r");
	(*link).head = (stu*)malloc(sizeof(stu));

	if(NULL == fp)
		(*link).head = (*link).tail = NULL;
	else
	{
		f_q = (*link).head;
		while(EOF != de_f_read)
		{
			f_pnew = (stu*)malloc(sizeof(stu));
			f_pnew->ID = f_id;
			f_pnew->grade[0] = f_grade[0];
			f_pnew->grade[1] = f_grade[1];
			f_pnew->grade[2] = f_grade[2];
			strcpy(f_pnew->name, f_name);
			f_q->next = f_pnew;
			f_q = f_pnew;
		}// end of while(EOF != f_read)
		(*link).tail = f_q;
		(*link).tail->next = NULL;
		(*link).head = (*link).head->next;  // 链表头数据为空
	}
}

void link_write(IN Link link)
{
	stu *p;
	FILE *fp = fopen("student.txt", "w");
	if(NULL == fp)
	{
		printf("打开文件失败!\n");
		link.head = NULL;
	}
	for(p = link.head; NULL != p; p = p->next)
	{
		fprintf(fp, "%07d-%03d-%03d-%03d-%s\n"
				, p->ID, p->grade[0], p->grade[1], p->grade[2], p->name);
	}
	fprintf(fp,"\n");
}

void select(void)
{
	int a, b, c;
    Link link;
	link_read(OUT &link);
    printf("请输入您的选项:\n");
    scanf("%d",&b);
    fflush(stdin);

    c = b;
    while(b != 0)
    {
        switch(b)
        {
            case 1:// 链表尾部插入数据。
                link_last(OUT &link);
                printf("操作成功!返回操作界面。\n\n");
                break;

            case 2:// 链表头部插入数据。
                link_head(OUT &link);
                printf("操作成功!返回操作界面。\n\n");
                break;

            case 3:// 自定义插入数据。
                if(link.head != NULL)
                {
                    link_choose(OUT &link);
                    printf("操作成功!返回操作界面。\n\n");
                }
                else
                    printf("数据为空!返回操作界面。\n\n");

                break;

            case 4:// 输出所有学生信息。
                showlink(IN link);
                break;

            case 5://删除制定学号的学生节点。
                if( link.head != NULL)
                {
                    link_delete(OUT &link);
                    printf("操作成功!返回操作界面。\n\n");
                }
                else
                    printf("数据为空!返回操作界面。\n\n");

                break;

			case 6:// 删除所有数据。
				deletelink(&link);
                printf("操作成功!返回操作界面。\n\n");
				break;

            default:
                printf("不存在该选项!\n");
                printf("返回操作界面。\n\n");
                break;
        }// end of switch(b)

        de_create_select;    //显示操作界面
        printf("请输入您的选项:");
        fflush(stdin);
        scanf("%d",&a);

        b = a;
    }

    if(c==0||b==0)    // 选项为0的时候退出程序
	{
	    printf("***************E N D***************\n");
		link_write(IN link);
	}
}

void link_last(OUT Link *link)
{
    int id;
    char confirm;
    stu *last,*pnew;
    pnew = (stu*)malloc(sizeof(stu));
    pnew->next = NULL;

    printf("请按照下列输入学生信息:\n学生ID号-科目1成绩-科目2成绩-科目3成绩-姓名\n");
    printf("(ID号7位数, 成绩3位数; 输入0返回操作界面)\n");

again_last:

    scanf("%d-%d-%d-%d-%s",
          &pnew->ID,&pnew->grade[0],&pnew->grade[1],&pnew->grade[2],pnew->name);
	if(0 == pnew->ID);
	else
	{
		id = pnew->ID;
		fflush(stdin);

		if(de_ptrue)   // 如果数据无误
		{
			printf("请确认输入数据[y(Y) or n(N)]:\n%07d-%03d-%03d-%03d-%s\n",
					pnew->ID,pnew->grade[0],pnew->grade[1],pnew->grade[2],pnew->name);

confirm_last:

			scanf("%c", &confirm);
			fflush(stdin);

			if(confirm == 'n' || confirm == 'N')
			{
				printf("请重新输入数据:\n");
				goto again_last;
			}// end of if(confirm == 'n'||confirm == 'N')
			else if(confirm != 'y'&&confirm != 'Y'&&confirm != 'n'&&confirm !='N')
			{
				printf("请重新确认[y(Y) or n(N)]\n");
				goto confirm_last;
			}// end of else if(confirm != 'y'&&confirm != 'Y'&&confirm != 'n'&&confirm !='N')

			if((*link).head != NULL  &&  (confirm == 'y'||confirm == 'Y') )
			{
				for(last = (*link).head; last->next != NULL; last = last->next)
					if(last->ID == id)
					{
						printf("该ID已存在,请重新输入!\n");
						goto again_last;
					}/* end of for(last = (*link).head; last->next != NULL; last = last->next)
								   if(last->ID == id)*/

				(*link).tail->next = pnew;
				(*link).tail = pnew;
				printf("插入成功!\n");
			}// end of if(head&&(confirm == 'y'||confirm == 'Y'))
			else
			{
				(*link).head = pnew;
				(*link).tail = (*link).head;	// 将链表头尾连在一起
				printf("学生信息表创立成功!\n");
			}
		}// end of if(pture)
		else
		{
			printf("数据错误, 请重新输入:\n");
			goto again_last;
		}
	}// end of else
}

void link_head(OUT Link *link)
{
    int id;
    char confirm;
    stu *pnew,*last;
    pnew = (stu*)malloc(sizeof(stu));
    pnew->next = NULL;

    printf("请按照下列输入学生信息:\n学生ID号-科目1成绩-科目2成绩-科目3成绩-姓名\n");
    printf("(ID号7位数, 成绩3位数； 输入0返回操作界面)\n");

again_head:

    scanf("%d-%d-%d-%d-%s",
          &pnew->ID,&pnew->grade[0],&pnew->grade[1],&pnew->grade[2],pnew->name);
	if(0 == pnew->ID);
	else
	{
		id = pnew->ID;
		fflush(stdin);
		if(de_ptrue)
		{
			printf("请确认输入数据[y(Y) or n(N)]:\n%07d-%03d-%03d-%03d-%s\n",
				  pnew->ID,pnew->grade[0],pnew->grade[1],pnew->grade[2],pnew->name);

confirm_head:

			scanf("%c",&confirm);
			fflush(stdin);

			if(confirm == 'n'||confirm == 'N')
			{
				printf("请重新输入数据:\n");
				goto again_head;
			}
			else if(confirm != 'y'&&confirm != 'Y'&&confirm != 'n'&&confirm !='N')
			{
				printf("请重新确认[y(Y) or n(N)]\n");
				goto confirm_head;
			}

			if(confirm == 'y'||confirm == 'Y')
			{
				if( (*link).head != NULL)
					for(last = (*link).head; last->next != NULL; last = last->next)
						if(last->ID == id)
						{
							printf("该ID已存在,请重新输入!\n");
							goto again_head;
						}/* end of if(head != NULL)
								for(last = head; last->next != NULL; last = last->next)
									if(last->ID == id)*/
				pnew->next = (*link).head;
				(*link).head = pnew;
				if( (*link).head->next != NULL)
					printf("插入成功!\n");
				else
				{
					(*link).tail = (*link).head;	// 将链表头尾连在一起
					printf("学生信息表创立成功!\n");
				}

			}// end of if(confirm == 'y'||confirm == 'Y')
		}// end of if (ptrue)
		else
		{
			printf("数据错误, 请重新输入:\n");
			goto again_head;
		}
	}
}

void link_choose(OUT Link *link)
{
    Link aim;
    stu *paim;
    int id;
    printf("请输入插入节点后的节点对应的学生ID:\n");
	printf("(输入0返回操作界面)\n");

again_choose:

	scanf("%d",& id);
	fflush(stdin);
	if(0 == id);
	else
	{
		aim.head  = (*link).head;
		paim = (*link).head;

		while(aim.head->ID != id)
		{
			aim.head = aim.head->next;
			if(aim.head == NULL)
			{
				printf("您输入的学生ID不存在!请重新输入:\n");
				goto again_choose;
			}// end of if(aim == NULL)
		}// end of while(aim->ID != id)

		if(aim.head == (*link).head)    // 如果目标节点为头结点, 直接从头插入
			link_head(OUT link);
		else if(aim.head->ID == id)     // 将目标节点视为头结点从头插入, 在串上原链表
		{
			while(paim->next != aim.head)
				paim = paim->next;

			link_head(OUT &aim);
			paim->next = aim.head;
		}// end of else if(aim->ID == id)
	}
}

void link_delete(OUT Link *link)
{
    stu *paim, *aim;
    int id;
    printf("请输入要删除的学生ID:\n");
	printf("(输入0返回操作界面)\n");

again_delete:

    scanf("%d",&id);
    fflush(stdin);
	if(0 == id);
	else
	{
	    aim = (*link).head;
		paim= (*link).head;

		while(aim->ID != id)
		{
			aim = aim->next;
			if(aim == NULL)
			{
				printf("您输入的学生ID不存在!请重新输入:\n");
				goto again_delete;
			}// end if if(aim == NULL)
		}// end of while(aim->ID != id)

		if(aim == (*link).head)
		{
			(*link).head = (*link).head ->next;
			free(aim);
		}// end of if(aim == head)
		else if(aim->ID == id)
		{
			while(paim->next != aim)
				paim = paim->next;

			paim->next = aim->next;
			free(aim);
		}// end of else if(aim->ID == id)
	}
}

void showlink(IN Link link)
{
    stu *last;
    if( link.head != NULL)
    {
        printf("ID-科目1成绩-科目2成绩-科目3成绩-姓名\n");

        for(last = link.head;last->next != NULL;last = last->next)
            printf("%07d-%03d-%03d-%03d-%s\n",
                    last->ID,last->grade[0],last->grade[1],last->grade[2],last->name);
        printf("%07d-%03d-%03d-%03d-%s\n",
                last->ID,last->grade[0],last->grade[1],last->grade[2],last->name);

        printf("操作成功!返回操作界面。\n\n");
    }// end of if(head != NULL)
    else
        printf("数据为空!返回操作界面。\n\n");
}

void deletelink(OUT Link *link)
{
    stu *phead;
    while((*link).head != NULL)
    {
        phead = (*link).head;
        (*link).head = (*link).head->next;
        free(phead);
    }
}
