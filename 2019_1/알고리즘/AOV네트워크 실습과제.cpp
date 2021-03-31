#include<stdio.h>
#include<stdlib.h>
#define MAX_VERTICES 9

struct node {
	int	vertex;
	int duration;
	struct node *link;
};
typedef struct {
	int	count;
	struct node *link;
} hdnode;

hdnode graph[MAX_VERTICES];

int latest[MAX_VERTICES];
int earliest[MAX_VERTICES];
int stack[100];
int top = -1;

void add_stack(int v) {
	if (top < 99)
		stack[++top] = v;
	else {
		printf("stack is full\n");
		return;
	}

}
int stack_empty() {
	if (top < 0)
		return 1;
	else
		return 0;
}
int delete_stack() {
	if (stack_empty()) {
		printf("stack is empty");
		return -1;
	}
	else {
		return stack[top--];
	}
}

void topsort(hdnode graph[], int n)
{
	int	i, j, k;
	struct node	*ptr;

	top = -1; 	// Predecessor가 없는 vertex들의 stack 구성
	for (i = 0; i < n; i++)
		if (!graph[i].count)     add_stack(i);	 // stack에 추가

	for (i = 0; i < n; i++)
		if (stack_empty()) { fprintf(stderr, "Network has a cycle.\n"); exit(1); }
		else {
			j = delete_stack(); 	// Stack에서 제거
			printf("v%d  ", j);
			for (ptr = graph[j].link; ptr != NULL; ptr = ptr->link) {
				k = ptr->vertex;	// Successor vertex들의 count 감소
				graph[k].count--;
				if (!graph[k].count) { // 새로운 vertex를 stack에 삽입
					add_stack(k);
				}
				if (earliest[k] < earliest[j] + ptr->duration)
					earliest[k] = earliest[j] + ptr->duration;
				if (latest[k] > latest[j] - ptr->duration)
					latest[k] = latest[j] - ptr->duration;

			}
		}
}
void AddNode(node ** head, int v, int duration) {
	graph[v].count++;
	node * p = *head;
	node * temp = (node*)malloc(sizeof(node));
	temp->link = NULL;
	temp->vertex = v;
	temp->duration = duration;

	if (*head == NULL) {
		*head = temp;
		return;
	}

	while (p->link) {
		p = p->link;
	}
	p->link = temp;
}

int main() {
	AddNode(&graph[0].link, 1, 6);
	AddNode(&graph[0].link, 2, 4);
	AddNode(&graph[0].link, 3, 5);
	AddNode(&graph[1].link, 4, 1);
	AddNode(&graph[2].link, 4, 1);
	AddNode(&graph[3].link, 5, 2);
	AddNode(&graph[4].link, 6, 8);
	AddNode(&graph[4].link, 7, 6);
	AddNode(&graph[5].link, 7, 4);
	AddNode(&graph[6].link, 8, 2);
	AddNode(&graph[7].link, 8, 4);

	topsort(graph, MAX_VERTICES);

	printf("\n\nEarliest |  [0]  [1]  [2]  [3]  [4]  [5]  [6]  [7]  [8]\n");
	printf("---------|----------------------------------------------\n");
	printf("result   |");
	for (int i = 0; i < MAX_VERTICES; i++) {
		if (i == MAX_VERTICES - 1) {
			printf("%5d\n", earliest[i]);
		}
		else {
			printf("%5d", earliest[i]);
		}
	}
	printf("\n\nLatest   |  [0]  [1]  [2]  [3]  [4]  [5]  [6]  [7]  [8]\n");
	printf("---------|----------------------------------------------\n");
	printf("result   |");
	for (int i = 0; i < MAX_VERTICES; i++) {
		if (i == MAX_VERTICES - 1) {
			printf("%5d\n", latest[i] + 17);
		}
		else {
			printf("%5d", latest[i] + 17);
		}
	}
}